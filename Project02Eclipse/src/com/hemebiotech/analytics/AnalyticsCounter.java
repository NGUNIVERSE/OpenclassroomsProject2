package com.hemebiotech.analytics;


import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Read symptoms from a file , perform an alphabetical sort , count the number of symptoms occurrences, write it to an output file.
 * @author Maxwell
 *
 */
public class AnalyticsCounter {

	
	public static void main(String args[]){
		
		/* Lecture du fichier d'entrée et copie dans un tableau */
		String path = "Project02Eclipse/symptoms.txt";		
		ISymptomReader reader = new ReadSymptomDataFromFile(path);
		List<String> listSymptom = reader.getSymptoms();   	
		
		/* Calcul du nombre d'occurrences */
		Map<String,Integer> myMap = countOccurences(listSymptom);  

		/* Ecriture du fichier de sortie */
		String pathResults = "Project02Eclipse/results.out";	  
		ISymptomWriter writer = new WriteSymptomDataToFile(pathResults);
		writer.writeSymptoms(myMap); 	
	} 
	
	/**
	 * 	count the occurrence of symptoms from a list.
	 * @param listSymptomCountOccurences	The symptoms to count.
	 * @return a map which contain each symptoms the number of occurrences.
	 */
	public static Map<String,Integer> countOccurences(List<String> listSymptomCountOccurences)
	{
		/* Tri par ordre alphabétique */
		Map<String,Integer> mapCountOccurences = new TreeMap<>(); 
		
		/* nombre d'occurence des symptomes */
		for(String symptom:listSymptomCountOccurences) 
		{
			mapCountOccurences.put(symptom, mapCountOccurences.getOrDefault(symptom, 0)+1);
	        
	    }
		
		return mapCountOccurences;
	}
}

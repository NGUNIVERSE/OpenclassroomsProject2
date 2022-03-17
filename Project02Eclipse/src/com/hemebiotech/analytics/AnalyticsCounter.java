package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;


public class AnalyticsCounter {

	
	public static void main(String args[]) throws Exception {

		List<String> listSymptom = new ArrayList<String>();
		String path = "Project02Eclipse/symptoms.txt";
		
		ISymptomReader reader = new ReadSymptomDataFromFile(path); // Lecture du fichier
		listSymptom=reader.getSymptoms();   // copie dans un tableau	
	
		
		Map<String,Integer> myMap = new TreeMap<>(); // Trie par ordre alphabétique
		
		
		for(String symptom:listSymptom) // nombre d'occurence des symptomes
		{
	        	myMap.put(symptom, myMap.getOrDefault(symptom, 0)+1);
	        
	    }
		
		FileWriter writer = new FileWriter("result.out");      // création du fichier de sortie
		
        Set<String> keys = myMap.keySet(); 
        
        for(String key: keys)    // remplissage du fichier de sortie
        {
        	writer.write(key+" = "+myMap.get(key) + "\n");
         //   System.out.println(key+" = "+mapTriée.get(key));
        }
        writer.close();  // fermeture du fichier de sortie
		

	} 
}

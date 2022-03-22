package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
/**
 * Write symptoms occurrences to a file.
 * @author Maxwell
 *
 */
public class WriteSymptomDataToFile implements ISymptomWriter
{

	private String filepath;
	
	/**
	 * 
	 * @param filepath a full or partial path to file with symptom strings in it, one per line
	 */
	public WriteSymptomDataToFile(String filepath) {
		
		this.filepath = filepath;
	}
	
	@Override
	public void writeSymptoms(Map<String,Integer> map) 
	{
		
		if (filepath != null) 
		{
			/* création du fichier de sortie gestion des erreurs et fermeture du fichier */
			try( BufferedWriter writer = new BufferedWriter (new FileWriter(filepath))) 
			{
	
		        Set<String> keys = map.keySet(); 
		        
		     /* remplissage du fichier de sortie */
		        for(String key: keys)    
		        {
		        	writer.write(key+" = "+map.get(key) + "\n");
		        }
		        
			} 
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		else 
		{}		
		
	}
}

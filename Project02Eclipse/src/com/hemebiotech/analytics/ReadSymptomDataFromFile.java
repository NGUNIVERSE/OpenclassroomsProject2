package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Read symptoms from a file.
 *
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filepath;
	
	/**
	 * 
	 * @param filepath a full or partial path to file with symptom strings in it, one per line
	 */
	public ReadSymptomDataFromFile (String filepath) {
		this.filepath = filepath;
	}
	
	@Override
	public List<String> getSymptoms() {
		List<String> result = new ArrayList<String>();
		
		if (filepath != null) {
			/* Ouverture du fichier d'entrée, gestion des erreurs et fermeture du fichier */
			try( BufferedReader reader = new BufferedReader (new FileReader(filepath))) {
					String line = reader.readLine();
				
					while (line != null) {
					
						result.add(line);
						line = reader.readLine();

					}
					
			} 
			catch (IOException e) {
				e.printStackTrace();
				
			}
		}
		
		return result;
	}

}

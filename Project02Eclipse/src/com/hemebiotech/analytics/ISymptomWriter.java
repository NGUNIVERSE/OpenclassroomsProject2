package com.hemebiotech.analytics;

import java.util.Map;

/**
 * Write symptoms occurrences to any output as a file or database.
 */
public interface ISymptomWriter {
	/** 
	 * Write symptoms occurrences to the output.
	 *  
	 * @param map the symptoms occurrences to write.
	 */
	void writeSymptoms(Map<String,Integer> map);

}

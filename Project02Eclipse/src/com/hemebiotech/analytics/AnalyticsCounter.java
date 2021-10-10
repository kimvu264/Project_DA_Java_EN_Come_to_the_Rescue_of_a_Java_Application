package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 *  Methods for getting the symptoms list, then counting, sorting and writing in the file
 */
public class AnalyticsCounter {

    /** Map containing the symptoms as keys and their corresponding count as values */
    private Map<String, Integer> symptomMap = new HashMap<>();

    /**
     * Implement the symptom recovery functionality in the input file
     * @param input filepath for reading file
     * @return a list of symptoms with possible duplications
     */

    public List<String> getSymptoms(final String input) {
        ReadSymptomDataFromFile symptomsReader = new ReadSymptomDataFromFile(input);
        return symptomsReader.getSymptoms();
    }

    /**
     * Count the occurrences of symptoms in the list
     * @param symptoms a given list of symptoms with possible duplications
     */

    public void countSymptoms(final List<String> symptoms) {
        int count;
        for (final String symptom : symptoms) {
            if (!symptomMap.containsKey(symptom)) {
                symptomMap.put(symptom, 0);
            }
            count = symptomMap.get(symptom);
            count++;
            symptomMap.put(symptom, count);
        }
    }

    /**
     * Put the symptoms list in order alphabetic by using class TreeMap
     */
    public void sortSymptoms() {
        // Use TreeMap to order the symptom map by keys
        symptomMap = new TreeMap<>(symptomMap);
    }

    /**
     * Write the result in another file
     * @param output name of file output with the associated count given a list of symptoms in order alphabetic in it
     * @throws IOException if the named file exists but is a directory rather than a regular file, does not exist
                            but cannot be created, or cannot be opened for any other reason
     */

    public void writeResult(final String output) throws IOException {
        // Constructs a FileWriter object given a file name
        FileWriter writer = new FileWriter(output);
        symptomMap.forEach((key, value) -> {
            try {
                writer.write(key + " = " + value + "\n");
            } catch(IOException e) {
                e.printStackTrace();
            }
        });
        writer.close();
    }
}


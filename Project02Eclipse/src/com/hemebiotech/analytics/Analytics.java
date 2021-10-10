package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

public class Analytics {

	/**
	 *  The main function, entry point of this app
	 */

	public static void main(String[] args) throws Exception {

		AnalyticsCounter analytics = new AnalyticsCounter();
		String input ="Project02Eclipse/symptoms.txt";

		// Call the method to get symptoms
		List<String> symptoms = analytics.getSymptoms(input);

		// Call the method to count symptoms
		analytics.countSymptoms(symptoms);

		// Call the method to sort symptoms
		analytics.sortSymptoms();

		String output = "result.out";
		// Call the method to get result
		analytics.writeResult(output);

	}
}

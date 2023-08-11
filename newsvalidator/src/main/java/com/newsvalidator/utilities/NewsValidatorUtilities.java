package com.newsvalidator.utilities;

import org.apache.commons.text.similarity.JaccardSimilarity;

public class NewsValidatorUtilities {

	
	public static double calculateSemanticSimilarity(String text1, String text2) {
	    JaccardSimilarity jaccard = new JaccardSimilarity();

	    CharSequence charSequence1 = new StringBuilder(text1.toLowerCase().replace(" ", ""));
	    CharSequence charSequence2 = new StringBuilder(text2.toLowerCase().replace(" ", ""));

	    return jaccard.apply(charSequence1, charSequence2);
	}
}

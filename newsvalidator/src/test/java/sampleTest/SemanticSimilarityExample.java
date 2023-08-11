package sampleTest;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SemanticSimilarityExample {

    public static void main(String[] args) {
        String sentence1 = "Comedian Hardeep Singh Kohli charged with non-recent sexual offences";
        String sentence2 = "Comedian Hardeep Singh Kohli charged with sex offences";

        double similarity = calculateSemanticSimilarity(sentence1, sentence2);

        System.out.println("Semantic Similarity: " + similarity);
    }

    public static double calculateSemanticSimilarity(String text1, String text2) {
        Set<String> words1 = tokenizeAndNormalize(text1);
        Set<String> words2 = tokenizeAndNormalize(text2);

        Set<String> union = new HashSet<>(words1);
        union.addAll(words2);

        Set<String> intersection = new HashSet<>(words1);
        intersection.retainAll(words2);

        double jaccardSimilarity = (double) intersection.size() / union.size();

        return jaccardSimilarity;
    }

    public static Set<String> tokenizeAndNormalize(String text) {
        String[] tokens = text.toLowerCase().split("\\s+");
        return new HashSet<>(Arrays.asList(tokens));
    }
}

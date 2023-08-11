package sampleTest;


import org.apache.commons.text.similarity.JaccardSimilarity;

public class SemanticTest {

    public static void main(String[] args) {
        String text1 = "Cardiff crash victims ‘had been drinking and inhaling nitrous oxide’, court papers show";
        String text2 = "Trump investigation: special counsel Jack Smith obtained search warrant for Twitter account – live";

        double similarity = calculateSemanticSimilarity(text1, text2);

        System.out.println("Semantic Similarity: " + similarity);
    }

    
    public static double calculateSemanticSimilarity(String text1, String text2) {
        JaccardSimilarity jaccard = new JaccardSimilarity();

        CharSequence charSequence1 = new StringBuilder(text1.toLowerCase().replace(" ", ""));
        CharSequence charSequence2 = new StringBuilder(text2.toLowerCase().replace(" ", ""));

        return jaccard.apply(charSequence1, charSequence2);
    }
}

    
    



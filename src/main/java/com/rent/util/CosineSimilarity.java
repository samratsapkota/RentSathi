package com.rent.util;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rent.sprite.DescriptionResult;

public class CosineSimilarity {

    public static List<DescriptionResult> calculateCosineSimilarity(String userPreference, List<String> descriptions) {
        List<DescriptionResult> results = new ArrayList<>();
        Map<String, Map<String, Double>> vectors = new HashMap<>();
        Map<String, Double> userVector = vectorize(userPreference, descriptions);

        // Calculate vectors for each description
        for (String description : descriptions) {
            Map<String, Double> vector = vectorize(description, descriptions);
            vectors.put(description, vector);
        }

        // Calculate cosine similarity with user vector
        for (Map.Entry<String, Map<String, Double>> entry : vectors.entrySet()) {
            String description = entry.getKey();
            Map<String, Double> descriptionVector = entry.getValue();
            double similarity = cosineSimilarity(userVector, descriptionVector);
            results.add(new DescriptionResult(description, similarity));
        }

        return results;
    }

    private static Map<String, Double> vectorize(String text, List<String> allDescriptions) {
        Map<String, Double> vector = new HashMap<>();
        String[] words = text.toLowerCase().split("\\s+");
        double maxFreq = 0;
        
        // Calculate term frequency (TF)
        for (String word : words) {
            double freq = getTermFrequency(word, words);
            if (freq > maxFreq) {
                maxFreq = freq; // Find the maximum frequency for normalization
            }
            vector.put(word, freq);
        }
        
        // Normalize term frequency (TF)
        for (Map.Entry<String, Double> entry : vector.entrySet()) {
            String word = entry.getKey();
            double freq = entry.getValue();
            double normalizedFreq = freq / maxFreq; // Normalize term frequency
            vector.put(word, normalizedFreq);
        }
        
        // Calculate inverse document frequency (IDF)
        Map<String, Double> idfValues = new HashMap<>();
        for (String word : words) {
            double idf = getInverseDocumentFrequency(word, allDescriptions);
            idfValues.put(word, idf);
        }
        
        // Calculate TF-IDF
        for (Map.Entry<String, Double> entry : vector.entrySet()) {
            String word = entry.getKey();
            double tfidf = entry.getValue() * idfValues.get(word);
            vector.put(word, tfidf);
        }

        return vector;
    }

    private static double cosineSimilarity(Map<String, Double> vector1, Map<String, Double> vector2) {
        // Calculate cosine similarity between two vectors
        double dotProduct = 0.0;
        double norm1 = 0.0;
        double norm2 = 0.0;

        for (Map.Entry<String, Double> entry : vector1.entrySet()) {
            String key = entry.getKey();
            double value = entry.getValue();
            dotProduct += value * vector2.getOrDefault(key, 0.0);
            norm1 += value * value;
        }

        for (Map.Entry<String, Double> entry : vector2.entrySet()) {
            double value = entry.getValue();
            norm2 += value * value;
        }

        if (norm1 == 0 || norm2 == 0) {
            return 0.0; // Handle division by zero
        }

        return dotProduct / (Math.sqrt(norm1) * Math.sqrt(norm2));
    }
    
    private static double getTermFrequency(String term, String[] words) {
        double frequency = 0;
        for (String word : words) {
            if (term.equals(word)) {
                frequency++;
            }
        }
        return frequency / words.length; // Normalize by document length
    }
    
    private static double getInverseDocumentFrequency(String term, List<String> allDescriptions) {
        double count = 0;
        for (String description : allDescriptions) {
            if (description.toLowerCase().contains(term)) {
                count++;
            }
        }
        return Math.log(allDescriptions.size() / (count + 1)); // Add 1 to prevent division by zero
    }
}

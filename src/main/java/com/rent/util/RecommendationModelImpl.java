package com.rent.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rent.dao.RentDao;
import com.rent.sprite.DescriptionResult;
import com.rent.sprite.RentList;

@Service
public class RecommendationModelImpl implements RecommendationModel {

	@Autowired
	RentDao rentDao;
	
    @Override
    public List<DescriptionResult> getTop5SimilarDescriptions(String userDescription) {
        List<String> descriptionsFromDB = rentDao.getDescription();
        
        // Calculate cosine similarity and store in DescriptionResult objects
        List<DescriptionResult> descriptionResults = CosineSimilarity.calculateCosineSimilarity(userDescription, descriptionsFromDB);
        
        // Sort the results by similarity score
        descriptionResults.sort((a, b) -> Double.compare(b.getSimilarityScore(), a.getSimilarityScore()));
        
        // Return top 5 results
        return descriptionResults.subList(0, Math.min(5, descriptionResults.size()));
    }
}

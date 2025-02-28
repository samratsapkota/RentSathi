package com.rent.util;

import java.util.List;

import com.rent.sprite.DescriptionResult;

public interface RecommendationModel {

	public List<DescriptionResult> getTop5SimilarDescriptions(String userDescription);
}



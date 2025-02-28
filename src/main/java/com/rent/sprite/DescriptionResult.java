package com.rent.sprite;

public class DescriptionResult {
    private String description;
    private double similarityScore;

    public DescriptionResult(String description, double similarityScore) {
        this.description = description;
        this.similarityScore = similarityScore;
    }

    public String getDescription() {
        return description;
    }

    public double getSimilarityScore() {
        return similarityScore;
    }
    

	public void setDescription(String description) {
		this.description = description;
	}

	public void setSimilarityScore(double similarityScore) {
		this.similarityScore = similarityScore;
	}

	@Override
	public String toString() {
		return "DescriptionResult [description=" + description + ", similarityScore=" + similarityScore + "]";
	}

	public DescriptionResult() {
		super();
		// TODO Auto-generated constructor stub
	}
    
}

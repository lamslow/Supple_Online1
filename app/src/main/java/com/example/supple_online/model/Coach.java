package com.example.supple_online.model;

public class Coach {
    String name, description, ratePoint, relevanceRate;
    int image;

    public Coach(String name, int image, String description, String ratePoint, String relevanceRate) {
        this.name = name;
        this.image = image;
        this.description = description;
        this.ratePoint = ratePoint;
        this.relevanceRate = relevanceRate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRatePoint() {
        return ratePoint;
    }

    public void setRatePoint(String ratePoint) {
        this.ratePoint = ratePoint;
    }

    public String getRelevanceRate() {
        return relevanceRate;
    }

    public void setRelevanceRate(String relevanceRate) {
        this.relevanceRate = relevanceRate;
    }
}

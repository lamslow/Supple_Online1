package com.example.supple_online.model;

public class Product {
    String name, price, vote;
    int image;

    public Product(String name, String price, int image, String vote) {
        this.name = name;
        this.price = price;
        this.image = image;
        this.vote = vote;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getVote() {
        return vote;
    }

    public void setVote(String vote) {
        this.vote = vote;
    }
}

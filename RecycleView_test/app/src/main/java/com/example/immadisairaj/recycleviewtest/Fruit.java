package com.example.immadisairaj.recycleviewtest;

public class Fruit {
    private String fruitName;
    private int fruitImages;

    Fruit(String fruitName, int fruitImages) {
        this.fruitName = fruitName;
        this.fruitImages = fruitImages;
    }

    public String getFruitName() {
        return fruitName;
    }

    public int getImageId() {
        return fruitImages;
    }
}

package com.example.duan1.UserActivity;

import java.io.Serializable;

public class Menu implements Serializable {
    private int imageResourceId;
    private String foodName;
    private String price;

    public Menu() {
        // Required empty constructor for Firebase
    }

    public Menu(int imageResourceId, String foodName, String price) {
        this.imageResourceId = imageResourceId;
        this.foodName = foodName;
        this.price = price;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public void setImageResourceId(int imageResourceId) {
        this.imageResourceId = imageResourceId;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}


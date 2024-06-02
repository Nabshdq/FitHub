package com.example.fithub.model;

public class Exercise {
    private String name;
    private String type;
    private int imageResId;  // new field

    public Exercise(String name, String type, int imageResId) {
        this.name = name;
        this.type = type;
        this.imageResId = imageResId;  // assign new field
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getImageResId() {
        return imageResId;
    }

    public void setImageResId(int imageResId) {
        this.imageResId = imageResId;
    }
}
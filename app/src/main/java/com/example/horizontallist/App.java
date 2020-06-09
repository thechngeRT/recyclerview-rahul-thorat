package com.example.horizontallist;

public class App {
    private String mImageUrl;
    private String mCreator;


    public App(String image, String name) {
        this.mImageUrl = image;
        this.mCreator = name;
    }

    public String getImageUrl() {
        return mImageUrl;
    }

    public String getCreator() {
        return mCreator;
    }
    }


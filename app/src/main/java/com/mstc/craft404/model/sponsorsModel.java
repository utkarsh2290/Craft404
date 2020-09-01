package com.mstc.craft404.model;

public class sponsorsModel {
    private int sponsorsImage;
    private String sponsorsName;

    public sponsorsModel(int sponsorsImage, String sponsorsName) {
        this.sponsorsImage = sponsorsImage;
        this.sponsorsName = sponsorsName;
    }

    public int getSponsorsImage() {
        return sponsorsImage;
    }

    public String getSponsorsName() {
        return sponsorsName;
    }

    public void setSponsorsImage(int sponsorsImage) {
        this.sponsorsImage = sponsorsImage;
    }

    public void setSponsorsName(String sponsorsName) {
        this.sponsorsName = sponsorsName;
    }
}

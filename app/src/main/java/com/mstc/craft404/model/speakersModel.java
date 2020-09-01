package com.mstc.craft404.model;

import android.widget.ImageView;
import android.widget.TextView;

public class speakersModel {
    private int speakerImage;
    private String speakerName,speakerDescription,speakerLink;

    public speakersModel(int speakerImage, String speakerName, String speakerDescription, String speakerLink) {
        this.speakerImage = speakerImage;
        this.speakerName = speakerName;
        this.speakerDescription = speakerDescription;
        this.speakerLink = speakerLink;
    }

    public int getSpeakerImage() {
        return speakerImage;
    }

    public String getSpeakerName() {
        return speakerName;
    }

    public String getSpeakerDescription() {
        return speakerDescription;
    }

    public String getSpeakerLink() {
        return speakerLink;
    }

    public void setSpeakerImage(int speakerImage) {
        this.speakerImage = speakerImage;
    }

    public void setSpeakerName(String speakerName) {
        this.speakerName = speakerName;
    }

    public void setSpeakerDescription(String speakerDescription) {
        this.speakerDescription = speakerDescription;
    }

    public void setSpeakerLink(String speakerLink) {
        this.speakerLink = speakerLink;
    }
}

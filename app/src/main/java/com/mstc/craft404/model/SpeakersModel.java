package com.mstc.craft404.model;

import android.widget.ImageView;
import android.widget.TextView;

public class SpeakersModel {
    private String speakerName,speakerPicLink,speakerContent,speakerDesignation;

    public SpeakersModel(String speakerName, String speakerPicLink, String speakerContent, String speakerDesignation) {

        this.speakerName = speakerName;
        this.speakerPicLink=speakerPicLink;
        this.speakerContent=speakerContent;
        this.speakerDesignation=speakerDesignation;
    }

    public String getSpeakerContent() {
        return speakerContent;
    }

    public String getSpeakerName() {
        return speakerName;
    }

    public String getSpeakerPicLink() {
        return speakerPicLink;
    }

    public void setSpeakerPicLink(String speakerPicLink) {
        this.speakerPicLink = speakerPicLink;
    }

    public void setSpeakerName(String speakerName) {
        this.speakerName = speakerName;
    }

    public void setSpeakerContent(String speakerContent) {
        this.speakerContent = speakerContent;
    }

    public String getSpeakerDesignation() {
        return speakerDesignation;
    }

    public void setSpeakerDesignation(String speakerDesignation) {
        this.speakerDesignation = speakerDesignation;
    }
}

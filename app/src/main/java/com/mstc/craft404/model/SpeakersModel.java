package com.mstc.craft404.model;

import android.widget.ImageView;
import android.widget.TextView;

public class SpeakersModel {
    private String speakerName,speakerDescription,speakerLink,speakerPicLink;

    public SpeakersModel(String speakerName, String speakerDescription, String speakerLink, String speakerPicLink) {

        this.speakerName = speakerName;
        this.speakerDescription = speakerDescription;
        this.speakerLink = speakerLink;
        this.speakerPicLink=speakerPicLink;
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

    public String getSpeakerPicLink() {
        return speakerPicLink;
    }

    public void setSpeakerPicLink(String speakerPicLink) {
        this.speakerPicLink = speakerPicLink;
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

package com.mstc.craft404.model;

import android.widget.ImageView;
import android.widget.TextView;

public class SpeakersModel {
    private String speakerName,speakerPicLink,speakerContent;

    public SpeakersModel(String speakerName, String speakerPicLink, String speakerContent) {

        this.speakerName = speakerName;
        this.speakerPicLink=speakerPicLink;
        this.speakerContent=speakerContent;
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
}

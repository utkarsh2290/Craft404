package com.mstc.craft404.model;

import android.widget.ImageView;
import android.widget.TextView;

public class SpeakersModel {
    private String speakerName,speakerPicLink;

    public SpeakersModel(String speakerName, String speakerPicLink) {

        this.speakerName = speakerName;
        this.speakerPicLink=speakerPicLink;
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

}

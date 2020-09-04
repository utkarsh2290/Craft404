package com.mstc.craft404.model;

public class frontendModel {
    private String resFrontEndTitle;
    private String resFrontEndLink;

    public frontendModel(String resFrontEndTitle, String resFrontEndLink) {
        this.resFrontEndTitle = resFrontEndTitle;
        this.resFrontEndLink = resFrontEndLink;

    }

    public String getResFrontEndTitle() {
        return resFrontEndTitle;
    }

    public void setResFrontEndTitle(String resFrontEndTitle) {
        this.resFrontEndTitle = resFrontEndTitle;
    }

    public String getResFrontEndLink() {
        return resFrontEndLink;
    }

    public void setResFrontEndLink(String resFrontEndLink) {
        this.resFrontEndLink = resFrontEndLink;
    }


}

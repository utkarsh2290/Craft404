package com.mstc.craft404.model;

public class frontendModel {
    private String resFrontEndTitle;
    private String resFrontEndLink;
    private String resFrontEndDesc;

    public frontendModel(String resFrontEndTitle,String resFrontEndDesc, String resFrontEndLink) {
        this.resFrontEndTitle = resFrontEndTitle;
        this.resFrontEndDesc = resFrontEndDesc;
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

    public String getResFrontEndDesc() {
        return resFrontEndDesc;
    }

    public void setResFrontEndDesc(String resFrontEndDesc) {
        this.resFrontEndDesc = resFrontEndDesc;
    }
}

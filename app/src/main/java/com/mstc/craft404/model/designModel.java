package com.mstc.craft404.model;

public class designModel {
    private String resDesignTitle;
    private String resDesignLink;
    private String resDesignDesc;

    public designModel(String resDesignTitle, String resDesignLink, String resDesignDesc) {
        this.resDesignTitle = resDesignTitle;
        this.resDesignLink = resDesignLink;
        this.resDesignDesc = resDesignDesc;
    }

    public String getResDesignTitle() {
        return resDesignTitle;
    }

    public void setResDesignTitle(String resDesignTitle) {
        this.resDesignTitle = resDesignTitle;
    }

    public String getResDesignLink() {
        return resDesignLink;
    }

    public void setResDesignLink(String resDesignLink) {
        this.resDesignLink = resDesignLink;
    }

    public String getResDesignDesc() {
        return resDesignDesc;
    }

    public void setResDesignDesc(String resDesignDesc) {
        this.resDesignDesc = resDesignDesc;
    }
}

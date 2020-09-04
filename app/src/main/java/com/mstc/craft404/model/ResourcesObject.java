package com.mstc.craft404.model;

public class ResourcesObject {
    String restitle;
    String resdesc;
    String resdate;
    String resimglink;
    String reslink;

    public String getRestitle() {
        return restitle;
    }

    public void setRestitle(String restitle) {
        this.restitle = restitle;
    }

    public String getResdesc() {
        return resdesc;
    }

    public void setResdesc(String resdesc) {
        this.resdesc = resdesc;
    }

    public String getResdate() {
        return resdate;
    }

    public void setResdate(String resdate) {
        this.resdate = resdate;
    }

    public String getResimglink() {
        return resimglink;
    }

    public void setResimglink(String resimglink) {
        this.resimglink = resimglink;
    }

    public String getReslink() {
        return reslink;
    }

    public void setReslink(String reslink) {
        this.reslink = reslink;
    }

    public ResourcesObject(String restitle, String resdesc, String resdate, String resimglink, String reslink) {
        this.restitle = restitle;
        this.resdesc = resdesc;
        this.resdate = resdate;
        this.resimglink = resimglink;
        this.reslink = reslink;
    }
}

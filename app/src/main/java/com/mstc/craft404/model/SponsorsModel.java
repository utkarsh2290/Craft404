package com.mstc.craft404.model;

public class SponsorsModel  {
    private String sponsorPicLink,sponsorSiteLink;


    public SponsorsModel(String sponsorPicLink, String sponsorSiteLink) {
        this.sponsorPicLink = sponsorPicLink;
        this.sponsorSiteLink=sponsorSiteLink;
    }

    public String getSponsorSiteLink() {
        return sponsorSiteLink;
    }

    public String getSponsorPicLink() {
        return sponsorPicLink;
    }

    public void setSponsorPicLink(String sponsorPicLink) {
        this.sponsorPicLink = sponsorPicLink;
    }

    public void setSponsorSiteLink(String sponsorSiteLink) {
        this.sponsorSiteLink = sponsorSiteLink;
    }
}

package com.mstc.craft404.model;

public class LeaderboardModel {
    String leaderTitle;
    String leaderName;
    String leaderImage;

    public LeaderboardModel(String leaderTitle, String leaderName, String leaderImage) {
        this.leaderTitle = leaderTitle;
        this.leaderName = leaderName;
        this.leaderImage = leaderImage;
    }

    public String getLeaderTitle() {
        return leaderTitle;
    }

    public void setLeaderTitle(String leaderTitle) {
        this.leaderTitle = leaderTitle;
    }

    public String getLeaderName() {
        return leaderName;
    }

    public void setLeaderName(String leaderName) {
        this.leaderName = leaderName;
    }

    public String getLeaderImage() {
        return leaderImage;
    }

    public void setLeaderImage(String leaderImage) {
        this.leaderImage = leaderImage;
    }
}

package com.zubale.quest;

public class Quest {
    private float distance;
    private int lines;
    private String platform;
    private float rewardAmount;

    public Quest() {

    }

    public Quest(float distance, int lines, String platform) {
        this.distance = distance;
        this.lines = lines;
        this.platform = platform;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public int getLines() {
        return lines;
    }

    public void setLines(int lines) {
        this.lines = lines;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public float getRewardAmount() {
        return rewardAmount;
    }

    public void setRewardAmount(float rewardAmount) {
        this.rewardAmount = rewardAmount;
    }
}

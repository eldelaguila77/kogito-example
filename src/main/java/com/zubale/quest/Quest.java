/*
 * Copyright 2021 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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

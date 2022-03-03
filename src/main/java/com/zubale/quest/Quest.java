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

import javax.script.Bindings;
import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Quest {
    private float distance;
    private int lines;
    private String platform;
    private String storeId;
    private float rewardAmount;
    private String formula;
    private float calculate;

    public Quest() {

    }

    public Quest(float distance, int lines, String platform, String storeId) {
        this.distance = distance;
        this.lines = lines;
        this.platform = platform;
        this.storeId = storeId;
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

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public float getRewardAmount() {
        return rewardAmount;
    }

    public void setRewardAmount(float rewardAmount) throws ScriptException {
        Float prueba = this.distance + this.lines;
        System.out.println("Adult prueba!" + prueba);
        this.setCalculate("");
        this.rewardAmount = rewardAmount;
    }

    public String getFormula() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }

    public float getCalculate() {
        return calculate;
    }

    public void setCalculate(String calculate) throws ScriptException {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("js");
        //Object result = engine.eval(this.distance + "*5 + " + this.lines);
        engine.put("dist", this.distance);
        engine.put("lin", this.lines);
        Bindings bindings = engine.getBindings(ScriptContext.ENGINE_SCOPE);
        Object dist = bindings.get("dist");
        Object lin = bindings.get("lin");
        System.out.println("dist = " + dist);
        System.out.println("lin = " + lin);
        Object result = engine.eval("dist + 5 * lin");
        System.out.println("prueba formula" + result);
        this.calculate = 2;
    }
}

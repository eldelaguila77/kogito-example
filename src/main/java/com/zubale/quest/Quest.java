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
    private float reward;

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
        this.setCalculate("0");
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
        System.out.println("esto trae la formula" + calculate);
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("js");
        //Object result = engine.eval(this.distance + "*5 + " + this.lines);
        engine.put("dist", this.distance);
        engine.put("lin", this.lines);
        engine.put("wildcard", 0);
        Bindings bindings = engine.getBindings(ScriptContext.ENGINE_SCOPE);
        Object wildcard = bindings.get("wildcard");
        Object dist = bindings.get("dist");
        Object lin = bindings.get("lin");
        System.out.println("dist = " + dist);
        System.out.println("lin = " + lin);
        System.out.println("wildcard = " + wildcard);
        //Object result = engine.eval("(5 ) + wildcard");
        Object result = engine.eval("(" + calculate + ") + wildcard");
        System.out.println("prueba formula" + result);
        System.out.println("prueba formula converted" + ((Double) result).floatValue());
        //this.calculate = ((Double) result).floatValue();
        this.calculate = 78;
        this.reward = 78.0f;
        System.out.println("prueba formula reward" + result);
    }
}

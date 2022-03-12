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

import java.util.List;

import org.junit.jupiter.api.Test;

import com.opencsv.exceptions.CsvValidationException;
import com.sap.csv2json.ConvertCSVtoJson;
import com.sap.csv2json.Payload;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

@QuarkusTest
public class RewardTest {

    @Test
    public void test() throws CsvValidationException {
        System.out.println("prueba csv");
        List<Payload> payload = ConvertCSVtoJson.readCsvUsingOpenCsv("/home/eldelaguila77/Documentos/zubale/csvprueba.csv");
  
        System.out.println("prueba json on test: " + payload.get(0).distance);
        for (int i = 0; i < payload.size(); i++) {
            String quest = "{\n" +
                    " \"quest\": {\n" +
                    " \"distance\": " + payload.get(i).distance + ",\n" +
                    " \"lines\": " + payload.get(i).lines + ",\n" +
                    " \"platform\": \"" + payload.get(i).platform + "\",\n" +
                    " \"storeId\": \"" + payload.get(i).storedId + "\"\n" +
                    "} \n" +
                    "}";
            Float expectedReward = payload.get(i).reward;

            System.out.println("quest " + i + " : " + quest);
            System.out.println("expectedReward:  " + i + " : " + expectedReward);

            given()
                .body(quest)
                .contentType(ContentType.JSON)
                .when()
                .post("RewardAmount")
                .then()
                .statusCode(201)
                .body("reward", is(expectedReward));
        }

    }
}

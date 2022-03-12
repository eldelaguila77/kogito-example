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
package com.sap.csv2json;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class ConvertCSVtoJson {
    public static void main(String[] args) throws CsvValidationException {
        readCsvUsingOpenCsv("convertcsv.csv");
    }

    public static List readCsvUsingOpenCsv(String filePath) throws CsvValidationException {
        List<Payload> list = new ArrayList<Payload>();
        try {
            CSVReader reader = new CSVReader(new FileReader(filePath));
            String[] nextLine;
            int countRow = reader.readNext().length;
            System.out.println("countrow: " + countRow);
            while ((nextLine = reader.readNext()) != null) {
                /*
                 * for (String value : nextLine) {
                 * System.out.print(value + "\t");
                 * }
                 */
                list.add(new Payload(Float.valueOf(nextLine[0]), Integer.valueOf(nextLine[1]), nextLine[2], nextLine[3], Float.valueOf(nextLine[4])));
                //System.out.println(new Gson().toJson(payload));
            }
            /*
             * unitTestingRows = new Gson().toJson(payload);
             */

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;

    }

}

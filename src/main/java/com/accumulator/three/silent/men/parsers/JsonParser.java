package com.accumulator.three.silent.men.parsers;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonParser {
    public static List<Map<String, Object>> readAll(String filename) {
        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();
        List<Map<String, Object>> gasStations = new ArrayList<>();

        try (FileReader reader = new FileReader(filename)) {
            //Read JSON file

            JSONArray list = (JSONArray) jsonParser.parse(reader);
            for (int i = 0; i < list.size(); i++){
                JSONObject jsonObject = (JSONObject) list.get(i);
                Map<String, Object> map = new HashMap<>();
                for(Object key : jsonObject.keySet()) {
                    String stringKey = (String) key;
                    map.put(stringKey, jsonObject.get(key).toString());
                }
                gasStations.add(map);
            }
        } catch (IOException|ParseException e) {
            e.printStackTrace();
        }
        
        return gasStations;
    }
}
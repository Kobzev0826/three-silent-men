package com.accumulator.three.silent.men.fileread;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonParser {

	public static List<Map<String, Object>> readlAll() {
		//JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();
        List<Map<String, Object>> gasStations = new ArrayList<>();

        try (FileReader reader = new FileReader("src/main/resources/azs.json")) {
            //Read JSON file
            Object obj = jsonParser.parse(reader);

            JSONArray list = (JSONArray) obj;
            for ( int i=0; i<list.size(); i++){
                JSONObject jsonObject = (JSONObject) list.get(i);
                Map<String, Object> map = new HashMap<>();
                for(Object key : jsonObject.keySet()) {
                    String stringKey = (String) key;
                    map.put(stringKey, jsonObject.get(key));
                }
                gasStations.add(map);
            }



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        return gasStations;
	}
}

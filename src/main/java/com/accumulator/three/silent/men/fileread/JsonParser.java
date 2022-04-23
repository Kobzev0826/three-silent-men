package com.accumulator.three.silent.men.fileread;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class JsonParser {
    /*
        public static void main(String[] args) throws Exception {
            JSONObject jsonObject = (JSONObject) readJsonSimpleDemo("src/main/resources/azs.json");
            System.out.println(jsonObject);

        }

        public static Object readJsonSimpleDemo(String filename) throws Exception {
            // create object mapper instance
            ObjectMapper mapper = new ObjectMapper();

            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader(filename));
            // convert JSON file to map
            //List<> employeeList = Arrays.asList(mapper.readValue(json, Employee[].class));
            return jsonObject;
        }
    */
    public static void main(String[] args) {
        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader("src/main/resources/azs.json")) {
            //Read JSON file
            Object obj = jsonParser.parse(reader);

            JSONObject Data = new JSONObject();
            JSONArray list = (JSONArray) obj;
            for ( int i=0; i<list.size(); i++){

                Data = (JSONObject) list.get(i);
                throw
                Map<String,Object> =  Data.keySet()
            }


            //Map<String,Object> map = list.stream().collect(Collectors.toMap());



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}

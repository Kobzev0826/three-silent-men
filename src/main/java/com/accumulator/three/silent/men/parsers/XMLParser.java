//package com.accumulator.three.silent.men.parsers;
//
//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;
//import org.json.simple.parser.ParseException;
//import org.w3c.dom.Document;
//import org.xml.sax.SAXException;
//
//import javax.xml.parsers.DocumentBuilderFactory;
//import javax.xml.parsers.ParserConfigurationException;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class XMLParser {
//
//    public static List<Map<String, Object>> readAll(String filename) {
//        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
//        List<Map<String, Object>> gasStations = new ArrayList<>();
//
//        try (FileReader reader = new FileReader(filename)) {
//            Document document = documentBuilderFactory.newDocumentBuilder().parse(filename);
//
//            JSONArray list = (JSONArray) jsonParser.parse(reader);
//            for (int i = 0; i < list.size(); i++){
//                JSONObject jsonObject = (JSONObject) list.get(i);
//                Map<String, Object> map = new HashMap<>();
//                for(Object key : jsonObject.keySet()) {
//                    String stringKey = (String) key;
//                    map.put(stringKey, jsonObject.get(key));
//                }
//                gasStations.add(map);
//            }
//        } catch (ParserConfigurationException e) {
//            throw new RuntimeException(e);
//        } catch (SAXException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//
//        return gasStations;
//    }
//
//}

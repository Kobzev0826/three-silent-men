package com.accumulator.three.silent.men.config;

import com.accumulator.three.silent.men.db.DatabaseConnection;
import com.accumulator.three.silent.men.parsers.CSVParser;
import com.accumulator.three.silent.men.parsers.DatabaseParser;
import com.accumulator.three.silent.men.parsers.JsonParser;

import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class YMLManager {

    public static void manage(String configFilePath) throws IOException, SQLException {

        DatabaseConnection databaseConnection = new DatabaseConnection("localhost", 27017);
        //System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!" + validAttributes);

        Map<String, Object> data  = YMLParser.parseYML(configFilePath);
        List<String> validAttributes = (List<String>) data.get("validAttributes");

        //DatabaseConnection databaseConnection = new DatabaseConnection("localhost", 27017);

        //цикл по указанным источникам
        for (int i=1; i<data.size();i++){
            String name = "source" + i;
            Map<String, Object> source = (Map<String, Object>) data.get(name);
            List<Map<String, Object>> ParseData = parseSource(source);
            ParseData = ParseData.stream().map(x -> MapFilter.filterMap(x, validAttributes)).collect(Collectors.toList());
            //ParseData = (List<Map<String, Object>>) MapFilter.filterMap((Map<String, Object>) ParseData,validAttributes);
            System.out.println("test before connect database");
            DatabaseConnection.writeToDatabaseMany(ParseData);

        }
    }

    public static List<Map<String, Object>> parseSource(Map<String, Object> source)
            throws IOException, SQLException {
        List<Map<String, Object>> parsedData = null;
        String type = (String) source.get("type");
        switch (type) {

            case "CSV":
                //String addr = (String) source.get("addr");
                parsedData = CSVParser.readAll((String) source.get("addr"),
                        (char) source.get("separator"));
                break;

            case"json":
                parsedData = JsonParser.readAll((String) source.get("addr"));
                //System.out.println(ParseData);
                break;

            case "DB":
                parsedData = DatabaseParser.readAll(
                        (String) source.get("addr"),
                        (String) source.get("login"),
                        (String) source.get("password"),
                        (String) source.get("table")
                );
                break;
        }
        return parsedData;
    }
}

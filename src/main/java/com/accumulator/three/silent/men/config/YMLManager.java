package com.accumulator.three.silent.men.config;

import com.accumulator.three.silent.men.db.DatabaseConnection;
import com.accumulator.three.silent.men.parsers.CSVParser;
import com.accumulator.three.silent.men.parsers.DatabaseParser;
import com.accumulator.three.silent.men.parsers.JsonParser;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class YMLManager {

    public static void manage(String configFilePath) throws IOException, SQLException {

        DatabaseConnection databaseConnection = new DatabaseConnection("localhost", 27017);

        Map<String, Object> data  = YMLParser.parseYML(configFilePath);
        List<String> validAttributes = (List<String>) data.get("validAttributes");
        String UniqueValue = (String) data.get("UniqueValue");

        //цикл по указанным источникам
        for (int i=1; i<data.size()-1;i++){
            String name = "source" + i;
            Map<String, Object> source = (Map<String, Object>) data.get(name);
            List<Map<String, Object>> ParseData = parseSource(source);
            ParseData = ParseData.stream().map(x -> MapFilter.filterMap(x, validAttributes)).collect(Collectors.toList());
            databaseConnection.writeToDatabaseMany(ParseData,UniqueValue);

        }
    }

    public static List<Map<String, Object>> parseSource(Map<String, Object> source)
            throws IOException, SQLException {
        List<Map<String, Object>> parsedData = null;
        String type = (String) source.get("type");
        switch (type) {

            case "CSV":
                char separator = source.get("separator").toString().charAt(0);
                parsedData = CSVParser.readAll((String) source.get("addr"),
                        separator);
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

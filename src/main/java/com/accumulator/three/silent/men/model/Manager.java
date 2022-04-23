package com.accumulator.three.silent.men.model;

import com.accumulator.three.silent.men.DatabaseConnection;
import com.accumulator.three.silent.men.DatabaseParser;
import com.accumulator.three.silent.men.MapFilter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.accumulator.three.silent.men.fileread.CnfigYml.Yml_parse;

public class Manager {

    public static void start(String ConfigDataPath) throws IOException, URISyntaxException {

        Map<String, Object> data  = Yml_parse(ConfigDataPath);
        List<String> validAttributes = (List<String>) data.get("validAttributes");



        //цикл по указанным источникам
        for (int i=1; i<data.size();i++){
            String name = "source" + i;
            Map<String, Object> source = (Map<String, Object>) data.get(name);
            List<Map<String, Object>> ParseData = SwichParser.Swich(source);
            ParseData = ParseData.stream().map(x -> MapFilter.filterMap(x, validAttributes)).collect(Collectors.toList());
            //ParseData = (List<Map<String, Object>>) MapFilter.filterMap((Map<String, Object>) ParseData,validAttributes);
            DatabaseConnection.writeToDatabaseMany(ParseData);

        }
    }


}

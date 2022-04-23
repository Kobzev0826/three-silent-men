package com.accumulator.three.silent.men.model;

import com.accumulator.three.silent.men.DatabaseParser;
import com.accumulator.three.silent.men.fileread.CSVParser;
import com.accumulator.three.silent.men.fileread.JsonParser;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class SwichParser {

    public static List<Map<String, Object>> Swich(Map<String, Object> SourcePar) throws IOException, URISyntaxException, SQLException {
        List<Map<String, Object>> ParseData = null;
        String type = (String) SourcePar.get("type");
        switch (type) {

            case "CSV":
                String addr = (String) SourcePar.get("addr");
                ParseData = CSVParser.readAll(addr);
                break;

            case"json":
                ParseData = JsonParser.readAll((String) SourcePar.get("addr"));
                //System.out.println(ParseData);
                break;

            case "DB":
                ParseData = DatabaseParser.readAll(
                        (String) SourcePar.get("addr"),
                        (String) SourcePar.get("login"),
                        (String) SourcePar.get("password"),
                        (String) SourcePar.get("table")
                );
                break;
        }
        return ParseData;
    }

}

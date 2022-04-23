package com.accumulator.three.silent.men.model;

import com.accumulator.three.silent.men.fileread.CSVParser;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

public class SwichParser {

    public static List<Map<String, Object>> Swich(Map<String, Object> SourcePar) throws IOException, URISyntaxException {
        List<Map<String, Object>> ParseData;
        switch (SourcePar.get("type")) {

            case ("CSV"):
                ParseData = CSVParser.readAllExample((String) SourcePar.get("addr"));

            case("json"):
                ParseData =
        }

    }

}

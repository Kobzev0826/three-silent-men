package com.accumulator.three.silent.men.parsers;

import com.opencsv.CSVReader;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CSVParser {

    public static @NotNull List<Map<String, Object>> readAll(String filename,char separator) throws IOException {
        List<Map<String, Object>> gasStations = new ArrayList<>();
        CSVReader csvReader = new CSVReader(new FileReader(filename), separator);
        String[] titles = csvReader.readNext();
        List<String[]> csvList = csvReader.readAll();
        
        for (int i = 1; i < csvList.size(); i++) {
            String values[] = csvList.get(i);
            Map<String, Object> map = new HashMap<>();
            for(int j = 0; j < titles.length; j++) {
                map.put(titles[j], values[j]);
            }
            gasStations.add(map);
        }
        //reader.close();
        csvReader.close();
        return gasStations;
    }
}

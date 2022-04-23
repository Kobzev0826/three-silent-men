package com.accumulator.three.silent.men.fileread;

import com.opencsv.CSVReader;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.Reader;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CSVParser {

    public static List<Map<String, Object>> readAll(Reader reader) throws IOException {
        List<Map<String, Object>> gasStations = new ArrayList<>();
        CSVReader csvReader = new CSVReader(reader, '|');
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
        reader.close();
        csvReader.close();
        return gasStations;
    }

    public static List<Map<String, Object>>  readAllExample(String filename) throws IOException, URISyntaxException {
        Reader reader = Files.newBufferedReader(Paths.get(
                ClassLoader.getSystemResource(filename).toURI()));
        return readAll(reader);
    }

    public static void printData (List<Map<String, Object>> data){
        for(Map<String, Object> gasStation : data){
            System.out.println(gasStation);
        }
    }

    public static void parser() throws IOException, URISyntaxException {

        List<Map<String, Object>> testData = readAllExample();
        printData(testData);
    }

}

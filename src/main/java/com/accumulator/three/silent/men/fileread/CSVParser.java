package com.accumulator.three.silent.men.fileread;

import com.accumulator.three.silent.men.GasStation;
import com.opencsv.CSVReader;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.Reader;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
public class CSVParser {

    public static List<GasStation> readAll(Reader reader) throws IOException {
        List<GasStation> gasStations = new ArrayList<>();
        CSVReader csvReader = new CSVReader(reader, '|');
        List<String[]> csvList = csvReader.readAll();
        for (String[] listElement : csvList) {

            GasStation gasStation = new GasStation();
            gasStation.setAddress(listElement[0]);
            gasStation.setLatitude(listElement[1]);
            gasStation.setLongtitude(listElement[2]);
            gasStation.setName(listElement[3]);
            gasStation.setCountry(listElement[4]);
            gasStation.setPhone(listElement[5]);
            gasStation.setRegion(listElement[6]);
            gasStations.add(gasStation);
        }
        reader.close();
        csvReader.close();
        return gasStations;
    }

    public static List<GasStation>  readAllExample() throws IOException, URISyntaxException {
        Reader reader = Files.newBufferedReader(Paths.get(
                ClassLoader.getSystemResource("azs.csv").toURI()));
        return readAll(reader);
    }

    public static void printData (List<GasStation> data){
        for(GasStation gasStation : data){
            System.out.println(gasStation);
        }
    }

    public static void parser() throws IOException, URISyntaxException {

        List<GasStation> testData = readAllExample();
        printData(testData);
    }

}

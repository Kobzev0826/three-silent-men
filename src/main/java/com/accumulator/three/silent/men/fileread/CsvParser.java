package com.accumulator.three.silent.men.fileread;

import com.opencsv.CSVReader;
import org.springframework.stereotype.Service;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CsvParser {

    public static List<String[]> readAll(Reader reader) throws Exception {
        CSVReader csvReader = new CSVReader(reader);
        List<String[]> list = new ArrayList<>();
        list = csvReader.readAll();
        reader.close();
        csvReader.close();
        return list;
    }

    public static List<String[]>  readAllExample() throws Exception {
        Reader reader = Files.newBufferedReader(Paths.get(
                ClassLoader.getSystemResource("azs.csv").toURI()));
        return readAll(reader);
    }

    public static void print_data (List<String[]> data){
        for(String[] row : data){
            System.out.println(Arrays.toString(row));
        }
    }

    public static void parser() throws Exception {

        List<String[]> test_data = readAllExample();
        print_data(test_data);
    }

}

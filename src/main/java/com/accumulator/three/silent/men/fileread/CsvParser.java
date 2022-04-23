package com.accumulator.three.silent.men.fileread;

import com.opencsv.CSVReader;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Setter
@Getter
@Service
public class CsvParser {

    private String name;

    public static List<String[]> readAll(Reader reader) throws Exception {
        CSVReader csvReader = new CSVReader(reader);
        List<String[]> list = new ArrayList<>();
        list = csvReader.readAll();
        reader.close();
        csvReader.close();
        return list;
    }

    public static List<String[]>  readAll(String name) throws Exception {
        Reader reader = Files.newBufferedReader(Paths.get(
                ClassLoader.getSystemResource(name).toURI()));

        return readAll(reader);
    }

    public static void print_data (List<String[]> data){
        for(String[] row : data){
            System.out.println(Arrays.toString(row));
        }
    }

    public static void parser() throws Exception {

        List<String[]> test_data = readAll("azs.csv");
        print_data(test_data);
    }

}

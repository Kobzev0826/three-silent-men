package com.accumulator.three.silent.men.fileread;

import lombok.Getter;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

@Cfg
public class FileParser {

    private static String FILE_TYPE;
    private static String FILE_NAME;

    public static void ReadConfigFile() throws IOException {
        Properties props = new Properties();
        props.load(new FileInputStream(new File("src/main/resources/config.ini")));

        FILE_TYPE=props.getProperty("FILE_TYPE");
        FILE_NAME=props.getProperty("FILE_NAME");
    }

    public static List<String[]> GetFileData() throws Exception {
        ReadConfigFile();
        List<String[]> data = new ArrayList<>();
        switch (FILE_TYPE) {
            case ("CSV"):
                data = CsvParser.readAll(FILE_NAME);
        }
        return data;
    }


    public static void print_data (List<String[]> data){
        for(String[] row : data){
            System.out.println(Arrays.toString(row));
        }
    }

    public static void test() throws Exception {
        List<String[]> Data;
        Data = GetFileData();
        print_data(Data);

    }

}

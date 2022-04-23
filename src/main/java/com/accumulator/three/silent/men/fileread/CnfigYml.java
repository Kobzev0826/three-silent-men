package com.accumulator.three.silent.men.fileread;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.util.Map;

public class CnfigYml {

    public static void main(String[] args) throws IOException {
        Map<String, Object> data  = Yml_parse("src/main/resources/config.yaml");
        for (int i=1; i<data.size();i++){
            String name = "source" + i;
            Map<String, Object> source = (Map<String, Object>) data.get(name);
            System.out.println(source.get("type"));
        }


    }

    public static Map<String, Object> Yml_parse(String filename) throws FileNotFoundException {
        InputStream inputStream = new FileInputStream(new File(filename));

        Yaml yaml = new Yaml();
        Map<String, Object> data = yaml.load(inputStream);
        return data;
    }


}

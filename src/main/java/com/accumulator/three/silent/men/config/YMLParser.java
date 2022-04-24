package com.accumulator.three.silent.men.config;

import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Map;

public class YMLParser {


    public static Map<String, Object> parseYML(String filename) throws FileNotFoundException {
        InputStream inputStream = new FileInputStream(filename);

        Yaml yaml = new Yaml();
        return yaml.load(inputStream);
    }
}

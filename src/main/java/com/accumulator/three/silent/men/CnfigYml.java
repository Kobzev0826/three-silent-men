package com.accumulator.three.silent.men;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

public class CnfigYml {

    public static void main(String[] args) throws IOException {
        InputStream inputStream = new FileInputStream(new File("src/main/resources/config.yaml"));

        Yaml yaml = new Yaml();
        Map<String, Object> data = yaml.load(inputStream);
        System.out.println(data);
    }

}

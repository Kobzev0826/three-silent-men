package com.accumulator.three.silent.men.model;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

import static com.accumulator.three.silent.men.fileread.CnfigYml.Yml_parse;

public class Manager {

    public void start(String ConfigDataPath) throws FileNotFoundException {

        Map<String, Object> data  = Yml_parse(ConfigDataPath);
        List<String> validAttributes = (List<String>) data.get("validAttributes");



        //цикл по указанным источникам
        for (int i=1; i<data.size();i++){
            String name = "source" + i;
            Map<String, Object> source = (Map<String, Object>) data.get(name);



        }
    }


}

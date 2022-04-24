package com.accumulator.three.silent.men.config;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapFilter {

    public static Map<String, Object> filterMap(Map<String, Object> map, List<String> validAttributes) {
        Map<String, Object> filteredMap = new HashMap<>();
        for(String key : map.keySet()) {
            if(validAttributes.contains(key))
                filteredMap.put(key, map.get(key));
        }

        return filteredMap;
    }



}

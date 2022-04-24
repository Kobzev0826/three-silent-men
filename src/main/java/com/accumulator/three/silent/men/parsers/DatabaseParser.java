package com.accumulator.three.silent.men.parsers;

import java.sql.*;
import java.util.*;

public class DatabaseParser {

    public static List<Map<String, Object>> readAll(String url, String user, String password, String table)
            throws SQLException {

        List<Map<String, Object>> gasStations = new ArrayList<>();
        Connection connection = null;
        Properties connectionProperties = new Properties();
        connectionProperties.put("user", user);
        connectionProperties.put("password", password);
        connection = DriverManager.getConnection(url, connectionProperties);

        String query = "SELECT * FROM " + table;
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
        String[] titles = new String[resultSetMetaData.getColumnCount()];
        for (int i = 0; i < titles.length; i++) {
            titles[i] = resultSetMetaData.getColumnName(i+1);
        }

        while(resultSet.next()) {
            Map<String, Object> map = new HashMap<>();
            for (int i = 0; i < titles.length; i++) {
                map.put(titles[i], resultSet.getString(i+1));
            }
            gasStations.add(map);
        }

        return gasStations;
    }
}

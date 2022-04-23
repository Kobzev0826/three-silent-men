package com.accumulator.three.silent.men;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

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

package com.accumulator.three.silent.men;

import com.opencsv.CSVReader;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.Reader;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
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

        String query = "SELECT * FROM ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, table);
        ResultSet resultSet = preparedStatement.executeQuery();
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
        String[] titles = new String[resultSetMetaData.getColumnCount()];
        for (int i = 0; i < titles.length; i++) {
            titles[i] = resultSetMetaData.getColumnName(i);
        }

        while(resultSet.next()) {
            Map<String, Object> map = new HashMap<>();
            for (int i = 0; i < titles.length; i++) {
                map.put(titles[i], resultSet.getString(i));
            }
            gasStations.add(map);
        }

        return gasStations;
    }
}

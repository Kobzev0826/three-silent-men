package com.accumulator.three.silent.men;

import com.accumulator.three.silent.men.fileread.CSVParser;

import java.io.IOException;
import java.net.URISyntaxException;

public class Main {
    public static void main(String[] args) throws IOException, URISyntaxException {
        DatabaseConnection databaseConnection = new DatabaseConnection("localhost", 27017);
        databaseConnection.writeToDatabaseMany(CSVParser.readAllExample());
    }
}

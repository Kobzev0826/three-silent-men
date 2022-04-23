package com.accumulator.three.silent.men;

import com.accumulator.three.silent.men.DatabaseParser;
import com.accumulator.three.silent.men.fileread.JsonParser;


public class Main {
    public static void main(String[] args) throws Exception {
        DatabaseConnection databaseConnection = new DatabaseConnection("localhost", 27017);
//        databaseConnection.writeToDatabaseMany(DatabaseParser.readAllExample());
//        databaseConnection.writeToDatabaseMany(DatabaseParser.readAll("jdbc:postgresql://localhost:5432/best_hack", "postgres", "1", "gas_stations"));
        databaseConnection.writeToDatabaseMany(JsonParser.readlAll());
    }
}

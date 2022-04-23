package com.accumulator.three.silent.men;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DatabaseConnection {

    private final String url;
    private final int port;
    private MongoClient mongoClient;
    private MongoDatabase mongoDatabase;
    private MongoCollection<Document> mongoCollection;

    public DatabaseConnection(String url, int port) {
        this.url = url;
        this.port = port;
        mongoClient = new MongoClient(url, port);
        mongoDatabase = mongoClient.getDatabase("best_hack");
        mongoCollection = mongoDatabase.getCollection("gas_stations");
    }

    public void writeToDatabaseOne(GasStation gasStation) {
        Document document = new Document();
        document.put("address", gasStation.getAddress());
        document.put("latitude", gasStation.getLatitude());
        document.put("longtitude", gasStation.getLongtitude());
        document.put("name", gasStation.getName());
        document.put("country", gasStation.getCountry());
        document.put("phone", gasStation.getPhone());
        document.put("region", gasStation.getRegion());
        try{
            mongoCollection.insertOne(document);
        }catch(Exception e) {
            //TODO appropriate error handling
            e.printStackTrace();
        }
    }

    public void writeToDatabaseMany(List<GasStation> gasStations) {
        List<Document> documents = new ArrayList<>();
        for (Iterator<GasStation> iterator = gasStations.listIterator(); iterator.hasNext(); ) {
            Document document = new Document();
            GasStation gasStation = iterator.next();
            document.put("address", gasStation.getAddress());
            document.put("latitude", gasStation.getLatitude());
            document.put("longtitude", gasStation.getLongtitude());
            document.put("name", gasStation.getName());
            document.put("country", gasStation.getCountry());
            document.put("phone", gasStation.getPhone());
            document.put("region", gasStation.getRegion());
            documents.add(document);
        }
        try{
            mongoCollection.insertMany(documents);
        }catch(Exception e) {
            //TODO appropriate error handling
            e.printStackTrace();
        }
    }
}

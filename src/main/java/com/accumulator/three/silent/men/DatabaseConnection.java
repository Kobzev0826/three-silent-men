package com.accumulator.three.silent.men;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.*;

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

    public void writeToDatabaseOne(Map<String, Object> gasStation) {
        Document document = new Document(gasStation);
        try{
            mongoCollection.insertOne(document);
        }catch(Exception e) {
            //TODO appropriate error handling
            e.printStackTrace();
        }
    }

    public void writeToDatabaseMany(List<Map<String, Object>> gasStations) {
        List<Document> documents = new ArrayList<>();
        for (Iterator<Map<String, Object>> iterator = gasStations.listIterator(); iterator.hasNext();) {
            Map<String, Object> map = iterator.next();
//            map = MapFilter.filterMap(map, Arrays.asList("latitude", "longtitude"));
            documents.add(new Document(map));
        }
        try{
            mongoCollection.insertMany(documents);
        }catch(Exception e) {
            //TODO appropriate error handling
            e.printStackTrace();
        }
    }
}

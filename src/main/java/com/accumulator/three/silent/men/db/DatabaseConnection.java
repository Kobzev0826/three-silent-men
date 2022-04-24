package com.accumulator.three.silent.men.db;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Sorts;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import static com.mongodb.client.model.Filters.eq;

public class DatabaseConnection {

    private final String url;
    private final int port;
    private MongoClient mongoClient;
    private MongoDatabase mongoDatabase;
    private static MongoCollection<Document> mongoCollection;

    public DatabaseConnection(String url, int port) {
        this.url = url;
        this.port = port;
        mongoClient = new MongoClient(url, port);
        mongoDatabase = mongoClient.getDatabase("best_hack");
        mongoCollection = mongoDatabase.getCollection("gas_stations");
    }

    public void writeToDatabaseOne(Map<String, Object> gasStation) {
        Document document = new Document(gasStation);
        //Проверка на дубликаты
        if(mongoCollection.find(eq("name", (String) document.get("name"))).first() != null)
            return;
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
            documents.add(new Document(map));
        }
        try{
            for(Document document : documents)
                writeToDatabaseOne(document);
        }catch(Exception e) {
            //TODO appropriate error handling
            e.printStackTrace();
        }
    }
}

package net.mc.tools.utilities;

import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class MongoDbConnection {


    private static final Logger log = LoggerFactory.getLogger(MongoDbConnection.class);

    MongoClientURI uri = null;
    MongoClient mongoClient = null;
    MongoDatabase database = null;
    MongoCollection<Document> test;

    public void connectTestDb() {
        uri = new MongoClientURI("mongodb://root@104.197.214.154:27017/admin?connectTimeoutMS=10000&authSource=admin&authMechanism=SCRAM-SHA-1&3t.uriVersion=3&3t.connection.name=test&3t.databases=admin,test-marketcube");
        mongoClient = new MongoClient(uri);
        database = mongoClient.getDatabase("test-marketcube");
        log.info("Connected to test database");
    }

    public void disconnectDb() {
        mongoClient.close();
        log.info("Database connection closed");
    }

}

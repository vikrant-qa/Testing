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
    MongoCollection<Document> messagesCollection, notificationsCollection, templatesCollection, environmentsCollection, applicationsCollection, userrolesCollection;

    public void connectNotificationDb() {
        uri = new MongoClientURI("mongodb://notification:fsdfasdJJKHJHK@enablers01-dev-mdb-mongodb.enablers01-dev.svc.cluster.local:27017/?authSource=notification");
        mongoClient = new MongoClient(uri);
        database = mongoClient.getDatabase("notification");
        log.info("Connected to notification database");
    }

    public void connectConfigurationDb() {
        uri = new MongoClientURI("mongodb://configuration:fsdfasdJJKHJHK@enablers01-dev-mdb-mongodb.enablers01-dev.svc.cluster.local:27017/?authSource=configuration");
        mongoClient = new MongoClient(uri);
        database = mongoClient.getDatabase("configuration");
        log.info("Connected to configuration database");
    }

    public void connectRoleManagerDb() {
        uri = new MongoClientURI("mongodb://roleuser:fsdfasdJJKHJHK@enablers01-dev-mdb-mongodb.enablers01-dev.svc.cluster.local:27017/?authSource=role-manager");
        mongoClient = new MongoClient(uri);
        database = mongoClient.getDatabase("role-manager");
        log.info("Connected to Role Manager database");
    }

    //Fetching user-roles
    public MongoCollection queryUserroles() {
        log.info("******************************** UserRoles ************************************************");
        userrolesCollection = database.getCollection("userroles");
        System.out.println("UserRoles  : " + userrolesCollection.count());
        return userrolesCollection;
    }


    //Fetching Environments
    public MongoCollection queryEnvironments() {
        log.info("******************************** Messages ************************************************");
        environmentsCollection = database.getCollection("Environments");
        System.out.println("Environments  : " + environmentsCollection.count());
        return environmentsCollection;
    }

    //Fetching Applications
    public MongoCollection queryApplications() {
        log.info("******************************** Messages ************************************************");
        applicationsCollection = database.getCollection("Applications");
        System.out.println("Applications  : " + applicationsCollection.count());
        return applicationsCollection;
    }


    //Fetching client messages
    public MongoCollection queryMessages() {
        log.info("******************************** Messages ************************************************");
        messagesCollection = database.getCollection("Messages");
        System.out.println("Messages  : " + messagesCollection.count());
        return messagesCollection;
    }


    //Fetching market notifications
    public MongoCollection queryNotifications() {
        log.info("******************************** Notifications ************************************************");
        notificationsCollection = database.getCollection("Notifications");
        System.out.println("Notifications  : " + notificationsCollection.count());
        return notificationsCollection;
    }


    //Fetching project templates
    public MongoCollection queryTemplates() {
        log.info("******************************** Templates ************************************************");
        templatesCollection = database.getCollection("Templates");
        System.out.println("Templates : " + templatesCollection.count());
        return templatesCollection;
    }

    public void disconnectDb() {
        mongoClient.close();
        log.info("Database connection closed");
    }

}

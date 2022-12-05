package repository;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import connection.SingletonMongoDB;
import org.bson.Document;

public class MongoRepository {

    private final MongoClient mongoClient;
    private static MongoDatabase mongoDB;

    public MongoRepository() {
        this.mongoClient = SingletonMongoDB.getInstance().getConnection();
        mongoDB = mongoClient.getDatabase("admin");
    }

    public void addDBOrSwitch(String name){
        MongoDatabase mongoDatabase = mongoClient.getDatabase(name);
        mongoDB = mongoDatabase;
        mongoDatabase.createCollection("default");
    }

    public MongoIterable<String> getAllDBName(){
        return mongoClient.listDatabaseNames();
    }

    public String getCurrentDBName(){
        return mongoDB.getName();
    }

    public MongoIterable<String> getAllCollection(){
        return mongoDB.listCollectionNames();
    }

    public void dropDB(String DBName){
        mongoClient.dropDatabase(DBName);
    }

    public void createCollection(String collectionName){
        mongoDB.createCollection(collectionName);
    }

    public void removeCollection(String collectionName){
        MongoCollection<Document> mongoCollection =  mongoDB.getCollection(collectionName);
        mongoCollection.drop();
    }

    public void createOneDocument(String collectionName,Document document){
        MongoCollection<Document> mongoCollection = mongoDB.getCollection(collectionName);
        mongoCollection.insertOne(document);
    }
}

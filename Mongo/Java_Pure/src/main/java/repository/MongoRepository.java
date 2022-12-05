package repository;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import connection.SingletonMongoDB;

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
}

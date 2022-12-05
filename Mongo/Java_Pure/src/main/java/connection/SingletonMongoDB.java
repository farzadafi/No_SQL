package connection;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

public class SingletonMongoDB {

    private MongoClient mongoClient;
    private static SingletonMongoDB obj;

    private SingletonMongoDB() {
        mongoClient = new MongoClient(
                new MongoClientURI( "mongodb://mongo:mongo@localhost:27017" )
        );
    }

    public static SingletonMongoDB getInstance() {
        if (obj==null)
            obj = new SingletonMongoDB();
        return obj;
    }

    public MongoClient getConnection() {
        return mongoClient;
    }

    public void setConnection(MongoClient mongoClient) {
        this.mongoClient = mongoClient;
    }

    public static SingletonMongoDB getObj() {
        return obj;
    }

    public static void setObj(SingletonMongoDB obj) {
        SingletonMongoDB.obj = obj;
    }
}

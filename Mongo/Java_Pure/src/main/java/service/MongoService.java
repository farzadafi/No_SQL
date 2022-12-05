package service;

import com.mongodb.Block;
import com.mongodb.client.MongoIterable;
import repository.MongoRepository;

import java.util.Scanner;

public class MongoService {

    private final Scanner input;
    private final MongoRepository mongoRepository;

    public MongoService() {
        input = new Scanner(System.in);
        this.mongoRepository = new MongoRepository();
    }

    public void addDBOrSwitch(){
        System.out.print("Enter DB name:");
        String name = input.nextLine();
        mongoRepository.addDBOrSwitch(name);
        System.out.println("OK!");
    }

    public void getAllDBName(){
        MongoIterable<String> DBName = mongoRepository.getAllDBName();
        Block<String> printer = System.out::println;
        DBName.forEach(printer);
    }

    public String getCurrentDBName(){
        return mongoRepository.getCurrentDBName();
    }

    public void getCollectionName(){
        MongoIterable<String> collectionName = mongoRepository.getAllCollection();
        Block<String> printer = System.out::println;
        collectionName.forEach(printer);
    }

    public void dropDB(){
        System.out.println("Enter DB name:");
        String DBName = input.nextLine();
        mongoRepository.dropDB(DBName);
    }

    public void createCollection(){
        System.out.println("Enter collection name:");
        String collectionName = input.nextLine();
        mongoRepository.createCollection(collectionName);
    }
}

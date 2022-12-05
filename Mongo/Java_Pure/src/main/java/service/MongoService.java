package service;

import com.mongodb.Block;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoIterable;
import org.bson.Document;
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

    public void removeCollection(){
        System.out.println("Enter name of collection:");
        String collectionName = input.nextLine();
        mongoRepository.removeCollection(collectionName);
    }

    public void createOneDocument(){
        String collectionName,firstName,lastName;
        System.out.println("Enter name of collection:");
        collectionName = input.nextLine();
        System.out.println("Enter your name:");
        firstName = input.nextLine();
        System.out.println("Enter your lastName:");
        lastName = input.nextLine();
        Document document = new Document();
        document.put("firstName",firstName);
        document.put("lastName",lastName);
        mongoRepository.createOneDocument(collectionName,document);
    }

    public void removeOneDocument(){
        String collectionName,firstName;
        System.out.println("Enter nam of collection:");
        collectionName = input.nextLine();
        System.out.println("Enter first name for remove:");
        firstName = input.nextLine();
        Document document = new Document();
        document.put("firstName",firstName);
        mongoRepository.removeOneDocument(collectionName,document);
    }

    public void findOneDocument(){
        String collectionName,firstName;
        System.out.println("Enter name of collection:");
        collectionName = input.nextLine();
        System.out.println("Enter firstName for find");
        firstName = input.nextLine();
        Document document = new Document();
        document.put("firstName",firstName);
        FindIterable<Document> mongoIterable = mongoRepository.findOneDocument(collectionName,document);
        for (Document d:mongoIterable
        ) {
            System.out.println(d.toString());
        }
    }
}

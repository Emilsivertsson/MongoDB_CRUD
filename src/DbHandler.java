
import com.mongodb.*;
import com.mongodb.client.*;
import com.mongodb.client.MongoClient;
import org.bson.BsonDocument;
import org.bson.BsonInt64;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.List;

public class DbHandler {


    MongoDatabase db = null;

    MongoCollection<Document> collection = null;


    public DbHandler(String connString) {
        Connect(connString, "Person");
    }

    public DbHandler(String connString, String dbname) {
        Connect(connString, dbname);
    }

    public void Connect(String connString, String myDatabase) {

        //berätta för mongodb vilken version av server api vi använder
        ServerApi serverApi = ServerApi.builder()
                .version(ServerApiVersion.V1)
                .build();

        //vi skapar en ny connection
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString(connString))
                //vilket api vi vill ha
                .serverApi(serverApi)
                //designpattern builder
                .build();

        // Create a new client and connect to the server med en factory method
        MongoClient mongoClient = MongoClients.create(settings);

        // Send a ping to confirm a successful connection
        db = mongoClient.getDatabase(myDatabase);

        System.out.println("Pinged your deployment. You successfully connected to MongoDB!");
    }

    //hämtar en collection, om man vill använda fler än en collection, så behöver man fler instancer
    public void getCollection(String collectionName) {
        collection = db.getCollection(collectionName);
    }

    public void insertCustomer(Customer person) {
        //kolla om collection är null, om den är det, så skapa en ny connection
        if (collection == null || collection.equals("Anställd")) {
            getCollection("Kund");
        }
        //ska en ny person och lägg till datan
        Document newCustomer = new Document("name", person.getName())
                .append("age", person.getAge())
                .append("adress", person.getAddress())
                .append("customerId", person.getCustomerId());

        //kolla om personen redan finns i collection
        long amount = collection.countDocuments(newCustomer);
        if(amount == 0){
        //skicka in personen i collection
        collection.insertOne(newCustomer);
        System.out.println("Customer added");
        }
    }

    public void insertEmployee(Employee person) {
        //kolla om collection är null, om den är det, så skapa en ny connection
        if (collection == null || collection.equals("Kund")) {
            getCollection("Anställd");
        }
        //ska en ny person och lägg till datan
        Document newemployee = new Document("name", person.getName())
                .append("age", person.getAge())
                .append("adress", person.getAddress())
                .append("employeeid", person.getEmployeeId());

        //kolla om personen redan finns i collection
        long amount = collection.countDocuments(newemployee);
        if(amount == 0){
        //skicka in personen i collection
        collection.insertOne(newemployee);
        System.out.println("Employee added");
        }


    }

    public void printAllCostumers() {
        if (collection == null) {
            getCollection("Kund");
        }

        //hämta alla i collection
        FindIterable<Document> result = collection.find();

        //skriv ut alla i collection
        for (Document res : result) {
            System.out.println(res.toJson());

        }

    }

    public void printAllEmployees() {
        if (collection == null) {
            getCollection("Anställd");
        }

        //hämta alla i collection
        FindIterable<Document> result = collection.find();

        //skriv ut alla i collection
        for (Document res : result) {
            System.out.println(res.toJson());

        }
    }
}




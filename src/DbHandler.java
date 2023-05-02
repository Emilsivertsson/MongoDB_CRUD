
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

    MongoCollection <Document> collection = null;


    public DbHandler (String connString){
        Connect(connString,"MyDatabase");
    }

    public DbHandler (String connString, String dbname){
        Connect(connString,dbname);
    }

    public void Connect(String connString, String myDatabase){

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
        try (MongoClient mongoClient = MongoClients.create(settings)) {
            try {
                // Send a ping to confirm a successful connection
                db = mongoClient.getDatabase(myDatabase);

                System.out.println("Pinged your deployment. You successfully connected to MongoDB!");
            } catch (MongoException e) {
                e.printStackTrace();
            }
        }
    }
    //hämtar en collection, om man vill använda fler än en collection, så behöver man fler instancer
    public void getCollection(String collectionName){
        collection = db.getCollection(collectionName);
    }

    public void insertCustomer(Customer person) {
        //kolla om collection är null, om den är det, så skapa en ny connection
        if (collection == null || collection.equals("Anställd")){
            getCollection("Kund");
        }
        //ska en ny person och lägg till datan
        Document newCustomer = new Document("name", person.getName())
                .append("age", person.getAge())
                .append("adress", person.getAddress())
                .append("customerId", person.getCustomerId());

        //kolla om personen redan finns i collection
        //long amount = collection.countDocuments(newperson);
        //if(amount == 0){
        //skicka in personen i collection
        collection.insertOne(newCustomer);
        //}
    }
        public void insertEmployee (Employee person){
            //kolla om collection är null, om den är det, så skapa en ny connection
            if (collection == null || collection.equals("Kund")){
                getCollection("Anställd");
            }
            //ska en ny person och lägg till datan
            Document newemployee = new Document("name", person.getName())
                    .append("age", person.getAge())
                    .append("adress", person.getAddress())
                    .append("employeeid", person.getEmployeeId ());

            //kolla om personen redan finns i collection
            //long amount = collection.countDocuments(newperson);
            //if(amount == 0){
            //skicka in personen i collection
            collection.insertOne(newemployee);
            //}


        }

        public void printAllCostumers (){
            if (collection == null || collection.equals("Anställd")){
                getCollection("Kund");
            }
            //skapa en cursor som går igenom alla dokument i collection
            MongoCursor<Document> cursor = collection.find().iterator();
            try {
                while (cursor.hasNext()) {
                    //skapa en ny document som innehåller ett dokument i collection
                    Document doc = cursor.next();
                    //skriv ut dokumentet
                    System.out.println(doc.toJson());
                }
            } finally {
                //stäng cursorn
                cursor.close();
            }
        }

        public void printAllEmployees(){
            if (collection == null || collection.equals("Kund")){
                getCollection("Anställd");
            }
            //skapa en cursor som går igenom alla dokument i collection
            MongoCursor<Document> cursor = collection.find().iterator();
            try {
                while (cursor.hasNext()) {
                    //skapa en ny document som innehåller ett dokument i collection
                    Document doc = cursor.next();
                    //skriv ut dokumentet
                    System.out.println(doc.toJson());
                }
            } finally {
                //stäng cursorn
                cursor.close();
            }
        }
    }




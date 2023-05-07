
import com.mongodb.*;
import com.mongodb.client.*;
import com.mongodb.client.MongoClient;
import org.bson.Document;

public class DbHandler {

    MongoDatabase db = null;

    MongoCollection<Document> collection = null;


    public DbHandler(String connString) {
        Connect(connString, "Person");
    }

    public DbHandler(String connString, String dbname) {
        Connect(connString, dbname);
    }

    /**
     * @param connString inputs connection string
     * @param myDatabase inputs name of database
     *                   Connects to the database
     */
    public void Connect(String connString, String myDatabase) {
        if (connString == null) {
            connString = "mongodb://localhost:27017";
        }

        //tells mongodb which version of server api we are using
        ServerApi serverApi = ServerApi.builder()
                .version(ServerApiVersion.V1)
                .build();

        //sets the settings for the connection
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString(connString))
                .serverApi(serverApi)
                .build();

        // Create a new client and with the settings and connect to the server and our database
        MongoClient mongoClient = MongoClients.create(settings);
        db = mongoClient.getDatabase("Person");

    }

    /**
     * @param collectionName inputs name of collection you want to fetch
     * sets collection to the collection you want to fetch
     */
    public void getCollection(String collectionName) {
        collection = db.getCollection(collectionName);
    }

    /**
     * @param person inputs a Customer object
     *               into the Kund collection
     */
    public void insertCustomer(Customer person) {
        if (collection == null || collection.getNamespace().getCollectionName().equals("Anställd")) {
            getCollection("Kund");
        }
        Document newCustomer = new Document("name", person.getName())
                .append("age", person.getAge())
                .append("adress", person.getAddress())
                .append("customerId", person.getCustomerId());
        collection.insertOne(newCustomer);
    }

    /**
     * @param person inputs an Employee object
     *               into the Anställd collection
     */
    public void insertEmployee(Employee person) {
        if (collection == null || collection.getNamespace().getCollectionName().equals("Kund")) {
            getCollection("Anställd");
        }
        Document newemployee = new Document("name", person.getName())
                .append("age", person.getAge())
                .append("adress", person.getAddress())
                .append("employeeid", person.getEmployeeId());

        collection.insertOne(newemployee);
    }

    /**
     *  sets the correct collection and prints all documents in that collection
     */
    public void printAllCostumers() {
        if (collection == null || collection.getNamespace().getCollectionName().equals("Anställd")){
            getCollection("Kund");
        }
        MongoCursor<Document> result = collection.find().iterator();
        while (result.hasNext()) {
            System.out.println(result.next().toJson());
        }
    }

    /**
     *  sets the correct collection and prints all documents in that collection
     */
    public void printAllEmployees() {
        if (collection == null || collection.getNamespace().getCollectionName().equals("Kund")){
            getCollection("Anställd");
        }
        MongoCursor<Document> result = collection.find().iterator();
        while (result.hasNext()) {
            System.out.println(result.next().toJson());
        }
    }




    /**
     * @param employeeId inputs an employeeId
     *                   sets the correct collection and deletes the document with the same employeeId
     */
    public void deleteEmployee(int employeeId) {
        if (collection == null || collection.getNamespace().getCollectionName().equals("Kund")){
            getCollection("Anställd");
        }
        Document doc = new Document("employeeid", employeeId);
        collection.findOneAndDelete(doc);
    }

    /**
     * @param customerid inputs a customerId
     *                   sets the correct collection and deletes the document with the same customerId
     */
    public void deleteCustomer(int customerid) {
        if (collection == null || collection.getNamespace().getCollectionName().equals("Anställd")) {
            getCollection("Kund");
        }
        Document doc = new Document("customerId", customerid);
        collection.findOneAndDelete(doc);
    }

    /**
     *
     * @param employeeid inputs an employeeid
     * @param employee inputs an employee object
     *                 sets the correct collection and updates the document with the same employeeid
     */
    public void updateEmployee(int employeeid, Employee employee) {
        if (collection == null || collection.getNamespace().getCollectionName().equals("Kund")){
            getCollection("Anställd");
        }
        Document doc = new Document("employeeid", employeeid);
        collection.replaceOne(doc, employee.toDocument());
    }

    /**
     *
     * @param customerId inputs a customerId
     * @param customer inputs a customer object
     *                 sets the correct collection and updates the document with the same customerId
     */
    public void updateCustomer(int customerId, Customer customer) {
        if (collection == null || collection.getNamespace().getCollectionName().equals("Anställd")){
            getCollection("Kund");
        }
        Document doc = new Document("customerId", customerId);
        collection.replaceOne(doc, customer.toDocument());
    }
}





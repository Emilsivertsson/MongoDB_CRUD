import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoException;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class DbHandler {

    Keyreader keyreader = new Keyreader("Pass");
    String connectionString = "mongodb+srv://emilsivertsson:"+keyreader.getPasscode()+"@homecluster.ekna2wp.mongodb.net/?retryWrites=true&w=majority";


}




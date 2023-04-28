
import com.mongodb.*;
import com.mongodb.client.*;
import com.mongodb.client.MongoClient;
import org.bson.BsonDocument;
import org.bson.BsonInt64;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.List;

public class DbHandler {

    Keyreader keyreader = new Keyreader("Pass");
    String connectionString = "mongodb+srv://emilsivertsson:"+keyreader.getPasscode()+"@homecluster.ekna2wp.mongodb.net/?retryWrites=true&w=majority";

    String DB = "Person";






}





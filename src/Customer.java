import org.bson.Document;

public class Customer extends Person {
    private int customerId;
    public Customer(String name, int age, String address, int customerId) {
        super(name, age, address);
        this.customerId = customerId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public Document toDocument(){
        return new Document("name", getName())
                .append("age", getAge())
                .append("adress", getAddress())
                .append("customerId", getCustomerId());

    }

    public static Customer fromdocument(Document doc){

        return new Customer(
                doc.getString("name"),
                doc.getInteger("age"),
                doc.getString("adress"),
                doc.getInteger("customerId")
        );

    }

    public static Customer fromJson (String json){
        Document doc = Document.parse(json);
        return fromdocument(doc);

    }
    public String toJson(){

        return toDocument().toJson();

    }
}


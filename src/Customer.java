import org.bson.Document;

public class Customer extends Person {
    private final int customerId;
    public Customer(String name, int age, String address, int customerId) {
        super(name, age, address);
        this.customerId = customerId;
    }

    public int getCustomerId() {
        return customerId;
    }

    /**
     * adapeter method to convert Customer to Document
     * @return document with Customer info
     */
    public Document toDocument(){
        return new Document("name", getName())
                .append("age", getAge())
                .append("adress", getAddress())
                .append("customerId", getCustomerId());
    }





}


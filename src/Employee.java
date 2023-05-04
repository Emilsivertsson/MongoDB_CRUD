import org.bson.Document;

public class Employee extends Person{

    private final int employeeId;
    public Employee(String name, int age, String address, int employeeId) {
        super(name, age, address);
        this.employeeId = employeeId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    /**
     * adapeter method to convert Employee to Document
     * @return document with Employee info
     */
    public Document toDocument(){
        return new Document("name", getName())
                .append("age", getAge())
                .append("adress", getAddress())
                .append("customerId", getEmployeeId());
    }
}

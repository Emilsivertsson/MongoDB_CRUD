import org.bson.Document;

public class Employee extends Person{

    private int employeeId;
    public Employee(String name, int age, String address, int employeeId) {
        super(name, age, address);
        this.employeeId = employeeId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public Document toDocument(){
        return new Document("name", getName())
                .append("age", getAge())
                .append("adress", getAddress())
                .append("customerId", getEmployeeId());

    }

    public static Employee fromdocument(Document doc){

        return new Employee(
                doc.getString("name"),
                doc.getInteger("age"),
                doc.getString("adress"),
                doc.getInteger("customerId")
        );

    }

    public static Employee fromJson (String json){
        Document doc = Document.parse(json);
        return fromdocument(doc);

    }
    public String toJson(){

        return toDocument().toJson();

    }
}

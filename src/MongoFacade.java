public class MongoFacade {

    Keyreader keyreader = new Keyreader("Pass");
    String connectionString = "mongodb+srv://emilsivertsson:"+keyreader.getPasscode()+"@homecluster.ekna2wp.mongodb.net/?retryWrites=true&w=majority";

    DbHandler dbHandler = new DbHandler(connectionString, "Person");

    public void addCustomer(Customer customer) {
        dbHandler.insertCustomer(customer);
    }


    public void addEmployee(Employee employee) {
        dbHandler.insertEmployee(employee);
    }

    public void listAllEmployees() {
        dbHandler.printAllEmployees();
    }

    public void listAllCustomers() {
        dbHandler.printAllCostumers();
    }
}

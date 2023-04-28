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
}

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

}

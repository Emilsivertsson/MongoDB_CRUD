
import java.util.Scanner;

public class Application {

    Scanner scanner = new Scanner(System.in);

    MongoFacade mongoFacade = new MongoFacade();

    public void start(){
        boolean run = true;

        while (run){
            Menu.mainMenu();
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1 -> addCustomer();
                case 2 -> addEmployee();
                case 3 -> deleteCustomer();
                case 4 -> deleteEmployees();
                case 5 -> updateCustomer();
                case 6 -> updateEmployees();
                case 7 -> listAllCustomers();
                case 8 -> listAllEmployees();
                case 9 -> {
                    Menu.exit();
                    run = false;
                }
            }
        }
    }

    private void listAllEmployees() {
        mongoFacade.listAllEmployees();
    }

    private void listAllCustomers() {
        mongoFacade.listAllCustomers();
    }

    private void updateEmployees() {
        mongoFacade.listAllEmployees();
        System.out.println("Enter employee id that you want to update: ");
        int employeeid = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter new name: ");
        String name = scanner.nextLine();
        System.out.println("Enter new age: ");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter new address: ");
        String address = scanner.nextLine();
        Employee employee = new Employee(name, age, address, employeeid);
        mongoFacade.updateEmployees(employeeid, employee);
    }

    private void updateCustomer() {
        mongoFacade.listAllCustomers();
        System.out.println("Enter customer id that you want to update: ");
        int customerId = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter new name: ");
        String name = scanner.nextLine();
        System.out.println("Enter new age: ");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter new address: ");
        String address = scanner.nextLine();
        Customer customer = new Customer(name, age, address, customerId);
        mongoFacade.updateCustomer(customerId, customer);


    }

    private void deleteEmployees() {
        mongoFacade.listAllEmployees();
        System.out.println("Enter employee id that you want to delete: ");
        int id = Integer.parseInt(scanner.nextLine());
        mongoFacade.deleteEmployees(id);
        System.out.println("Employee deleted");
    }

    private void deleteCustomer() {
        mongoFacade.listAllCustomers();
        System.out.println("Enter customer id that you want to delete: ");
        int id = Integer.parseInt(scanner.nextLine());
        mongoFacade.deleteCustomer(id);
        System.out.println("Customer deleted");
    }

    private void addEmployee() {
        boolean add = true;
        while (add) {
            try {
                System.out.println("Enter name: ");
                String name = scanner.nextLine();
                System.out.println("Enter age: ");
                int age = Integer.parseInt(scanner.nextLine());
                System.out.println("Enter address: ");
                String address = scanner.nextLine();
                System.out.println("Enter employee id: ");
                int employeeId = Integer.parseInt(scanner.nextLine());
                Employee emp = new Employee(name, age, address, employeeId);
                mongoFacade.addEmployee(emp);
            } catch (Exception e) {
                System.out.println("Invalid input, please try again");
                break;
            }

            System.out.println("Employee added");
            System.out.println("Add another employee? (y/n)");
            String answer = scanner.nextLine();
            if (answer.equalsIgnoreCase("n")) {
                add = false;
            }
        }


    }

    private void addCustomer() {
        boolean add = true;
        while (add){
            try {
                System.out.println("Enter name: ");
                String name = scanner.nextLine();
                System.out.println("Enter age: ");
                int age = Integer.parseInt(scanner.nextLine());
                System.out.println("Enter address: ");
                String address = scanner.nextLine();
                System.out.println("Enter customer id: ");
                int customerId = Integer.parseInt(scanner.nextLine());
                Customer cust = new Customer(name, age, address, customerId);
                mongoFacade.addCustomer(cust);
            } catch (Exception e){
                System.out.println("Invalid input, please try again");
                break;
            }
            System.out.println("Customer added");
            System.out.println("Add another customer? (y/n)");
            String answer = scanner.nextLine();
            if (answer.equalsIgnoreCase("n")){
                add = false;
            }
        }


    }
}

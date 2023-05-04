
import java.util.InputMismatchException;
import java.util.Scanner;

public class Application {

    //initiate scanner and mongoFacade
    Scanner scanner = new Scanner(System.in);

    MongoFacade mongoFacade = new MongoFacade();

    //application start
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
                    System.exit(0);
                    run = false;
                } default -> System.out.println("Invalid input, please try again");
            }
        }
    }

    /**
     * Takes users input and initiates a new Employee object and sends to the facade
     */
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
    /**
     * Takes users input and initiates a new Customer object and sends to the facade
     */
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


    /**
     * Takes users input and initiates a new Employee, sends Id and Employee-object to the facade
     */
    private void updateEmployees() {
        String name;
        int age;
        String address;
        int id;
        mongoFacade.listAllEmployees();
        try {
            System.out.println("Enter id that you want to update: ");
            id = Integer.parseInt(scanner.nextLine());
            System.out.println("Enter new name: ");
            name = scanner.nextLine();
            System.out.println("Enter new age: ");
            age = Integer.parseInt(scanner.nextLine());
            System.out.println("Enter new address: ");
            address = scanner.nextLine();
            Employee employee = new Employee(name, age, address, id);
            mongoFacade.updateEmployees(id, employee);
            System.out.println("Employee updated");
        } catch (InputMismatchException e) {
            System.out.println("Wrong input");
        }
    }

    /**
     * Takes users input and initiates a new Customer, sends Id and Customer-object to the facade
     */
    private void updateCustomer() {
        String name;
        int age;
        String address;
        int Id;
        mongoFacade.listAllCustomers();
        try {
            System.out.println("Enter id that you want to update: ");
            Id = Integer.parseInt(scanner.nextLine());
            System.out.println("Enter new name: ");
            name = scanner.nextLine();
            System.out.println("Enter new age: ");
            age = Integer.parseInt(scanner.nextLine());
            System.out.println("Enter new address: ");
            address = scanner.nextLine();
            Customer customer = new Customer(name, age, address, Id);
            mongoFacade.updateCustomer(Id, customer);
            System.out.println("Customer updated");
        } catch (InputMismatchException e) {
            System.out.println("Wrong input");
        }
    }

    /**
     * takes users input and sends to facade
     */
    private void deleteEmployees() {
        int id = 0;
        mongoFacade.listAllEmployees();
        System.out.println("Enter employee id that you want to delete: ");
        try {
            id = Integer.parseInt(scanner.nextLine());
        } catch (InputMismatchException e) {
            System.out.println("Wrong input");
        }
        mongoFacade.deleteEmployees(id);
        System.out.println("Employee deleted");
    }

    /**
     * takes users input and sends to facade
     */
    private void deleteCustomer() {
        int id= 0;
        mongoFacade.listAllCustomers();
        System.out.println("Enter customer id that you want to delete: ");
        try {
            id = Integer.parseInt(scanner.nextLine());
        } catch (InputMismatchException e) {
            System.out.println("Wrong input");
        }
        mongoFacade.deleteCustomer(id);
        System.out.println("Customer deleted");
    }

    /**
     * read all from employee collection
     */
    private void listAllEmployees() {
        mongoFacade.listAllEmployees();
    }

    /**
     * read all from customer collection
     */
    private void listAllCustomers() {
        mongoFacade.listAllCustomers();
    }
}

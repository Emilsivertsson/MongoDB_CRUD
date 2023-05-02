
import java.util.Scanner;

public class Application {

    Scanner scanner = new Scanner(System.in);

    MongoFacade mongoFacade = new MongoFacade();

    public void start(){
        boolean run = true;

        while (run){
            Menu.mainMenu();
            int choice = Integer.parseInt(scanner.nextLine());
            switch(choice){
                case 1:
                    addCustomer();
                    break;
                case 2:
                    addEmployee();
                    break;
                case 3:
                    deleteCustomer();
                    break;
                case 4:
                    deleteEmployees();
                    break;
                case 5:
                    updateCustomer();
                    break;
                case 6:
                    updateEmployees();
                    break;
                case 7:
                    listAllCustomers();
                    break;
                case 8:
                    listAllEmployees();
                    break;
                case 9:
                    Menu.exit();
                    run = false;
                    break;
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
        //MongoFacade.updateEmployees();
    }

    private void updateCustomer() {
        //MongoFacade.updateCustomer();

    }

    private void deleteEmployees() {
        //MongoFacade.deleteEmployees();
    }

    private void deleteCustomer() {
        //MongoFacade.deleteCustomer();
    }

    private void addEmployee() {
        boolean add = true;
        while (add){
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
            System.out.println("Add another employee? (y/n)");
            String answer = scanner.nextLine();
            if (answer.equalsIgnoreCase("n")){
                add = false;
            }
        }


    }

    private void addCustomer() {
        boolean add = true;
        while (add){
            System.out.println("Enter name: ");
            String name = scanner.nextLine();
            System.out.println("Enter age: ");
            int age = Integer.parseInt(scanner.nextLine());
            System.out.println("Enter address: ");
            String address = scanner.nextLine();
            System.out.println("Enter employee id: ");
            int customerId = Integer.parseInt(scanner.nextLine());
            Customer cust = new Customer(name, age, address, customerId);
            mongoFacade.addCustomer(cust);
            System.out.println("Add another customer? (y/n)");
            String answer = scanner.nextLine();
            if (answer.equalsIgnoreCase("n")){
                add = false;
            }
        }


    }
}

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Scanner;

public class Application {
    Scanner scanner = new Scanner(System.in);
    DbHandler dbHandler = new DbHandler();

    public void start(){
        boolean run = true;
        Menu.mainMenu();
        int choice = Integer.parseInt(scanner.nextLine());
        while (run){
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
        MongoFacade.listAllEmployees();
    }

    private void listAllCustomers() {
        MongoFacade.listAllCustomers();
    }

    private void updateEmployees() {
        MongoFacade.updateEmployees();
    }

    private void updateCustomer() {
        MongoFacade.updateCustomer();

    }

    private void deleteEmployees() {
        MongoFacade.deleteEmployees();
    }

    private void deleteCustomer() {
        MongoFacade.deleteCustomer();
    }

    private void addEmployee() {
        MongoFacade.addEmployee();
    }

    private void addCustomer() {
        MongoFacade.addCustomer();
    }
}

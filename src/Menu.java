public class Menu {

    //main textmenu
    static void mainMenu() {
        System.out.println("1. Add a new customer");
        System.out.println("2. Add a new employee");
        System.out.println("3. delete a customer");
        System.out.println("4. delete an employee");
        System.out.println("5. update a customer");
        System.out.println("6. update an employee");
        System.out.println("7. list all customers");
        System.out.println("8. list all employees");
        System.out.println("9. exit");
    }

    //ask for name
    static void askName() {
        System.out.println("Enter name: ");
    }

    //ask for age
    static void askAge() {
        System.out.println("Enter age: ");
    }
    //ask for address
    static void askAddress() {
        System.out.println("Enter address: ");
    }
    //ask for customer id
    static void askCustomerId() {
        System.out.println("Enter customer id: ");
    }
    //ask for employee id
    static void askEmployeeId() {
        System.out.println("Enter employee id: ");
    }

    //list all customers
    static void listAllCustomers() {
        System.out.println("List of all customers: ");
    }

    //list all employees
    static void listAllEmployees() {
        System.out.println("List of all employees: ");
    }

    //ask for customer id to delete
    static void askCustomerIdToDelete() {
        System.out.println("Enter customer id to delete: ");
    }

    //ask for employee id to delete
    static void askEmployeeIdToDelete() {
        System.out.println("Enter employee id to delete: ");
    }

    //ask for customer id to update
    static void askCustomerIdToUpdate() {
        System.out.println("Enter customer id to update: ");
    }

    //ask for employee id to update
    static void askEmployeeIdToUpdate() {
        System.out.println("Enter employee id to update: ");
    }

    //Exit
    static void exit() {
        System.out.println("Thank you for exiting through the giftshop.");
    }

}

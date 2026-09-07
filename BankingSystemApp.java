import java.util.Collection;
import java.util.Scanner;

public class BankingSystemApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CustomerService customerService = new CustomerServiceImpl();

        int choice = 0;

        while (choice != 4) {
            System.out.println("\nBanking System");
            System.out.println("1. Add Customer");
            System.out.println("2. Find Customer by Id");
            System.out.println("3. List all Customers");
            System.out.println("4. Exit");
            System.out.print("Enter your choice : ");

            choice = Integer.parseInt(scanner.nextLine().trim());

            switch (choice) {
                case 1:
                    System.out.println("Enter Customer Details");

                    System.out.print("Customer Id : ");
                    int customerId = Integer.parseInt(scanner.nextLine().trim());

                    System.out.print("Name : ");
                    String name = scanner.nextLine().trim();

                    System.out.print("Address : ");
                    String address = scanner.nextLine().trim();

                    System.out.print("Contact No. : ");
                    String contact = scanner.nextLine().trim();

                    Customer customer = new Customer(customerId, name, address, contact);
                    customerService.addCustomer(customer);
                    break;

                case 2:
                    System.out.print("Customer Id : ");
                    int searchId = Integer.parseInt(scanner.nextLine().trim());

                    Customer found = customerService.findCustomerById(searchId);
                    if (found != null) {
                        System.out.println(found);
                    } else {
                        System.out.println("No customer found with ID : " + searchId);
                    }
                    break;

                case 3:
                    Collection<Customer> allCustomers = customerService.getAllCustomers();
                    if (allCustomers.isEmpty()) {
                        System.out.println("No customers added yet.");
                    } else {
                        for (Customer c : allCustomers) {
                            System.out.println(c);
                        }
                    }
                    break;

                case 4:
                    System.out.println("Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}
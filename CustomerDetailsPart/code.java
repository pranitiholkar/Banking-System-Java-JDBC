import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
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

class Customer {

    private int customerID;
    private String name;
    private String address;
    private String contact;

    public Customer(int customerID, String name, String address, String contact) {
        this.customerID = customerID;
        this.name = name;
        this.address = address;
        this.contact = contact;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "Customer ID: " + customerID +
                ", Name: " + name +
                ", Address: " + address +
                ", Contact: " + contact;
    }
}

interface CustomerService {

    void addCustomer(Customer customer);

    Customer findCustomerById(int id);

    Collection<Customer> getAllCustomers();
}

class CustomerServiceImpl implements CustomerService {

    private Map<Integer, Customer> customers = new HashMap<>();

    @Override
    public void addCustomer(Customer customer) {
        customers.put(customer.getCustomerID(), customer);
    }

    @Override
    public Customer findCustomerById(int id) {
        return customers.get(id);
    }

    @Override
    public Collection<Customer> getAllCustomers() {
        return customers.values();
    }
}
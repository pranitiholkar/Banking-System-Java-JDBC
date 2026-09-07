import java.util.Collection;

public interface CustomerService {

    void addCustomer(Customer customer);

    Customer findCustomerById(int id);

    Collection<Customer> getAllCustomers();
}
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class CustomerServiceImpl implements CustomerService {

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
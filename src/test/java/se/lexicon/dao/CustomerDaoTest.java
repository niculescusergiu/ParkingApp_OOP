package se.lexicon.dao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.lexicon.dao.implementations.CustomerDaoImpl;
import se.lexicon.model.Customer;

import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
public class CustomerDaoTest {
    private CustomerDaoImpl customerDao;

    @BeforeEach
    public void setUp() {
        customerDao = new CustomerDaoImpl();
    }
    @Test
    public void testCreateCustomer() {
        Customer customer = new Customer(1, "Sergiu", "123456789");
        Customer createdCustomer = customerDao.create(customer);
        assertEquals(customer, createdCustomer);

        // Verify that the customer was added
        Optional<Customer> foundCustomer = customerDao.find(1);
        assertTrue(foundCustomer.isPresent());
        assertEquals(customer, foundCustomer.get());
    }

    @Test
    public void testCreateCustomerAlreadyExists() {
        Customer customer = new Customer(2, "Sabina", "123459876");
        customerDao.create(customer);

        // Attempt to create a customer with the same ID
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            customerDao.create(new Customer(2, "Sabina", "123459876"));
        });
        assertEquals("Customer already exists.", exception.getMessage());
    }

    @Test
    public void testFindCustomer() {
        Customer customer = new Customer(1, "Sergiu", "123456789");
        customerDao.create(customer);

        Optional<Customer> foundCustomer = customerDao.find(1);
        assertTrue(foundCustomer.isPresent());
        assertEquals(customer, foundCustomer.get());
    }

    @Test
    public void testFindCustomerNotFound() {
        Optional<Customer> foundCustomer = customerDao.find(999);
        assertFalse(foundCustomer.isPresent());
    }

    @Test
    public void testRemoveCustomer() {
        Customer customer = new Customer(1, "Sergiu", "123456789");
        customerDao.create(customer);

        boolean removed = customerDao.remove(1);
        assertTrue(removed);

        // Verify that the customer was removed
        Optional<Customer> foundCustomer = customerDao.find(1);
        assertFalse(foundCustomer.isPresent());
    }

    @Test
    public void testRemoveCustomerNotFound() {
        boolean removed = customerDao.remove(999);
        assertFalse(removed);
    }
}

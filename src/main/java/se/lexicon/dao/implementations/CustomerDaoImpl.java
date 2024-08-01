package se.lexicon.dao.implementations;

import se.lexicon.model.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class CustomerDaoImpl {
    private List<Customer> storage = new ArrayList<>();

    public Customer create(Customer customer) {
        for (Customer customerElement : storage){
            if(customerElement.getId() == customer.getId()){
                throw new IllegalArgumentException("Customer already exists.");
            }
        }
        storage.add(customer);
        return customer;
    }

    public Optional<Customer> find(int id) {
        for (Customer customer : storage) {
            if (customer.getId() == id) {
                return Optional.of(customer);
            }
        }
        return Optional.empty();
    }

    public boolean remove(int id) {
        Optional<Customer> optionalCustomer = find(id);
        if(optionalCustomer.isPresent()){
            storage.remove(optionalCustomer.get());
            return true;
        }
        return false;
    }

    public List<Customer> findAll() {
        return new ArrayList<>(storage);
    }

    public void update(Customer customer) {
        for (Customer customerElement : storage) {
            if (customerElement.getId() == customer.getId()){
                customerElement.setName(customer.getName());
                customerElement.setEmail(customer.getEmail());
                customerElement.setReservation(customer.getReservation());
                customerElement.setPhoneNumber(customer.getPhoneNumber());
                break;
            }
        }
    }
}

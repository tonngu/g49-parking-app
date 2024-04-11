package se.lexicon.data.impl;

import se.lexicon.data.CustomerDao;
import se.lexicon.data.sequencer.CustomerSequencer;
import se.lexicon.model.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomerDaoImpl implements CustomerDao {

    private List<Customer> storage = new ArrayList<>();

    @Override
    public Customer create(Customer customer) {
        //todo: Add necessary validations
        if (customer == null) throw new IllegalArgumentException("Customer Data is null.");
        Optional<Customer> customerOptional = find(customer.getId());
        if (customerOptional.isPresent()) throw new IllegalArgumentException("Customer already exists within storage.");
        int id = CustomerSequencer.nextId();
        customer.setId(id);
        storage.add(customer);
        return customer;
    }

    @Override
    public Optional<Customer> find(int id) {
        for (Customer customer : storage) {
            if (customer.getId() == id) {
                return Optional.of(customer);
            }
        }
        return Optional.empty();
    }

    @Override
    public boolean remove(int id) {
        Optional<Customer> customerOptional = find(id);
        if (!customerOptional.isPresent()) return false;
        storage.remove(customerOptional.get());
        return true;
    }

    @Override
    public Optional<Customer> findAll() {
        return new ArrayList<>(storage);
    }
}

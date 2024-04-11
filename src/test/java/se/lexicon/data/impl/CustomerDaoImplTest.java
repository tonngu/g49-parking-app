package se.lexicon.data.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.lexicon.model.Customer;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerDaoImplTest {

    private CustomerDaoImpl testObject;

    @BeforeEach
    public void setUp() {
        testObject = new CustomerDaoImpl();
    }

    @Test
    public void testCreateCustomer() {
        //todo: Implement JUnit test
        Customer customer1 = new Customer("Test1", "12345");
        Customer actualValue = testObject.create(customer1);
        assertNotNull(actualValue);
        assertEquals(customer1, actualValue);
    }

    @Test
    public void findById() {
        //todo: Implement JUnit test
        Customer customer1 = new Customer("Test1", "12345");
        Customer customer2 = new Customer("Test2", "54321");
        testObject.create(customer1);
        testObject.create(customer2);
        assertTrue(testObject.find(1001).isPresent());
        assertTrue(testObject.find(1002).isPresent());
        assertEquals(1001, customer1.getId());
        assertEquals(1002, customer2.getId());
    }

    @Test
    public void testNonExistentCustomer() {
        //todo: Implement JUnit test
        Optional<Customer> foundCustomer = testObject.find(1001);
        assertFalse(foundCustomer.isPresent());
    }

    @Test
    public void testRemoveCustomer() {
        //todo: Implement JUnit test
        Customer customer1 = new Customer("Test1", "12345");
        testObject.create(customer1);
        assertTrue(testObject.find(1001).isPresent());
        assertTrue(testObject.remove(1001)); //customer with id 1001 is removed from storage starting from this line
        assertTrue(testObject.find(1001).isEmpty());
    }

    @Test
    public void testRemoveNonExistentCustomer() {
        //todo: Implement JUnit test
        assertFalse(testObject.remove(1002));
        assertTrue(testObject.find(1002).isEmpty());
    }

    @Test
    public void testFindAllCustomers() {
        //todo: Implement JUnit test
        Customer customer1 = new Customer("Test1", "12345");
        Customer customer2 = new Customer("Test2", "54321");
        testObject.create(customer1);
        testObject.create(customer2);
        ArrayList<Customer> actualValue = testObject.findAll();
        assertEquals(2, actualValue.size());
        assertTrue(actualValue.contains(customer1));
        assertTrue(actualValue.contains(customer2));

    }

    @Test
    public void testFindAllCustomersEmptyList() {
        //todo: Implement JUnit test
        ArrayList<Customer> actualValue = testObject.findAll();
        assertTrue(actualValue.isEmpty());
    }

}

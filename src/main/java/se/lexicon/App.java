package se.lexicon;

import se.lexicon.data.impl.CustomerDaoImpl;
import se.lexicon.data.impl.ParkingSpotDaoImpl;
import se.lexicon.model.Customer;
import se.lexicon.model.ParkingSpot;
import se.lexicon.model.Reservation;
import se.lexicon.model.Vehicle;

import java.util.UUID;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Customer customer1 = new Customer(1,"Test", "123456");
        Vehicle vehicle1 = new Vehicle("ABC123");


        ParkingSpot parkingSpot1 = new ParkingSpot(1, 47001);
        parkingSpot1.occupy();

        System.out.println(parkingSpot1.getDescription());

        ParkingSpotDaoImpl parkingSpotStorage1 = new ParkingSpotDaoImpl();
        parkingSpotStorage1.create(parkingSpot1);
        parkingSpotStorage1.vacateParkingSpot(1);

        System.out.println(parkingSpot1.getDescription());

        Customer customer2 = new Customer("Test2", "222222");
        Customer customer3 = new Customer("Test3", "333333");
        CustomerDaoImpl customerDao1 = new CustomerDaoImpl();




    }
}

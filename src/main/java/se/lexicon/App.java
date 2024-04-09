package se.lexicon;

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
        ParkingSpot parkingSpot2 = new ParkingSpot(2, 47001);


        System.out.println(parkingSpot1);
        System.out.println(parkingSpot2);
        System.out.println(vehicle1.getDescription());
        System.out.println(customer1.getDescription());

        Reservation reservation1 = new Reservation(customer1, parkingSpot1, 4, vehicle1);
        reservation1.setId(UUID.randomUUID().toString());
        reservation1.reserve();

        System.out.println("------------------");
        System.out.println(parkingSpot1);
        System.out.println(parkingSpot2);
        System.out.println(vehicle1.getDescription());
        System.out.println(customer1.getDescription());
        System.out.println(reservation1.getDescription());
        System.out.println("------------------");

        reservation1.cancel();

        System.out.println(parkingSpot1);
        System.out.println(parkingSpot2);
        System.out.println(vehicle1.getDescription());
        System.out.println(customer1.getDescription());
        System.out.println(reservation1.getDescription());

    }
}

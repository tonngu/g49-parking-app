package se.lexicon.data;

import se.lexicon.model.Reservation;

import java.util.Optional;

public interface ReservationDao {
    Reservation create(Reservation reservation);

    Optional<Reservation> find(String id);

    boolean remove(String id);

    Optional<Reservation> findByCustomerId(int customerId);

    Optional<Reservation> findByVehicleLicensePlate(String licensePlate);

    Optional<Reservation> findByParkingSpotNumber(int spotNumber);
}

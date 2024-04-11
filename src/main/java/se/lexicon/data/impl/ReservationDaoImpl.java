package se.lexicon.data.impl;

import se.lexicon.data.ReservationDao;
import se.lexicon.model.Reservation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ReservationDaoImpl implements ReservationDao {

    private List<Reservation> storage = new ArrayList<>();

    @Override
    public Reservation create(Reservation reservation) {
        storage.add(reservation);
        return reservation;
    }

    @Override
    public Optional<Reservation> find(String id) {
        for (Reservation reservation : storage) {
            if (reservation.getId().equals(id)) {
                return Optional.of(reservation);
            }
        }
        return Optional.empty();
    }

    @Override
    public boolean remove(String id) {
        Optional<Reservation> reservationOptional = find(id);
        if (!reservationOptional.isPresent()) return false;
        storage.remove(reservationOptional.get());
        return true;
    }

    @Override
    public Optional<Reservation> findByCustomerId(int customerId) {
        for (Reservation reservation : storage){

        }
    }

    @Override
    public Optional<Reservation> findByVehicleLicensePlate(String licensePlate) {
        return null;
    }

    @Override
    public Optional<Reservation> findByParkingSpotNumber(int spotNumber) {
        return null;
    }
    //todo: Implement necessary methods


}

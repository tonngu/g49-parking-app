package se.lexicon.data.impl;

import se.lexicon.data.ReservationDao;
import se.lexicon.data.sequencer.ReservationSequencer;
import se.lexicon.model.ParkingSpot;
import se.lexicon.model.Reservation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ReservationDaoImpl implements ReservationDao {

    private List<Reservation> storage = new ArrayList<>();

    @Override
    public Reservation create(Reservation reservation) {
        if (reservation == null) throw new IllegalArgumentException("Reservation data is null.");

        Optional<Reservation> reservationOptional = find(reservation.getId());
        if (reservationOptional.isPresent()) throw new IllegalArgumentException("Reservation already exists in the storage.");

        reservationOptional = findByCustomerId(reservation.getCustomer().getId());
        if (reservationOptional.isPresent()) throw new IllegalArgumentException("Reservation already exists in the storage.");

        reservationOptional = findByParkingSpotNumber(reservation.getParkingSpot().getSpotNumber());
        if (reservationOptional.isPresent()) throw new IllegalArgumentException("Reservation already exists in the storage.");

        reservationOptional = findByVehicleLicensePlate(reservation.getAssociatedVehicle().getLicensePlate());
        if (reservationOptional.isPresent()) throw new IllegalArgumentException("Reservation already exists in the storage.");

        Integer id = ReservationSequencer.nextId();
        reservation.setId(id.toString());

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
        for (Reservation reservation : storage) {
            if (reservation.getCustomer().getId() == customerId) {
                return Optional.of(reservation);
            }
        }
        return Optional.empty();
    }

    @Override
    public Optional<Reservation> findByVehicleLicensePlate(String licensePlate) {
        for (Reservation reservation : storage){
            if (reservation.getAssociatedVehicle().getLicensePlate().equals(licensePlate)){
                return Optional.of(reservation);
            }
        }
        return Optional.empty();
    }

    @Override
    public Optional<Reservation> findByParkingSpotNumber(int spotNumber) {
        for (Reservation reservation : storage){
            if (reservation.getParkingSpot().getSpotNumber() == spotNumber){
                return Optional.of(reservation);
            }
        }
        return Optional.empty();
    }



}

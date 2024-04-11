package se.lexicon.data.impl;

import se.lexicon.data.ParkingSpotDao;
import se.lexicon.model.ParkingSpot;
import se.lexicon.model.Vehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ParkingSpotDaoImpl implements ParkingSpotDao {
    //todo: Implement necessary methods

    private List<ParkingSpot> storage = new ArrayList<>();

    @Override
    public ParkingSpot create(ParkingSpot parkingSpot) {
        if (parkingSpot == null) throw new IllegalArgumentException("Parking spot data is null.");
        Optional<ParkingSpot> parkingSpotOptional = find(parkingSpot.getSpotNumber());
        if (parkingSpotOptional.isPresent()) throw new IllegalArgumentException("Parking Spot already exists in the storage.");
        parkingSpotOptional = findByAreaCode(parkingSpot.getAreaCode());
        if (parkingSpotOptional.isPresent()) throw new IllegalArgumentException("Parking Spot already exists in the storage.");
        storage.add(parkingSpot);
        return parkingSpot;
    }

    @Override
    public Optional<ParkingSpot> find(int spotNumber) {
        for (ParkingSpot parkingSpot : storage) {
            if (parkingSpot.getSpotNumber() == spotNumber) {
                return Optional.of(parkingSpot);
            }
        }
        return Optional.empty();
    }

    @Override
    public boolean remove(int spotNumber) {
        Optional<ParkingSpot> parkingSpotOptional = find(spotNumber);
        if (!parkingSpotOptional.isPresent()) return false;
        storage.remove(parkingSpotOptional.get());
        return true;
    }

    @Override
    public List<ParkingSpot> findAll() {
        return new ArrayList<>(storage);
    }

    @Override
    public Optional<ParkingSpot> findByAreaCode(int areaCode) {
        for (ParkingSpot parkingSpot : storage) {
            if (parkingSpot.getAreaCode() == areaCode) {
                return Optional.of(parkingSpot);
            }
        }
        return Optional.empty();
    }

    @Override
    public void occupyParkingSpot(int spotNumber) {
        for (ParkingSpot parkingSpot : storage) {
            if (parkingSpot.getSpotNumber() == spotNumber){
                parkingSpot.occupy();
            }
        }
    }

    @Override
    public void vacateParkingSpot(int spotNumber) {
        for (ParkingSpot parkingSpot : storage) {
            if (parkingSpot.getSpotNumber() == spotNumber){
                parkingSpot.vacate();
            }
        }
    }


}

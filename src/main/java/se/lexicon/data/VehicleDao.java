package se.lexicon.data;

import se.lexicon.model.Vehicle;

import java.util.Collection;
import java.util.Optional;

//DAO Data Access Object
//create, find, update, remove  CRUD Operation
public interface VehicleDao {
    Vehicle create(Vehicle vehicle);

    Optional<Vehicle> find(String licensePlate);

    boolean remove(String licensePlate);

    Collection<Vehicle> findAll();

    void update(Vehicle vehicle);

}

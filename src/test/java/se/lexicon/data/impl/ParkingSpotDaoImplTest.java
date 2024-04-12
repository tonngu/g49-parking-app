package se.lexicon.data.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.lexicon.model.ParkingSpot;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ParkingSpotDaoImplTest {
    private ParkingSpotDaoImpl testObject;

    @BeforeEach
    public void setUp() {
        testObject = new ParkingSpotDaoImpl();
    }

    @Test
    void findByAreaCode() {
        ParkingSpot spot1 = new ParkingSpot(1, 25);
        ParkingSpot spot2 = new ParkingSpot(2, 25);
        testObject.create(spot1);
        testObject.create(spot2);
        List<ParkingSpot> testArea = testObject.findByAreaCode(25);
        assertEquals(2, testArea.size());
        assertTrue(testArea.contains(spot1));
        assertTrue(testArea.contains(spot2));
    }
    //todo: Implement required JUnit tests

}

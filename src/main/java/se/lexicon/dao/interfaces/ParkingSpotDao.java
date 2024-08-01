package se.lexicon.dao.interfaces;

import se.lexicon.model.ParkingSpot;

import java.util.List;
import java.util.Optional;

public interface ParkingSpotDao {
    ParkingSpot create(ParkingSpot parkingSpot);
    Optional<ParkingSpot> find (int id);
    boolean remove(int id);
    List<ParkingSpot> findAll();
    void update(ParkingSpot parkingSpot);
}

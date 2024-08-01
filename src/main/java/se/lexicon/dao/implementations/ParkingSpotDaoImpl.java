package se.lexicon.dao.implementations;

import se.lexicon.dao.interfaces.ParkingSpotDao;
import se.lexicon.model.ParkingSpot;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ParkingSpotDaoImpl implements ParkingSpotDao {
    private List<ParkingSpot> storage = new ArrayList<>();


    @Override
    public ParkingSpot create(ParkingSpot parkingSpot) {
        for (ParkingSpot existingSpot : storage) {
            if (parkingSpot.getSpotNumber() == parkingSpot.getSpotNumber()) {
                throw new IllegalArgumentException("ParkingSpot already exists.");
            }
        }
        storage.add(parkingSpot);
        return parkingSpot;
    }

    @Override
    public Optional<ParkingSpot> find(int id) {
        for (ParkingSpot parkingSpot : storage) {
            if (parkingSpot.getSpotNumber() == id) {
                return Optional.of(parkingSpot);
            }
        }
        return Optional.empty();
    }

    @Override
    public boolean remove(int id) {
        for (ParkingSpot parkingSpot : storage) {
            if (parkingSpot.getSpotNumber() == id) {
                storage.remove(parkingSpot);
                return true;
            }
        }
        return false;
    }

    @Override
    public List<ParkingSpot> findAll() {
        return new ArrayList<>(storage);
    }


    @Override
    public void update(ParkingSpot parkingSpot) {
        for (ParkingSpot parkingSpot1 : storage) {
            if (parkingSpot1.getSpotNumber() == parkingSpot.getSpotNumber()) {
                parkingSpot1.setAreaCode(parkingSpot.getAreaCode());
                parkingSpot1.occupy();
                parkingSpot1.vacate();
                break;
            }
        }
    }
}

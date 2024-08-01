package se.lexicon.dao.implementations;

import se.lexicon.dao.interfaces.ReservationDao;
import se.lexicon.model.Reservation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ReservationImpl implements ReservationDao {
    public List <Reservation> storage = new ArrayList<>();

    @Override
    public Reservation create(Reservation reservation) {
        for (Reservation Reservation : storage) {
            if (Reservation.getId() == reservation.getId()) {
                throw new IllegalArgumentException("Reservation already exists.");
            }
        }
        return null;
    }

    @Override
    public Optional<Reservation> find(int id) {
        for (Reservation reservation : storage) {
            if (reservation.getId()  == reservation.getId()) {
                return Optional.of(reservation);
            }
        }
        return Optional.empty();
    }

    @Override
    public boolean remove(int id) {
        Optional<Reservation> optionalReservation = find(id);
        if(optionalReservation.isPresent()){
            storage.remove(optionalReservation.get());
            return true;
        }
        return false;
    }

    @Override
    public List<Reservation> findAll() {
        return new ArrayList<>(storage);
    }

    @Override
    public void update(Reservation reservation) {
        for (Reservation reservation1 : storage) {
            if (reservation1.getId() == reservation.getId()); {
                reservation1.setStartTime(reservation.getStartTime());
                reservation1.setEndTime(reservation.getEndTime());
                reservation1.setAssociatedVehicle(reservation.getAssociatedVehicle());
                reservation1.setParkingSpot(reservation.getParkingSpot());
            }
        }
    }
}

package se.lexicon.dao.interfaces;

import se.lexicon.model.Reservation;

import java.util.List;
import java.util.Optional;

public interface ReservationDao {
    Reservation create(Reservation reservation);
    Optional<Reservation> find (int id);
    boolean remove(int id);
    List<Reservation> findAll();
    void update(Reservation reservation);
}

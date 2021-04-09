package sn.thies.ut.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.thies.ut.modeles.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Integer>{

}

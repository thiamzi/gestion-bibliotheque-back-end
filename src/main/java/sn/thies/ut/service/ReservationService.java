package sn.thies.ut.service;

import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.thies.ut.modeles.Reservation;
import sn.thies.ut.repository.ReservationRepository;

@Service
public class ReservationService {

	private final ReservationRepository reservationrepository;
	private EntityManager em;
	
	@Autowired
	public ReservationService(ReservationRepository reservationrepository , EntityManager em) {
		this.reservationrepository = reservationrepository;
		this.em = em;
	}
	
	public Reservation addReservation(Reservation reservation) {
		Date date = new Date();
		reservation.setDate(date);
		return this.reservationrepository.save(reservation);
	}
	
	public List<Reservation> getAllReservationReglees(){
		TypedQuery<Reservation> query  = em.createNamedQuery("Reservation.Reglees", Reservation.class);
		List<Reservation> results = query.getResultList();
		return results;
	}
	
	public List<Reservation> getAllReservationEncours(){
		TypedQuery<Reservation> query  = em.createNamedQuery("Reservation.Encours", Reservation.class);
		List<Reservation> results = query.getResultList();
		return results;
	}
	
	public void deleteReservation(Integer id) {
		this.reservationrepository.deleteById(id);
	}
	
	public Reservation findOneReservation(Integer id) {
		return this.reservationrepository.findById(id).get();
	}
	
	/*public Reservation updateReservation(Reservation reservation) {
		return this.reservationrepository.save(reservation);
	}*/
	
	public Reservation reglerReservation(Reservation reservation) {
		reservation.setRegle(true);
		return this.reservationrepository.save(reservation);
	}
	
}

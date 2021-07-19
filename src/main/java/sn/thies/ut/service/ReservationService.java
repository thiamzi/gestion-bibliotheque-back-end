package sn.thies.ut.service;

import java.util.Date;
import java.util.List;

import javax.mail.MessagingException;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import email.EmailModel;
import email.EmailService;
import sn.thies.ut.modeles.Etudiant;
import sn.thies.ut.modeles.Livre;
import sn.thies.ut.modeles.Reservation;
import sn.thies.ut.repository.ReservationRepository;

@Service
public class ReservationService {

	private final ReservationRepository reservationrepository;
	private final LivreService  livreservice;
	private final EmailService emailService;
	private final EtudiantService etudiantservice;
	private EntityManager em;
	
	@Autowired
	public ReservationService(ReservationRepository reservationrepository , LivreService  livreservice,  EmailService emailService ,EtudiantService etudiantservice , EntityManager em) {
		this.reservationrepository = reservationrepository;
		this.livreservice = livreservice;
		this.emailService = emailService;
		this.etudiantservice = etudiantservice;
		this.em = em;
	}
	
	@SuppressWarnings("deprecation")
	public Reservation addReservation(Reservation reservation) {
		Date date = new Date();
		reservation.setDate(date);
		Date dateFin = new Date(date.getYear() , date.getMonth() , date.getDate()+10);;

		reservation.setDateFin(dateFin);
		
		Livre livre =  this.livreservice.findOneLivre(reservation.getLivreIdlivre());
		livre.setNbdisponible(livre.getNbdisponible() - 1);
		
		Etudiant etudiant = this.etudiantservice.findOneEtudiant(reservation.getEtudiantUserIduser());
		
		EmailModel email = new EmailModel(etudiant.getUser().getEmail(),  "Vous venez de faire une réservation du livre << "+ livre.getTitre() +" >> Vous avez 10 jours pour regler la réservation. Au dela du delai la réservation sera systematiquement annulée.", "Reservation livre", null, reservation.getNumeroReservation().toString());
		
		try {
			this.emailService.sendEmailForLivre(email);
		}  catch (MessagingException e) {
			
			e.printStackTrace();
		}
		
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
		
		int idlivre = this.findOneReservation(id).getLivreIdlivre();
		Livre livre =  this.livreservice.findOneLivre(idlivre);
		livre.setNbdisponible(livre.getNbdisponible() + 1);
		
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

package sn.thies.ut.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sn.thies.ut.modeles.Reservation;
import sn.thies.ut.service.ReservationService;

@RestController
@RequestMapping("/api")
public class RservationController {

	private final ReservationService reservationService;

	public RservationController(ReservationService reservationService) {
		super();
		this.reservationService = reservationService;
	}
	
	@GetMapping("/regleesreservations")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<List<Reservation>> getAllRservationsNouvelles(){
		List<Reservation> reservations = reservationService.getAllReservationReglees();
		return new ResponseEntity<List<Reservation>>(reservations , HttpStatus.OK);
	}
	
	@GetMapping("/encoursreservations")
	public ResponseEntity<List<Reservation>> getAllRservationsEnCours(){
		List<Reservation> reservations = reservationService.getAllReservationEncours();
		return new ResponseEntity<List<Reservation>>(reservations , HttpStatus.OK);
	}
	
	
	@GetMapping("/onereservation/{id}")
	public ResponseEntity<Reservation> findOneRservation(@PathVariable Integer id){
		Reservation reservation = reservationService.findOneReservation(id);
		return new ResponseEntity<Reservation>(reservation , HttpStatus.OK);
	}
	
	
	@DeleteMapping("/deletereservation/{id}")
	public ResponseEntity<Reservation> deleteRservation(@PathVariable Integer id){
		reservationService.deleteReservation(id);
		return new ResponseEntity<Reservation>(HttpStatus.OK);
	}
	
	@PostMapping("/addreservation")
	public 	ResponseEntity<Reservation> addRservation(@RequestBody Reservation reservation){
		Reservation newreservation = reservationService.addReservation(reservation);
		return new ResponseEntity<Reservation>(newreservation , HttpStatus.OK);
	}

	@PutMapping("/reglerreservation")
	public 	ResponseEntity<Reservation> ReglerRservation(@RequestBody Reservation reservation){
		Reservation updatereservation = reservationService.reglerReservation(reservation);
		return new ResponseEntity<Reservation>(updatereservation , HttpStatus.OK);
	}
}

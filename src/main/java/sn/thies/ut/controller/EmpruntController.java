package sn.thies.ut.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sn.thies.ut.modeles.Emprunt;
import sn.thies.ut.service.EmpruntService;

@RestController
@RequestMapping("/api")
public class EmpruntController {

	private final EmpruntService empruntService;

	public EmpruntController(EmpruntService empruntService) {
		super();
		this.empruntService = empruntService;
	}

	@GetMapping("/allempruntsregles")
	public ResponseEntity<List<Emprunt>> getAllRegles(){
		List<Emprunt> emprunts = empruntService.getAllEmpruntRegles();
		return new ResponseEntity<List<Emprunt>>(emprunts , HttpStatus.OK);
	}
	
	@GetMapping("/allempruntsnouveaux")
	public ResponseEntity<List<Emprunt>> getAllNouveaux(){
		List<Emprunt> emprunts = empruntService.getAllEmpruntNouveaux();
		return new ResponseEntity<List<Emprunt>>(emprunts , HttpStatus.OK);
	}
	
	@GetMapping("/allempruntsencours")
	public ResponseEntity<List<Emprunt>> getAllEnCours(){
		List<Emprunt> emprunts = empruntService.getAllEmpruntEnCours();
		return new ResponseEntity<List<Emprunt>>(emprunts , HttpStatus.OK);
	}
	
	@GetMapping("/allempruntsenretard")
	public ResponseEntity<List<Emprunt>> getAllEnRetard(){
		List<Emprunt> emprunts = empruntService.getAllEmpruntEnRetard();
		return new ResponseEntity<List<Emprunt>>(emprunts , HttpStatus.OK);
	}
	
	@GetMapping("/oneemprunt/{id}")
	public ResponseEntity<Emprunt> findOnemprunt(@PathVariable Integer id){
		Emprunt emprunt = empruntService.findOneEmprunt(id);
		return new ResponseEntity<Emprunt>(emprunt , HttpStatus.OK);
	}
	
	
	@DeleteMapping("/deleteemprunt/{id}")
	public ResponseEntity<Emprunt> deleterv(@PathVariable Integer id){
		empruntService.deleteEmprunt(id);
		return new ResponseEntity<Emprunt>(HttpStatus.OK);
	}
	
	@PostMapping("/addemprunt")
	public 	ResponseEntity<Emprunt> addrv(@RequestBody Emprunt emprunt){
		Emprunt newemprunt = empruntService.addEmprunt(emprunt);
		return new ResponseEntity<Emprunt>(newemprunt , HttpStatus.OK);
	}

	@PutMapping("/confirmeremprunt")
	public 	ResponseEntity<Emprunt> confirmeremprunt(@RequestBody Emprunt emprunt){	
		Emprunt updateemprunt = empruntService.confirmerEmprunt(emprunt);
		return new ResponseEntity<Emprunt>(updateemprunt , HttpStatus.OK);
	}
	
	@PutMapping("/regleremprunt")
	public 	ResponseEntity<Emprunt> regleremprunt(@RequestBody Emprunt emprunt){	
		Emprunt updateemprunt = empruntService.regleEmprunt(emprunt);
		return new ResponseEntity<Emprunt>(updateemprunt , HttpStatus.OK);
	}
}

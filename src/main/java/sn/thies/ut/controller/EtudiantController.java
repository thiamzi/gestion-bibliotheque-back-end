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
import sn.thies.ut.modeles.Etudiant;
import sn.thies.ut.service.EtudiantService;
import sn.thies.ut.service.UserService;


@RestController
@RequestMapping("/api")
public class EtudiantController {
	
	private final EtudiantService etudiantService;
	private final UserService userService;
	
	public EtudiantController(EtudiantService etudiantService , UserService userService) {
		this.etudiantService = etudiantService;
		this.userService = userService;
		
	}

	@GetMapping("/alletudiants")
	public ResponseEntity<List<Etudiant>> getAlletudiants(){
		List<Etudiant> etudiants = etudiantService.getAllEtudiants();
		return new ResponseEntity<List<Etudiant>>(etudiants , HttpStatus.OK);
	}
	
	@GetMapping("/oneetudiant/{id}")
	public ResponseEntity<Etudiant> findOneetudiant(@PathVariable Integer id){
		Etudiant etudiant = etudiantService.findOneEtudiant(id);
		return new ResponseEntity<Etudiant>(etudiant , HttpStatus.OK);
	}
	
	
	@DeleteMapping("/deleteetudiant/{id}")
	public ResponseEntity<Etudiant> deleteetudiant(@PathVariable Integer id){
		etudiantService.deleteEtudiant(id);
		userService.deleteUser(id);
		return new ResponseEntity<Etudiant>(HttpStatus.OK);
	}
	
	@PostMapping("/addetudiant")
	public 	ResponseEntity<Etudiant> addetudiant(@RequestBody Etudiant etudiant){
		Etudiant newetudiant = etudiantService.addEtudiant(etudiant);
		return new ResponseEntity<Etudiant>(newetudiant , HttpStatus.OK);
	}

	@PutMapping("/updateetudiant")
	public 	ResponseEntity<Etudiant> updateetudiant(@RequestBody Etudiant etudiant){
		Etudiant updateetudiant = etudiantService.updateEtudiant(etudiant);
		return new ResponseEntity<Etudiant>(updateetudiant , HttpStatus.OK);
	}

}

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


@RestController
@RequestMapping("/api")
public class EtudiantController {
	
	private final EtudiantService etudiantService;
	

	public EtudiantController(EtudiantService etudiantService) {
		this.etudiantService = etudiantService;
	}

	@GetMapping("/alletudiantstrue")
	public ResponseEntity<List<Etudiant>> getAlletudiantsTrue(){
		List<Etudiant> etudiants = etudiantService.getAllEtudiantTrue();
		return new ResponseEntity<List<Etudiant>>(etudiants , HttpStatus.OK);
	}
	
	@GetMapping("/alletudiantsfalse")
	public ResponseEntity<List<Etudiant>> getAlletudiantsFalse(){
		List<Etudiant> etudiants = etudiantService.getAllEtudiantFalse();
		return new ResponseEntity<List<Etudiant>>(etudiants , HttpStatus.OK);
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

	@PutMapping("/validateetudiant")
	public 	ResponseEntity<Etudiant> validateetudiant(@RequestBody Etudiant etudiant){
		Etudiant valideetudiant = etudiantService.validerEtudiant(etudiant);
		return new ResponseEntity<Etudiant>(valideetudiant , HttpStatus.OK);
	}
}

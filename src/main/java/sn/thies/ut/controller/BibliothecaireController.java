package sn.thies.ut.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sn.thies.ut.modeles.Bibliothecaire;
import sn.thies.ut.service.BibliothecaireService;

@RestController
@RequestMapping("/api")
public class BibliothecaireController {

	private final BibliothecaireService biblioService;

	public BibliothecaireController(BibliothecaireService biblioService) {
		super();
		this.biblioService = biblioService;
	}
	
	
	@GetMapping("/onebiblio/{id}")
	public ResponseEntity<Bibliothecaire> findOnebiblio(@PathVariable Integer id){
		Bibliothecaire biblio = biblioService.findOneBibliothecaire(id);
		return new ResponseEntity<Bibliothecaire>(biblio , HttpStatus.OK);
	}
	
	@PutMapping("/updatebiblio")
	public 	ResponseEntity<Bibliothecaire> updatebiblio(@RequestBody Bibliothecaire biblio){
		Bibliothecaire updatebiblio = biblioService.UpdateBibliothecaire(biblio);
		return new ResponseEntity<Bibliothecaire>(updatebiblio , HttpStatus.OK);
	}
	
	@PostMapping("/addbiblio")
	public 	ResponseEntity<Bibliothecaire> addbiblio(@RequestBody Bibliothecaire biblio){
		Bibliothecaire newbiblio = biblioService.AddBibliothecaire(biblio);
		return new ResponseEntity<Bibliothecaire>(newbiblio , HttpStatus.OK);
	}
}

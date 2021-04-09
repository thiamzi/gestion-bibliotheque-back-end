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
import sn.thies.ut.modeles.Categorie;
import sn.thies.ut.service.CategorieService;

@RestController
@RequestMapping("/api")
public class CategorieController {

	private final CategorieService categorieservice;

	public CategorieController(CategorieService categorieservice) {
		super();
		this.categorieservice = categorieservice;
	}
	
	@GetMapping("/allcategories")
	public ResponseEntity<List<Categorie>> getAllrvs(){
		List<Categorie> categories = categorieservice.getAllCategorie();
		return new ResponseEntity<List<Categorie>>(categories , HttpStatus.OK);
	}
	
	@GetMapping("/onecategorie/{id}")
	public ResponseEntity<Categorie> findOnerv(@PathVariable Integer id){
		Categorie etudiant = categorieservice.findOneCategorie(id);
		return new ResponseEntity<Categorie>(etudiant , HttpStatus.OK);
	}
	
	
	@DeleteMapping("/deletecategorie/{id}")
	public ResponseEntity<Categorie> deleterv(@PathVariable Integer id){
		categorieservice.deleteCategorie(id);
		return new ResponseEntity<Categorie>(HttpStatus.OK);
	}
	
	@PostMapping("/addcategorie")
	public 	ResponseEntity<Categorie> addrv(@RequestBody Categorie categorie){
		Categorie newcategorie = categorieservice.addCategorie(categorie);
		return new ResponseEntity<Categorie>(newcategorie , HttpStatus.OK);
	}

	@PutMapping("/updatecategorie")
	public 	ResponseEntity<Categorie> updaterv(@RequestBody Categorie categorie){
		Categorie updatecategorie = categorieservice.updateCategorie(categorie);
		return new ResponseEntity<Categorie>(updatecategorie , HttpStatus.OK);
	}

}

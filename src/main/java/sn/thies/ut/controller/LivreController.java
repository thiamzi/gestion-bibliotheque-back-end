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
import sn.thies.ut.modeles.Livre;
import sn.thies.ut.service.LivreService;

@RestController
@RequestMapping("/api")
public class LivreController {

	private final LivreService livreService;

	public LivreController(LivreService livreService) {
		super();
		this.livreService = livreService;
	}
	
	@GetMapping("/alllivres")
	public ResponseEntity<List<Livre>> getAlllivres(){
		List<Livre> livres = livreService.getAllLivres();
		return new ResponseEntity<List<Livre>>(livres , HttpStatus.OK);
	}
	
	@GetMapping("/onelivre/{id}")
	public ResponseEntity<Livre> findOnerv(@PathVariable Integer id){
		Livre livre = livreService.findOneLivre(id);
		return new ResponseEntity<Livre>(livre , HttpStatus.OK);
	}
	
	
	@DeleteMapping("/deletelivre/{id}")
	public ResponseEntity<Livre> deleterv(@PathVariable Integer id){
		livreService.deleteLivre(id);
		return new ResponseEntity<Livre>(HttpStatus.OK);
	}
	
	@PostMapping("/addlivre")
	public 	ResponseEntity<Livre> addrv(@RequestBody Livre livre){
		Livre newlivre = livreService.addLivre(livre);
		return new ResponseEntity<Livre>(newlivre , HttpStatus.OK);
	}

	@PutMapping("/updatelivre")
	public 	ResponseEntity<Livre> updaterv(@RequestBody Livre livre){
		Livre updatelivre = livreService.updateLivre(livre);
		return new ResponseEntity<Livre>(updatelivre , HttpStatus.OK);
	}
	

}

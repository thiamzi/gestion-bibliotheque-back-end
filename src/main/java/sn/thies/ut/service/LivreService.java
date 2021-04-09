package sn.thies.ut.service;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sn.thies.ut.modeles.Livre;
import sn.thies.ut.repository.LivreRepository;

@Service
public class LivreService {

	private final LivreRepository livrerepository;
	private EntityManager em;
	@Autowired
	public LivreService(LivreRepository livrerepository , EntityManager em) {
		this.livrerepository = livrerepository;
		this.em = em;
	}
	
	public Livre addLivre(Livre livre) {
		Date date = new Date();
		livre.setDateCreation(date);
		return this.livrerepository.save(livre);
	}
	
	public List<Livre> getAllLivres(){
		TypedQuery<Livre> query  = em.createNamedQuery("Livre.findAll", Livre.class);
		List<Livre> results = query.getResultList();
		return results;
	}
	
	public void deleteLivre(Integer id) {
		this.livrerepository.deleteById(id);
	}
	
	public Livre findOneLivre(Integer id) {
		return this.livrerepository.findById(id).get();
	}
	
	public Livre updateLivre(Livre livre) {
		return this.livrerepository.save(livre);
		
	}
	
}

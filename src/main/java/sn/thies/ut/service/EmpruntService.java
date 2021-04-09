package sn.thies.ut.service;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.thies.ut.modeles.Emprunt;
import sn.thies.ut.repository.EmpruntRepository;

@Service
public class EmpruntService {

	private final EmpruntRepository empruntrepository;
	private EntityManager em;
	
	@Autowired
	public EmpruntService(EmpruntRepository empruntrepository , EntityManager em) {
		this.empruntrepository = empruntrepository;
		this.em = em;
	}
	
	public Emprunt addEmprunt(Emprunt emprunt) {
		Date date = new Date();
		emprunt.setDateDebut(date);
		return this.empruntrepository.save(emprunt);
	}
	
	public List<Emprunt> getAllEmpruntEnRetard(){
		TypedQuery<Emprunt> query  = em.createNamedQuery("Emprunt.EnRetard", Emprunt.class).setParameter("now", new Date());
		List<Emprunt> results = query.getResultList();
		return results;
	}
	
	public List<Emprunt> getAllEmpruntEnCours(){
		TypedQuery<Emprunt> query  = em.createNamedQuery("Emprunt.EnCours", Emprunt.class);
		List<Emprunt> results = query.getResultList();
		return results;
	} 
	
	public List<Emprunt> getAllEmpruntRegles(){
		TypedQuery<Emprunt> query  = em.createNamedQuery("Emprunt.Regles", Emprunt.class);
		List<Emprunt> results = query.getResultList();
		return results;
	}
	
	public List<Emprunt> getAllEmpruntNouveaux(){
		TypedQuery<Emprunt> query  = em.createNamedQuery("Emprunt.Nouveaux", Emprunt.class);
		List<Emprunt> results = query.getResultList();
		return results;
	}
	public void deleteEmprunt(Integer id) {
		this.empruntrepository.deleteById(id);
	}
	
	public Emprunt findOneEmprunt(Integer id) {
		return this.empruntrepository.findById(id).get();
	}
	
	/*public Emprunt updateEmprunt(Emprunt emprunt) {
		return this.empruntrepository.save(emprunt);
		
	}
	*/
	public Emprunt confirmerEmprunt(Emprunt emprunt) {
		emprunt.setConfirmer(true);
		return this.empruntrepository.save(emprunt);
	}
	
	public Emprunt regleEmprunt(Emprunt emprunt) {
		Date date = new Date();
		emprunt.setDateremise(date);
		emprunt.setRegle(true);
		return this.empruntrepository.save(emprunt);
	}
}

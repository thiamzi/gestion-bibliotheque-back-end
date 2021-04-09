package sn.thies.ut.service;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.thies.ut.modeles.Etudiant;
import sn.thies.ut.repository.EtudiantRepository;

@Service
public class EtudiantService {

	private final EtudiantRepository etudiantrepository;
	private EntityManager em;
	
	@Autowired
	public EtudiantService(EtudiantRepository etudiantrepository , EntityManager em) {
		this.etudiantrepository = etudiantrepository;
		this.em = em;
	}
	
	public Etudiant addEtudiant(Etudiant etudiant) {
		Date date = new Date();
		etudiant.setDateCreation(date);
		etudiant.setValide(false);
		return this.etudiantrepository.save(etudiant);
	}
	
	public Etudiant validerEtudiant(Etudiant etudiant) {
		etudiant.setValide(true);
		return this.etudiantrepository.save(etudiant);
	}
	
	public List<Etudiant> getAllEtudiantTrue(){
		TypedQuery<Etudiant> query  = em.createNamedQuery("Etudiant.findAllTrue", Etudiant.class);
		List<Etudiant> results = query.getResultList();
		return results;
	}
	
	public List<Etudiant> getAllEtudiantFalse(){
		TypedQuery<Etudiant> query  = em.createNamedQuery("Etudiant.findAllFalse", Etudiant.class);
		List<Etudiant> results = query.getResultList();
		return results;
	}
	

	public List<Etudiant> getAllEtudiants(){
		return this.etudiantrepository.findAll();
	}
	
	public void deleteEtudiant(Integer id) {
		this.etudiantrepository.deleteById(id);
	}
	
	public Etudiant findOneEtudiant(Integer id) {
		return this.etudiantrepository.findById(id).get();
	}
	
	public Etudiant updateEtudiant(Etudiant etudiant) {
		return this.etudiantrepository.save(etudiant);	
	}
	
}

package sn.thies.ut.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.thies.ut.modeles.Etudiant;
import sn.thies.ut.repository.EtudiantRepository;

@Service
public class EtudiantService {

	private final EtudiantRepository etudiantrepository;
	
	@Autowired
	public EtudiantService(EtudiantRepository etudiantrepository) {
		this.etudiantrepository = etudiantrepository;
	}
	
	public Etudiant addEtudiant(Etudiant etudiant) {
		Date date = new Date();
		etudiant.setDateCreation(date);
		return this.etudiantrepository.save(etudiant);
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

package sn.thies.ut.service;

import java.util.Date;
import java.util.List;

import javax.mail.MessagingException;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import email.EmailModel;
import email.EmailService;
import io.jsonwebtoken.io.IOException;
import sn.thies.ut.modeles.Emprunt;
import sn.thies.ut.modeles.Etudiant;
import sn.thies.ut.modeles.Livre;
import sn.thies.ut.repository.EmpruntRepository;
import sn.thies.ut.repository.EtudiantRepository;
import sn.thies.ut.repository.LivreRepository;

@Service
public class EmpruntService {

	private final EmpruntRepository empruntrepository;
	private final LivreService  livreservice;
	private final EmailService emailService;
	private final EtudiantService etudiantservice;
	private EntityManager em;
	
	@Autowired
	public EmpruntService(EmpruntRepository empruntrepository , LivreService  livreservice,  EmailService emailService ,EtudiantService etudiantservice,EntityManager em) {
		this.empruntrepository = empruntrepository;
		this.livreservice = livreservice;
		this.emailService = emailService;
		this.etudiantservice = etudiantservice;
		
		this.em = em;
	}
	

	public Emprunt addEmprunt(Emprunt emprunt) {
		Date date = new Date();
		Date dateRecup = date;
		dateRecup.setDate(date.getDate() + 3);
		Date dateFin = date;
		dateFin.setMonth(date.getMonth() +1);
		emprunt.setDateFin(dateFin);
		emprunt.setDelai_recup(dateRecup);
		emprunt.setDateDebut(date);
		
		Livre livre =  this.livreservice.findOneLivre(emprunt.getLivreIdlivre());
		livre.setNbdisponible(livre.getNbdisponible() - 1);
		
		Etudiant etudiant = this.etudiantservice.findOneEtudiant(emprunt.getEtudiantUserIduser());
		
		EmailModel email = new EmailModel(etudiant.getUser().getEmail(), "Vous venez de faire un emprunt du livre << "+ livre.getTitre() +" >> Vous avez 3 jours pour venir recuperer le livre pour que l'emprunt soit confirmer. Au dela du delai l'emprunt sera systematiquement annulé.", "Emprunt livre", null, emprunt.getNumeroEmprunt().toString());
		
		try {
			this.emailService.sendEmailForLivre(email);
		}  catch (MessagingException e) {
			
			e.printStackTrace();
		}
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

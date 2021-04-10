package sn.thies.ut.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.thies.ut.modeles.Bibliothecaire;
import sn.thies.ut.repository.BibliothecaireRepository;

@Service
public class BibliothecaireService {
	
	public final BibliothecaireRepository bibliothecairerepository;
	
	@Autowired
	public BibliothecaireService(BibliothecaireRepository bibliothecairerepository) {
		super();
		this.bibliothecairerepository = bibliothecairerepository;
	}

	public Bibliothecaire findOneBibliothecaire(Integer id) {
		return this.bibliothecairerepository.findById(id).get();
	}
	
	public Bibliothecaire UpdateBibliothecaire(Bibliothecaire biblio) {
		return this.bibliothecairerepository.save(biblio);
	}
	
	public Bibliothecaire AddBibliothecaire(Bibliothecaire biblio) {
		return this.bibliothecairerepository.save(biblio);
	}
}

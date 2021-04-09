package sn.thies.ut.service;

import java.util.List;

import org.hibernate.annotations.OrderBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.thies.ut.modeles.Categorie;
import sn.thies.ut.repository.CategorieRepository;


@Service
public class CategorieService {

	public final CategorieRepository categorierepository;

	@Autowired
	public CategorieService(CategorieRepository categorierepository) {
		super();
		this.categorierepository = categorierepository;
	}
	
	public Categorie addCategorie(Categorie categorie) {
		return this.categorierepository.save(categorie);
	}
	
	@OrderBy(clause = "nom , ASC")
	public List<Categorie> getAllCategorie(){
		return this.categorierepository.findAll();
	}
	
	public void deleteCategorie(Integer id) {
		this.categorierepository.deleteById(id);
	}
	
	public Categorie findOneCategorie(Integer id) {
		return this.categorierepository.findById(id).get();
	}
	
	public Categorie updateCategorie(Categorie categorie) {
		return this.categorierepository.save(categorie);	
	}
	
}

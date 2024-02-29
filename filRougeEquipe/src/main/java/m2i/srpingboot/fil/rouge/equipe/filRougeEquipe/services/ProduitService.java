package m2i.srpingboot.fil.rouge.equipe.filRougeEquipe.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import m2i.srpingboot.fil.rouge.equipe.filRougeEquipe.entities.Produit;
import m2i.srpingboot.fil.rouge.equipe.filRougeEquipe.repositories.ProduitRepository;


@Service
public class ProduitService {
	
	@Autowired private ProduitRepository pRepo;
	
	public Iterable<Produit> selectAll(){
		return pRepo.findAll();
	}
	
	

	public List<Produit> selectAllByRestaurant(int idRestaurant){
		return pRepo.findByRestaurantId(idRestaurant);
	}
	
	
	public Produit selectById(int id) {
		return pRepo.findById(id).get();
	}
	
	public void save(Produit produit) {
		pRepo.save(produit);
	}
	
	public void delete(int id) {
		pRepo.deleteById(id);
	}

	public void saveAll(Iterable<Produit> produits) {
		pRepo.saveAll(produits);
		
	}
}

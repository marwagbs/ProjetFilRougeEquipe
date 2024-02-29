package m2i.srpingboot.fil.rouge.equipe.filrougeequipe.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import m2i.srpingboot.fil.rouge.equipe.filrougeequipe.entities.Produit;
import m2i.srpingboot.fil.rouge.equipe.filrougeequipe.repositories.ProduitRepository;


@Service
public class ProduitService {
	
 private final ProduitRepository pRepo;
	@Autowired
   public ProduitService( ProduitRepository pRepo) {
	this.pRepo = pRepo;
		
	}
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

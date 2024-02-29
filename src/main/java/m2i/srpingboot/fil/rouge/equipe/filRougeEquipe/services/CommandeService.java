package m2i.srpingboot.fil.rouge.equipe.filRougeEquipe.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import m2i.srpingboot.fil.rouge.equipe.filRougeEquipe.entities.Commande;
import m2i.srpingboot.fil.rouge.equipe.filRougeEquipe.entities.Produit;
import m2i.srpingboot.fil.rouge.equipe.filRougeEquipe.entities.Restaurant;
import m2i.srpingboot.fil.rouge.equipe.filRougeEquipe.entities.TableRes;
import m2i.srpingboot.fil.rouge.equipe.filRougeEquipe.repositories.CommandeRepository;
import m2i.srpingboot.fil.rouge.equipe.filRougeEquipe.repositories.ProduitRepository;
import m2i.srpingboot.fil.rouge.equipe.filRougeEquipe.repositories.TableResRepository;

@Service
public class CommandeService {
	
	@Autowired private CommandeRepository repo;
	@Autowired private ProduitRepository prepo;
	@Autowired private TableResRepository trepo;
	
	public Iterable<Commande> selectAll(){
		return repo.findAll();
	}
	
	public Commande selectById(int id) {
		return repo.findById(id).get();
	}
	
	public Commande save(Commande commande) {
		return repo.save(commande);
	}
	
	public void modifierStatut(int id, String statut) {
		Commande commande=repo.findById(id).get();
		commande.setStatut(statut);
		repo.save(commande);
	}
	public void modifierStatutPrete(int id) {
		Commande commande=repo.findById(id).get();
		commande.setStatut("prête");
		repo.save(commande);
	}
	public void modifierStatutServie(int id) {
		Commande commande=repo.findById(id).get();
		commande.setStatut("servie");
		repo.save(commande);
	}
	
	public void modifierStatutReglee(int id) {
		Commande commande=repo.findById(id).get();
		commande.setStatut("reglée");
		repo.save(commande);
	}
	public void delete(int id) {
		repo.deleteById(id);
	}

	public void saveAll(Iterable<Commande> commandes) {
		repo.saveAll(commandes);
		
	}
		

	
	  public Commande findByTableRes(TableRes tableRes){
		  return repo.findByTableRes(tableRes);
	  }
	  
	  public Float calculerMontantTotalParTable(TableRes tableRes) {
		return repo.calculerMontantTotalParTable(tableRes);
		  
	  }
	
	public Commande effectuerCommande(List<Integer> idProduits, int idTable) {
		Iterable<Produit> produits=prepo.findAllById(idProduits);
		Commande nouvelleCommande= new Commande();
		nouvelleCommande.setHeure(LocalDateTime.now()); 
		nouvelleCommande.setStatut("En attente");
		TableRes tableRes = trepo.findById(idTable).get();
        nouvelleCommande.setTableRes(tableRes);
	
		nouvelleCommande.setProduits((List<Produit>) produits);
		return repo.save(nouvelleCommande);
	}
	
	public List<Commande> findByTableResRestaurant(Restaurant restaurant){
		return repo.findByTableRes_Restaurant(restaurant);
	}
}

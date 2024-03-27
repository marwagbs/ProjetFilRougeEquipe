package m2i.srpingboot.fil.rouge.equipe.filrougeequipe.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import m2i.srpingboot.fil.rouge.equipe.filrougeequipe.entities.Commande;
import m2i.srpingboot.fil.rouge.equipe.filrougeequipe.entities.Produit;
import m2i.srpingboot.fil.rouge.equipe.filrougeequipe.entities.Restaurant;
import m2i.srpingboot.fil.rouge.equipe.filrougeequipe.entities.TableRes;
import m2i.srpingboot.fil.rouge.equipe.filrougeequipe.repositories.CommandeRepository;
import m2i.srpingboot.fil.rouge.equipe.filrougeequipe.repositories.ProduitRepository;
import m2i.srpingboot.fil.rouge.equipe.filrougeequipe.repositories.TableResRepository;

@Service
public class CommandeService {
	
	 private final CommandeRepository repo;
	 private final ProduitRepository prepo;
	 private final TableResRepository trepo;
	
	 @Autowired
	public CommandeService(CommandeRepository repo, ProduitRepository prepo, TableResRepository trepo) {
		this.repo = repo;
		this.prepo = prepo;
		this.trepo = trepo;
		
	}
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
	
	public Commande effectuerCommande (int idTable) {
	
		Commande nouvelleCommande= new Commande();
		nouvelleCommande.setHeure(LocalDateTime.now()); 
		nouvelleCommande.setStatut("En attente");
		TableRes tableRes = trepo.findById(idTable).get();
		System.out.println(tableRes.getId());
		System.out.println(tableRes.getNombrePlaces());
		System.out.println(tableRes.getNumeroTable());
        
        if(tableRes!=null) {
        	nouvelleCommande.setTableRes(tableRes);
        }
		return repo.save(nouvelleCommande);
	}
	
	
	
	public List<Commande> findByTableResRestaurant(Restaurant restaurant){
		return repo.findByTableRes_Restaurant(restaurant);
	}
	
	
	public List<Commande> trouverCommandesParStatut(String statut) {
        return repo.findByStatut(statut);
    }
}

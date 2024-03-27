package m2i.srpingboot.fil.rouge.equipe.filrougeequipe.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import m2i.srpingboot.fil.rouge.equipe.filrougeequipe.entities.Commande;
import m2i.srpingboot.fil.rouge.equipe.filrougeequipe.entities.Restaurant;
import m2i.srpingboot.fil.rouge.equipe.filrougeequipe.entities.TableRes;


public interface CommandeRepository extends CrudRepository<Commande, Integer>{

  
    	
    public Commande findByTableRes(TableRes tableRes); 

	
    @Query("SELECT SUM(p.prix) FROM Commande c JOIN c.produits p WHERE c.tableRes = :tableRes")
    Float calculerMontantTotalParTable(TableRes tableRes);
    
    
    List<Commande> findByTableRes_Restaurant(Restaurant restaurant);
    
    @Query("SELECT c FROM Commande c WHERE c.statut = :statut")
    List<Commande> findByStatut(String statut);
}

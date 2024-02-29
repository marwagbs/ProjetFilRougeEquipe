package m2i.srpingboot.fil.rouge.equipe.filRougeEquipe.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import m2i.srpingboot.fil.rouge.equipe.filRougeEquipe.entities.Commande;
import m2i.srpingboot.fil.rouge.equipe.filRougeEquipe.entities.Restaurant;
import m2i.srpingboot.fil.rouge.equipe.filRougeEquipe.entities.TableRes;


public interface CommandeRepository extends CrudRepository<Commande, Integer>{

  
    	
    public Commande findByTableRes(TableRes tableRes); 

	
    @Query("SELECT SUM(p.prix) FROM Commande c JOIN c.produits p WHERE c.tableRes = :tableRes")
    Float calculerMontantTotalParTable(TableRes tableRes);
    
    
    List<Commande> findByTableRes_Restaurant(Restaurant restaurant);
}

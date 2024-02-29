package m2i.srpingboot.fil.rouge.equipe.filRougeEquipe.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import m2i.srpingboot.fil.rouge.equipe.filRougeEquipe.entities.Produit;

public interface ProduitRepository extends CrudRepository<Produit, Integer>{

	
	
	 
    @Query("SELECT p FROM Produit p JOIN p.cartes c JOIN c.restaurants r WHERE r.id = :restaurantId")
    List<Produit> findByRestaurantId(@Param("restaurantId") int restaurantId);


	
	
}

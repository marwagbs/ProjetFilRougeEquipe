package m2i.srpingboot.fil.rouge.equipe.filrougeequipe.repositories;

import java.util.List;


import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.CrudRepository;

import m2i.srpingboot.fil.rouge.equipe.filrougeequipe.entities.TableRes;

public interface TableResRepository extends CrudRepository<TableRes, Integer>{


	
/*****Requete pour afficher toutes les tables avec statut libre ou occupée et mentions de reservation pour aujourd'hui*****/
	
@Query(value="SELECT "
		+ "    tr.nombre_places,"
		+ "    tr.numero_table,"
		+ "    tr.statut,"
		+ "    tr.id_restaurant,"
		+ "    r.date_res,"
		+ "    r.heure,"
		+ "    tr.id ,"
		+ "    r.nb_personne,"
		+ "	u.nom,"
		+ "	u.prenom,"
		+ "	  r.commentaire "
		+ "FROM  "
		+ "    tableres AS tr "
		+ "LEFT JOIN "
		+ "    reservations AS r ON tr.id_restaurant = r.id_restaurant "
		+ "AND tr.id = r.id_table "
		+ "AND CAST(r.date_res AS DATE) = CAST(GETDATE() AS DATE) "
		+ "LEFT JOIN "
		+ " utilisateurs AS u ON  r.id_utilisateur = u.id "
		+ "  where   tr.id_restaurant = :id ", nativeQuery = true)
	List<TableRes>afficherTablesRestau(int id);
		
	


// Madina ?? 
	List<TableRes> findByRestaurantId(int id);

}

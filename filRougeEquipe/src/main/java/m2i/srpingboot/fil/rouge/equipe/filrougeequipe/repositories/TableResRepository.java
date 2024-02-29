package m2i.srpingboot.fil.rouge.equipe.filrougeequipe.repositories;

import java.util.List;


import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.CrudRepository;

import m2i.srpingboot.fil.rouge.equipe.filrougeequipe.entities.TableRes;

public interface TableResRepository extends CrudRepository<TableRes, Integer>{


	
/*****Requete pour afficher toutes les tables avec statut libre ou occupée et mentions de reservation pour aujourd'hui*****/
	
@Query(value="SELECT \r\n"
		+ "    tr.nombre_places,\r\n"
		+ "    tr.numero_table,\r\n"
		+ "    tr.statut,\r\n"
		+ "    tr.id_restaurant,\r\n"
		+ "    r.date_res,\r\n"
		+ "    r.heure,\r\n"
		+ "    tr.id ,\r\n"
		+ "    r.nb_personne,\r\n"
		+ "	u.nom,\r\n"
		+ "	u.prenom,\r\n"
		+ "	  r.commentaire\r\n"
		+ "FROM \r\n"
		+ "    tableres AS tr\r\n"
		+ "	\r\n"
		+ "LEFT JOIN \r\n"
		+ "    reservations AS r ON tr.id_restaurant = r.id_restaurant "
		+ "AND tr.id = r.id_table "
		+ "AND CAST(r.date_res AS DATE) = CAST(GETDATE() AS DATE)\r\n\r\n"
		+ "LEFT JOIN \r\n"
		+ " utilisateurs AS u ON  r.id_utilisateur = u.id\r\n"
		+ "  where   tr.id_restaurant = :id\r\n"
		+ ";\r\n"
		+ "\r\n", nativeQuery = true)
	List<TableRes>afficherTablesRestau(int id);
		
	


// Madina ?? 
	List<TableRes> findByRestaurantId(int id);

}

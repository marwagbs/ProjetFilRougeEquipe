SELECT 
    tr.nombre_places,
    tr.numero_table,
    tr.statut as table_statut,
    tr.id_restaurant,
    r.date_res,
    r.heure,
    r.id as id_reservation,
    r.nb_personne,
	u.nom,
	u.prenom,
	  r.commentaire,
    r.statut AS reservation_statut 
FROM 
    tableres AS tr
	
LEFT JOIN 
    reservations AS r ON tr.id_restaurant = r.id_restaurant AND tr.id = r.id_table
LEFT JOIN 
 utilisateurs AS u ON  r.id_utilisateur = u.id
  where   tr.id_restaurant = :id
;


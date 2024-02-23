package m2i.srpingboot.fil.rouge.equipe.filRougeEquipe.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import m2i.srpingboot.fil.rouge.equipe.filRougeEquipe.entities.Reservation;

public interface ReservationRepository extends CrudRepository<Reservation, Integer> {
	List<Reservation> findByRestaurantNom(String nom);
}

package m2i.srpingboot.fil.rouge.equipe.filRougeEquipe.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import m2i.srpingboot.fil.rouge.equipe.filRougeEquipe.entities.Reservation;

public interface ReservationRepository extends CrudRepository<Reservation, Integer> {
	List<Reservation> findByRestaurantId(int restaurantId);
	List<Reservation> findByStatutAndId(String statut, int id);
	List<Reservation> findAllByStatutIn(List<String> list);
	List<Reservation> findAllByStatutInAndId(List<String> of, int id);
}

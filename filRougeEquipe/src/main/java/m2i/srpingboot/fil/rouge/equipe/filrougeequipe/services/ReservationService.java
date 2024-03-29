package m2i.srpingboot.fil.rouge.equipe.filrougeequipe.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import m2i.srpingboot.fil.rouge.equipe.filrougeequipe.entities.Reservation;
import m2i.srpingboot.fil.rouge.equipe.filrougeequipe.entities.TableRes;
import m2i.srpingboot.fil.rouge.equipe.filrougeequipe.repositories.ReservationRepository;
import m2i.srpingboot.fil.rouge.equipe.filrougeequipe.repositories.TableResRepository;

@Service
public class ReservationService {
	
	private final  ReservationRepository reservationRepo;
	
	private final TableResRepository tabResRepo;
	
	@Autowired
	public ReservationService(ReservationRepository reservationRepo,TableResRepository tabResRepo) {
		this.reservationRepo = reservationRepo;
		this.tabResRepo = tabResRepo;
		
	}
	
	public Iterable<Reservation> getAll() { return reservationRepo.findAll(); }
	public Reservation getById(int id) { return reservationRepo.findById(id).get(); }
	public void save(Reservation reservation) { reservationRepo.save(reservation); }
	public void delete(int id) { reservationRepo.deleteById(id); }
	public List<Reservation> findByRestaurantId(int restaurantId) {
		return reservationRepo.findByRestaurantId(restaurantId);
	}
	public List<TableRes> getFilteredTableRes(int reservationId) {
		Reservation reservation = reservationRepo.findById(reservationId).get();
		List<TableRes> allTableRes = tabResRepo.findByRestaurantId(reservation.getRestaurant().getId());
		List<TableRes> filteredTableRes = allTableRes.stream()
				.filter(tabResRepo -> tabResRepo.getNombrePlaces() >= reservation.getNbPersonne())
				.collect(Collectors.toList());
		return filteredTableRes;
	}
	
	public List<Reservation> findByStatutAndId(String statut, int id) {
		return reservationRepo.findByStatutAndId(statut, id);
	}
	
	public List<Reservation> findAllByStatutIn(List<String> list) {
		return reservationRepo.findAllByStatutIn(list);
	}
	
	public List<Reservation> getReservationsByStatut(String statut1, String statut2) {
		return reservationRepo.findAllByStatutIn(List.of(statut1, statut2));
	}
	
	public List<Reservation> getReservationsByStatutAndId(String statut1, String statut2, int id) {
		return reservationRepo.findAllByStatutInAndId(List.of(statut1, statut2), id);
	}
	
	
}

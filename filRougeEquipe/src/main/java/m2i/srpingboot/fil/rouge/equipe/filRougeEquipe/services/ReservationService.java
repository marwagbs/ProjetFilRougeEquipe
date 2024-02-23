package m2i.srpingboot.fil.rouge.equipe.filRougeEquipe.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import m2i.srpingboot.fil.rouge.equipe.filRougeEquipe.entities.Reservation;
import m2i.srpingboot.fil.rouge.equipe.filRougeEquipe.entities.TableRes;
import m2i.srpingboot.fil.rouge.equipe.filRougeEquipe.repositories.ReservationRepository;
import m2i.srpingboot.fil.rouge.equipe.filRougeEquipe.repositories.TableResRepository;

@Service
public class ReservationService {
	@Autowired
	private ReservationRepository reservationRepo;
	@Autowired
	private TableResRepository tabResRepo;
	
	public Iterable<Reservation> getAll() { return reservationRepo.findAll(); }
	public Reservation getById(int id) { return reservationRepo.findById(id).get(); }
	public void save(Reservation reservation) { reservationRepo.save(reservation); }
	public void delete(int id) { reservationRepo.deleteById(id); }
	public List<Reservation> findByRestaurantNom(String nom) {
		return reservationRepo.findByRestaurantNom(nom);
	}
	public List<TableRes> getFilteredTableRes(int reservationId) {
		Reservation reservation = reservationRepo.findById(reservationId).get();
		List<TableRes> allTableRes = tabResRepo.findByRestaurantId(reservation.getRestaurant().getId());
		List<TableRes> filteredTableRes = allTableRes.stream()
				.filter(tabResRepo -> tabResRepo.getNombrePlaces() >= reservation.getNbPersonnes())
				.collect(Collectors.toList());
		return filteredTableRes;
	}
	
	
}

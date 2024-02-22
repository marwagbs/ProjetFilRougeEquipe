package m2i.srpingboot.fil.rouge.equipe.filRougeEquipe.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import m2i.srpingboot.fil.rouge.equipe.filRougeEquipe.entities.Reservation;
import m2i.srpingboot.fil.rouge.equipe.filRougeEquipe.repositories.ReservationRepository;

@Service
public class ReservationService {
	@Autowired
	private ReservationRepository reservationRepo;
	
	public Iterable<Reservation> getAll() { return reservationRepo.findAll(); }
	public Reservation getById(int id) { return reservationRepo.findById(id).get(); }
	public void save(Reservation reservation) { reservationRepo.save(reservation); }
	public void delete(int id) { reservationRepo.deleteById(id); }
}

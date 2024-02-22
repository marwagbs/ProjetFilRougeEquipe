package m2i.srpingboot.fil.rouge.equipe.filRougeEquipe.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import m2i.srpingboot.fil.rouge.equipe.filRougeEquipe.entities.Reservation;
import m2i.srpingboot.fil.rouge.equipe.filRougeEquipe.services.ReservationService;

@RestController
@CrossOrigin
@RequestMapping("/reservations")
public class ReservationController {
	@Autowired
	private ReservationService rs;
	
	@GetMapping
	public Iterable<Reservation> getAll() {
		return rs.getAll();
	}
	
	@GetMapping("/{id}")
	public Reservation getById(@PathVariable("id") int id) {
		return rs.getById(id);
	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody Reservation reservation) {
		rs.save(reservation);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@PathVariable("id") int id, @RequestBody Reservation reservation) {
		reservation.setId(id);
		rs.save(reservation);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Reservation> delete(@PathVariable("id") int id) {
		Reservation reservation = rs.getById(id);
		rs.delete(id);
		return new ResponseEntity<>(reservation, HttpStatus.OK);
	}

}

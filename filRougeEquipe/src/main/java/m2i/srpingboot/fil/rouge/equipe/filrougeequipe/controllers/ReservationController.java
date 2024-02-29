package m2i.srpingboot.fil.rouge.equipe.filrougeequipe.controllers;

import java.util.List;

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

import m2i.srpingboot.fil.rouge.equipe.filrougeequipe.entities.Reservation;
import m2i.srpingboot.fil.rouge.equipe.filrougeequipe.entities.TableRes;
import m2i.srpingboot.fil.rouge.equipe.filrougeequipe.services.ReservationService;
import m2i.srpingboot.fil.rouge.equipe.filrougeequipe.services.TableResService;

@RestController
@CrossOrigin
@RequestMapping("/reservations")
public class ReservationController {
	@Autowired
	private ReservationService rs;
	@Autowired
	private TableResService ts;
	
	@GetMapping
	public Iterable<Reservation> getAll() {
		return rs.getAll();
	}
	
	@GetMapping("/restaurant/{restaurantId}")
	public Iterable<Reservation> getReservationsByResto(@PathVariable int restaurantId) {
		return rs.findByRestaurantId(restaurantId);
	}
	
	@GetMapping("/tableres/{restaurantId}")
	public Iterable<TableRes> getTableRes(@PathVariable int restaurantId) {
		return ts.findByRestaurantId(restaurantId);
	}
	
	@GetMapping("/filtred/{reservationId}")
	public List<TableRes> getFiltredTableRes(@PathVariable int reservationId) {
		return rs.getFilteredTableRes(reservationId);
	}
	
	@GetMapping("/acceptees")
	public List<Reservation> getReservationsByStatut() {
		return rs.getReservationsByStatut("acceptée", "présent");
	}
	
	@GetMapping("/acceptees/{id}")
	public List<Reservation> getReservationsByStatutAndId(@PathVariable("id") int id) {
		return rs.getReservationsByStatutAndId("acceptée", "présent", id);
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
	
	@PutMapping("/acceptees/{id}")
	public ResponseEntity<Void> updateStatutReservation(@PathVariable("id") int id, @RequestBody Reservation reservation) {
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

package m2i.srpingboot.fil.rouge.equipe.filrougeequipe.controllers;

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

import m2i.srpingboot.fil.rouge.equipe.filrougeequipe.entities.TableRes;
import m2i.srpingboot.fil.rouge.equipe.filrougeequipe.services.TableResService;

@RestController
@CrossOrigin(origins = "http://localhost:4200") 
@RequestMapping("/tableres")
public class TableResController {
 private final TableResService tableservice;
	@Autowired
	public TableResController(TableResService tableservice) {
		this.tableservice = tableservice;
		
	}
	@GetMapping
	public ResponseEntity<Iterable<TableRes>> findAll() {
		return new ResponseEntity<>(tableservice.getAll(), HttpStatus.OK); 
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<TableRes> find(@PathVariable("id") int id){
		return new ResponseEntity<>(tableservice.getById(id), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody TableRes t){
		tableservice.save(t);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PutMapping(path = "/{id}")
	public ResponseEntity<Void> update(@PathVariable("id") int id, @RequestBody TableRes t){
		t.setId(id);
		tableservice.save(t);
		return new ResponseEntity<>(HttpStatus.OK);
		
	}


	@DeleteMapping(path= "/{id}")
		public ResponseEntity<Void> delete(@PathVariable("id") int id ){
		tableservice.deleteById(id);
			return new ResponseEntity<Void>(HttpStatus.OK);	
		}
	/******************** Methodes pour changer statut table a present ou absent ****************************/
	
	@PutMapping(path = "/{id}/libre")
    public ResponseEntity<Void> statutTableLibre(@PathVariable("id") int id) {
	tableservice.mettreStatutLibre(id);
		return new ResponseEntity<>(HttpStatus.OK);
    }
	
	@PutMapping(path = "/{id}/occupee")
    public ResponseEntity<Void> statutTableOccupee(@PathVariable("id") int id) {
	tableservice.mettreStatutOccupee(id);
		return new ResponseEntity<>(HttpStatus.OK);
    }
	
	@GetMapping(path = "/{idRes}/tables")
	public ResponseEntity<Iterable<TableRes>> afficherTablesRestau(@PathVariable("idRes") int idRes){
		return new ResponseEntity<>(tableservice.afficherTablesRestau(idRes), HttpStatus.OK); 
		
	}
	@GetMapping(path = "/{idRes}/tablesOccupees")
	public ResponseEntity<Iterable<TableRes>> afficherTablesRestauOccupees (@PathVariable("idRes") int idRes){
		return new ResponseEntity<>(tableservice.afficherTablesRestauOccupes(idRes), HttpStatus.OK); 
		
	}
	
	
}

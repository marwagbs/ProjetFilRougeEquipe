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


import m2i.srpingboot.fil.rouge.equipe.filRougeEquipe.entities.TableRes;
import m2i.srpingboot.fil.rouge.equipe.filRougeEquipe.services.TableResService;

@RestController
@CrossOrigin
@RequestMapping("/tableres")
public class TableResController {
	@Autowired private TableResService tableservice;

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
	// methode à completer : pas fini 
	@PutMapping(path = "/{id}")
	public ResponseEntity<Void> statutTablePresent(@PathVariable("id") int id, @RequestBody TableRes t){
		t.setId(id);
		
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	

	@DeleteMapping(path= "/{id}")
		public ResponseEntity<Void> delete(@PathVariable("id") int id ){
		tableservice.deleteById(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
			
		}
	
	
}

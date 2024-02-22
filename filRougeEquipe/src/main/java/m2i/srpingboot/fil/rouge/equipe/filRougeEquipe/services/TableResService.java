package m2i.srpingboot.fil.rouge.equipe.filRougeEquipe.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import m2i.srpingboot.fil.rouge.equipe.filRougeEquipe.entities.TableRes;
import m2i.srpingboot.fil.rouge.equipe.filRougeEquipe.repositories.TableResRepository;

@Service
public class TableResService {
	@Autowired private TableResRepository tableResRepo; 
	
	
	public Iterable<TableRes> getAll() {return tableResRepo.findAll();}
	public TableRes getById(int id) {return tableResRepo.findById(id).get();}
	public void save(TableRes tableRes) {tableResRepo.save(tableRes);}
	public void deleteById(int id) {tableResRepo.deleteById(id);}
}

package m2i.srpingboot.fil.rouge.equipe.filrougeequipe.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import m2i.srpingboot.fil.rouge.equipe.filrougeequipe.entities.TableRes;
import m2i.srpingboot.fil.rouge.equipe.filrougeequipe.repositories.TableResRepository;

@Service
@Transactional
public class TableResService {
	@Autowired private TableResRepository tableResRepo; 
	
	
	public Iterable<TableRes> getAll() {return tableResRepo.findAll();}
	public TableRes getById(int id) {return tableResRepo.findById(id).get();}
	public void save(TableRes tableRes) {tableResRepo.save(tableRes);}
	public void deleteById(int id) {tableResRepo.deleteById(id);}
	
	/*****************************************************************************************/
	public List<TableRes> findByRestaurantId(int id) {
		return tableResRepo.findByRestaurantId(id);
	}
	
/**************************************************************************************************/
	
	 public void mettreStatutLibre(int id) {
	       TableRes tableRes = tableResRepo.findById(id).get();
	        tableRes.setStatut("libre");
	        tableResRepo.save(tableRes);
	    }

public void mettreStatutOccupee(int id) {
	  TableRes tableRes = tableResRepo.findById(id).get();
      tableRes.setStatut("occupée");
      tableResRepo.save(tableRes);
  }

public List<TableRes> afficherTablesRestau(int id){
	return tableResRepo.afficherTablesRestau(id);
	
}
	}


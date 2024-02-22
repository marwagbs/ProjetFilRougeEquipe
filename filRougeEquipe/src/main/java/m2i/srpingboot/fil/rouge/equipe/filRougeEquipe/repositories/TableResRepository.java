package m2i.srpingboot.fil.rouge.equipe.filRougeEquipe.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import m2i.srpingboot.fil.rouge.equipe.filRougeEquipe.entities.TableRes;

public interface TableResRepository extends CrudRepository<TableRes, Integer>{
	List<TableRes> findByRestaurantId(int id);
}

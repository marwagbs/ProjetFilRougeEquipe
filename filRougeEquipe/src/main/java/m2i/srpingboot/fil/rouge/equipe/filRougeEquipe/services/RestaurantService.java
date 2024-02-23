package m2i.srpingboot.fil.rouge.equipe.filRougeEquipe.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import m2i.srpingboot.fil.rouge.equipe.filRougeEquipe.entities.Restaurant;
import m2i.srpingboot.fil.rouge.equipe.filRougeEquipe.repositories.RestaurantRepository;

@Service
@Transactional
public class RestaurantService {
	@Autowired private RestaurantRepository restaurantRepo;
	
	public Iterable<Restaurant> getAll() { return restaurantRepo.findAll();}
    public Restaurant getById(int id) {return restaurantRepo.findById(id).get();}
    public void save(Restaurant restaurant) {restaurantRepo.save(restaurant);}
    public void deleteById(int id) {restaurantRepo.deleteById(id);}
}

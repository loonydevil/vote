package food.dao;

import org.springframework.data.repository.CrudRepository;

import food.model.Restorant;

public interface RestorantDao extends CrudRepository<Restorant, Integer> {

}

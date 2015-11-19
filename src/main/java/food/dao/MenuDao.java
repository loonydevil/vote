package food.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import food.model.Menu;
import food.model.Restorant;

public interface MenuDao extends CrudRepository<Menu, Integer> {

    List<Menu> findAllByRestorantId(Integer restorantId);
}

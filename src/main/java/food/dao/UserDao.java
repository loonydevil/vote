package food.dao;

import org.springframework.data.repository.CrudRepository;

import food.model.User;

public interface UserDao extends CrudRepository<User, Integer> {
    
    User findByEmail(String email);
}

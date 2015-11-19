package food.service;

import food.model.User;

public interface UserService {

    User createUser(String name, String email, String password, Boolean isAdmin);

}

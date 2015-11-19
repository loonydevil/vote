package food.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import food.dao.UserDao;
import food.model.User;

@Service
public class UserServiceImpl implements UserService {
    
    @Autowired
    private UserDao userDao;
    
    @Override
    public User createUser(String name, String email, String password, Boolean isAdmin) {
        User user = new User();
        user.setEmail(email);
        user.setIsAdmin(isAdmin);
        user.setName(name);
        user.setPassword(password);
        return userDao.save(user);
    }

}

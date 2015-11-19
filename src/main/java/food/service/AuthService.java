package food.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import food.dao.UserDao;
import food.exceptions.FoodException;
import food.model.User;

@Service
public class AuthService {
    
    @Autowired
    private UserDao userDao;
    
    public User authenticate(String email, String password) throws FoodException {
        User user = userDao.findByEmail(email);
        if (user == null || !user.getPassword().equals(password)) {
            throw new FoodException("Wrong authentication data provided", HttpStatus.UNAUTHORIZED);
        }
        
        return user;
    }
    
    public void checkIfAdmin(User user) throws FoodException {
        if (!user.getIsAdmin()) {
            throw new FoodException("Who do you think you are?", HttpStatus.FORBIDDEN);
        }
    }

}

package food.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import food.exceptions.FoodException;
import food.model.User;
import food.service.AuthService;
import food.service.UserService;

@RestController
public class UserController extends BaseController {

    public final static String PATH = "/food/v1.0/user/";
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private AuthService authService;
    
    @RequestMapping(value = PATH, method = RequestMethod.POST, produces = "application/json")
    public User createUser(@RequestParam String password,
                           @RequestParam String name,
                           @RequestParam String email,
                           @RequestParam Boolean isAdmin,
                           @RequestHeader("email") String authEmail,
                           @RequestHeader("password") String authPassword) throws FoodException {
                       User user = authService.authenticate(authEmail, authPassword);
                       authService.checkIfAdmin(user);
        return userService.createUser(name, email, password, isAdmin);
    }
}

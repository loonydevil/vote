package food.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import food.exceptions.FoodException;
import food.model.Restorant;
import food.model.User;
import food.service.AuthService;
import food.service.RestorantService;

@RestController
public class RestorantController extends BaseController {
    
    public final static String PATH = "/food/v1.0/restorant/";
    
    @Autowired
    private RestorantService restorantService;
    
    @Autowired
    private AuthService authService;
    
    @RequestMapping(value = PATH, method = RequestMethod.POST, produces = "application/json")
    public Restorant createRestorant(@RequestParam String name,
            @RequestHeader("email") String email,
            @RequestHeader("password") String password) throws FoodException {
        User user = authService.authenticate(email, password);
        authService.checkIfAdmin(user);
        return restorantService.createRestorant(name);
    }

    @RequestMapping(value = PATH, method = RequestMethod.GET, produces = "application/json")
    public List<Restorant> getRestorants() {
        return restorantService.getRestorants();
    }
}

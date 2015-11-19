package food.api;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import food.dto.MenuDto;
import food.exceptions.FoodException;
import food.model.Menu;
import food.model.User;
import food.service.AuthService;
import food.service.MenuService;

@RestController
public class MenuController extends BaseController {
    
    public final static String PATH = "/food/v1.0/menu/";
    
    @Autowired
    private AuthService authService;
    
    @Autowired
    private MenuService menuService;
    
    @RequestMapping(value = PATH, method = RequestMethod.POST, produces = "application/json")
    public Menu createMenu(@RequestParam Integer restorantId,
            @RequestParam String dishName,
            @RequestParam BigDecimal price,
            @RequestHeader("email") String email,
            @RequestHeader("password") String password) throws FoodException {
        User user = authService.authenticate(email, password);
        authService.checkIfAdmin(user);
        return menuService.createMenu(restorantId, dishName, price);
    }
    
    @RequestMapping(value = PATH, method = RequestMethod.DELETE, produces = "application/json")
    public void deleteMenu(@RequestParam Integer restorantId) throws FoodException {
        menuService.clearMenuForRestorant(restorantId);
    }

    @RequestMapping(value = PATH, method = RequestMethod.GET, produces = "application/json")
    public MenuDto getMenu(@RequestParam Integer restorantId) throws FoodException {
        return menuService.getMenuDto(restorantId);
    }
}

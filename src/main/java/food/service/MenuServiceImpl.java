package food.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import food.dao.MenuDao;
import food.dao.RestorantDao;
import food.dto.MenuDto;
import food.exceptions.FoodException;
import food.model.Menu;
import food.model.Restorant;

@Service
public class MenuServiceImpl implements MenuService {
    
    @Autowired
    private RestorantDao restorantDao;
    
    @Autowired
    private MenuDao menuDao;

    @Override
    public Menu createMenu(Integer restorantId, String dishName, BigDecimal price) throws FoodException {
        Restorant restorant = restorantDao.findOne(restorantId);
        if (restorant == null) {
            throw new FoodException("There's no such restorant", HttpStatus.BAD_REQUEST);
        }
        Menu menu = new Menu();
        menu.setDish(dishName);
        menu.setPrice(price);
        menu.setRestorant(restorant);
        return menuDao.save(menu);
    }
    
    @Override
    public void clearMenuForRestorant(Integer restorantId) throws FoodException {
        Restorant restorant = restorantDao.findOne(restorantId);
        if (restorant == null) {
            throw new FoodException("There's no such restorant", HttpStatus.BAD_REQUEST);
        }
        List<Menu> menus = menuDao.findAllByRestorantId(restorantId);
        menus.stream().forEach(menuDao::delete);
    }
    
    @Override
    public MenuDto getMenuDto(Integer restorantId) throws FoodException {
        Restorant restorant = restorantDao.findOne(restorantId);
        if (restorant == null) {
            throw new FoodException("There's no such restorant", HttpStatus.BAD_REQUEST);
        }
        List<Menu> menus = menuDao.findAllByRestorantId(restorantId);
        return new MenuDto(menus);
    }
    
}

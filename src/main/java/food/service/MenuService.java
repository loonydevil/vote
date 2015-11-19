package food.service;

import java.math.BigDecimal;

import food.dto.MenuDto;
import food.exceptions.FoodException;
import food.model.Menu;

public interface MenuService {

    void clearMenuForRestorant(Integer restorantId) throws FoodException;

    Menu createMenu(Integer restorantId, String dishName, BigDecimal price) throws FoodException;

    MenuDto getMenuDto(Integer restorantId) throws FoodException;

}

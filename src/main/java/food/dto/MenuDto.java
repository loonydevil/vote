package food.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import food.model.Menu;
import food.model.Restorant;

public class MenuDto {
    
    public Restorant restorant;
    
    public List<Dish> dishes;
    
    public MenuDto() {
        
    }
    
    public MenuDto(List<Menu> menus) {
        List<Dish> dishes = new ArrayList<>();
        for (Menu menu: menus) {
            this.restorant = menu.getRestorant();
            dishes.add(new Dish(menu.getDish(), menu.getPrice()));
        }
        this.dishes = dishes;
    }
    
    public class Dish {
        public Dish(String dish, BigDecimal price) {
            this.dish = dish;
            this.price = price;
        }
        String dish;
        BigDecimal price;
        public String getDish() {
            return dish;
        }
        public void setDish(String dish) {
            this.dish = dish;
        }
        public BigDecimal getPrice() {
            return price;
        }
        public void setPrice(BigDecimal price) {
            this.price = price;
        }
    }



    public Restorant getRestorant() {
        return restorant;
    }



    public void setRestorant(Restorant restorant) {
        this.restorant = restorant;
    }



    public List<Dish> getDishes() {
        return dishes;
    }

}

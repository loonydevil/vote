package food.api;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ExceptionHandler;
import food.exceptions.FoodException;

public class BaseController {
    
    @ExceptionHandler(FoodException.class)
    public Map<String, Object> handleFoodException(HttpServletRequest request, HttpServletResponse response,
            FoodException ex) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("status", ex.getStatus());
        map.put("details", ex.getMessage());
        response.setStatus(ex.getStatus().value());
        return map;
    }
    
}

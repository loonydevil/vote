package food.exceptions;

import org.springframework.http.HttpStatus;

public class FoodException extends Exception {
    
    private HttpStatus status;
    
    public FoodException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }

}

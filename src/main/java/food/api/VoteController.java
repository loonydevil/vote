package food.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import food.exceptions.FoodException;
import food.model.User;
import food.model.Vote;
import food.service.AuthService;
import food.service.VoteService;

@RestController
public class VoteController extends BaseController {
    
    public final static String PATH = "/food/v1.0/vote/";
    
    @Autowired
    private VoteService voteService;
    
    @Autowired
    private AuthService authService;
    
    @RequestMapping(value = PATH, method = RequestMethod.POST, produces = "application/json")
    public Vote createVote(@RequestParam Integer restorantId,
            @RequestHeader("email") String email,
            @RequestHeader("password") String password) throws FoodException {
        User user = authService.authenticate(email, password);
        return voteService.createVote(user.getId(), restorantId);
    }
    
}

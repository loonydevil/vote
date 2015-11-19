package food.service;

import food.exceptions.FoodException;
import food.model.Vote;

public interface VoteService {

    Vote createVote(Integer userId, Integer restorantId) throws FoodException;

}

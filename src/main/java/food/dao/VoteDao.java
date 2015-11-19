package food.dao;

import org.springframework.data.repository.CrudRepository;

import food.model.Vote;

public interface VoteDao extends CrudRepository<Vote, Integer> {
    
    Vote findFirstByUserId(Integer userId);

}

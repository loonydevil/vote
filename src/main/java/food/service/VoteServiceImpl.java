package food.service;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import food.dao.RestorantDao;
import food.dao.UserDao;
import food.dao.VoteDao;
import food.exceptions.FoodException;
import food.model.Restorant;
import food.model.User;
import food.model.Vote;

@Service
public class VoteServiceImpl implements VoteService{
    
    @Autowired
    private VoteDao voteDao;
    
    @Autowired
    private RestorantDao restorantDao;
    
    @Autowired
    private UserDao userDao;
    
    @Override
    public Vote createVote(Integer userId, Integer restorantId) throws FoodException{

        Restorant restorant = restorantDao.findOne(restorantId);
        if (restorant == null) {
            throw new FoodException("No such restorant", HttpStatus.BAD_REQUEST);
        }
        
        Vote existingVote = voteDao.findFirstByUserId(userId);
        if (existingVote != null) {
            Calendar calendar = Calendar.getInstance();
            int hour = calendar.get(Calendar.HOUR_OF_DAY);
            if (hour < 11) {
                existingVote.setRestorant(restorant);
                return voteDao.save(existingVote);
            } else {
                throw new FoodException("It's too late to change your mind", HttpStatus.I_AM_A_TEAPOT);
            }
        }

        Vote vote = new Vote();
        vote.setRestorant(restorantDao.findOne(restorantId));
        vote.setUser(userDao.findOne(userId));
        return voteDao.save(vote);
    }

}

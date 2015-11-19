package food.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import food.dao.RestorantDao;
import food.model.Restorant;

@Service
public class RestorantServiceImpl implements RestorantService{
    
    @Autowired
    private RestorantDao restorantDao;
    
    @Override
    public Restorant createRestorant(String name) {
        Restorant restorant = new Restorant();
        restorant.setName(name);
        return restorantDao.save(restorant);
    }
    
    @Override
    public List<Restorant> getRestorants() {
        List<Restorant> list = new ArrayList<>();
        restorantDao.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

}

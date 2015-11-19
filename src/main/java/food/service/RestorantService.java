package food.service;

import java.util.List;

import food.model.Restorant;

public interface RestorantService {

    Restorant createRestorant(String name);

    List<Restorant> getRestorants();

}

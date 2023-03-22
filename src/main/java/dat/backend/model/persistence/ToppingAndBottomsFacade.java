package dat.backend.model.persistence;

import dat.backend.model.entities.Bottoms;
import dat.backend.model.entities.Topping;

import java.util.List;

public class ToppingAndBottomsFacade {

    public static List<Topping> getAllTopping(ConnectionPool connectionPool) {

        return ToppingAndBottomsMapper.getAllTopping(connectionPool);
    }

   public static List<Bottoms> getAllBottoms(ConnectionPool connectionPool) {
        return ToppingAndBottomsMapper.getAllBottoms(connectionPool);

   }
}

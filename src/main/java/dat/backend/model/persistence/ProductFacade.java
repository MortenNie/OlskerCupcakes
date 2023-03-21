package dat.backend.model.persistence;

import dat.backend.model.entities.Bottoms;
import dat.backend.model.entities.Product;
import dat.backend.model.entities.Topping;

public class ProductFacade {

    public static Product createProduct (String productName, Topping topping, Bottoms bottoms, int quantity, ConnectionPool connectionPool){
        return ProductMapper.createProduct(productName, topping, bottoms, quantity, connectionPool);
    }

}

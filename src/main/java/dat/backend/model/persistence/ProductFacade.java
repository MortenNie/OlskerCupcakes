package dat.backend.model.persistence;

import dat.backend.model.entities.Bottoms;
import dat.backend.model.entities.Product;
import dat.backend.model.entities.Topping;
import dat.backend.model.exceptions.DatabaseException;

public class ProductFacade {

    public static Product createProduct (String productName, Topping topping, Bottoms bottoms, int quantity, ConnectionPool connectionPool){
        return ProductMapper.createProduct(productName, topping, bottoms, quantity, connectionPool);
    }
    public static void addOrderIdToProduct( int orderId, ConnectionPool connectionPool) throws DatabaseException{
        ProductMapper.addOrderIdToProduct(orderId, connectionPool);
    }

}

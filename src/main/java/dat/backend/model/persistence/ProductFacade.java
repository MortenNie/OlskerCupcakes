package dat.backend.model.persistence;

import dat.backend.model.entities.Bottoms;
import dat.backend.model.entities.Product;
import dat.backend.model.entities.Topping;
import dat.backend.model.exceptions.DatabaseException;

import java.util.List;

public class ProductFacade {

    public static Product createProduct (int productId, String productName, Topping topping, Bottoms bottoms, int quantity, ConnectionPool connectionPool){
        return ProductMapper.createProduct(productId, productName, topping, bottoms, quantity, connectionPool);
    }
    public static void addOrderIdToProduct( int orderId, int productId, ConnectionPool connectionPool) throws DatabaseException{
        ProductMapper.addOrderIdToProduct(orderId, productId, connectionPool);
    }
  public static List<Product> selectProductFromOrderId(int orderId, ConnectionPool connectionPool) {

        return ProductMapper.selectProductFromOrderId(orderId, connectionPool);
  }
}

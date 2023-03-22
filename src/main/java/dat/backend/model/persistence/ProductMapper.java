package dat.backend.model.persistence;

import dat.backend.model.entities.Bottoms;
import dat.backend.model.entities.Product;
import dat.backend.model.entities.Topping;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductMapper {

    static Product createProduct(String productName, Topping topping, Bottoms bottoms, int quantity, ConnectionPool connectionPool) {
        Logger.getLogger("web").log(Level.INFO, "");
        Product product= null;

        String sql = "insert into product ( product_name, topping, bottom, quantity) values (?,?,?,?)";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {


                ps.setString(1, productName);
                ps.setString(2, topping.getToppingName());
                ps.setString(3, bottoms.getBottomsName());
                ps.setInt(4, quantity);

                ps.executeUpdate();

                product = new Product(productName,topping,bottoms,quantity);

            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return product;
    }

}

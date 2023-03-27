package dat.backend.model.persistence;

import dat.backend.model.entities.Bottoms;
import dat.backend.model.entities.Order;
import dat.backend.model.entities.Product;
import dat.backend.model.entities.Topping;
import dat.backend.model.exceptions.DatabaseException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductMapper {

    static Product createProduct(int productId, String productName, Topping topping, Bottoms bottoms, int quantity, ConnectionPool connectionPool) {
        Logger.getLogger("web").log(Level.INFO, "");
        Product product = null;

        String sql = "insert into product (product_name, topping, bottom, quantity) values (?,?,?,?)";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {


                ps.setString(1, productName);
                ps.setString(2, topping.getToppingName());
                ps.setString(3, bottoms.getBottomsName());
                ps.setInt(4, quantity);

                ps.executeUpdate();
                ResultSet rs = ps.getGeneratedKeys();
                rs.next();


                product = new Product(rs.getInt(1), productName, topping, bottoms, quantity);

            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return product;
    }


    public static void addOrderIdToProduct(int orderId, int productId, ConnectionPool connectionPool) throws DatabaseException {
        Logger.getLogger("web").log(Level.INFO, "");

        String sql = "Update product SET order_id = ? WHERE product_id = ?";
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, orderId);
                ps.setInt(2, productId);
                ps.executeUpdate();


            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "Could not insert order into database");
        }

    }

    static void selectProduct(int productId, ConnectionPool connectionPool) throws DatabaseException {
        Logger.getLogger("web").log(Level.INFO, "");
        int productIdTwo = -1;
        String sql = "Select * from product Where product_id = ?";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {

                ps.setInt(1, productId);
                ps.executeQuery();


            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "Could not insert order into database");
        }

    }

    public static int returnProductId(String productName, Topping topping, Bottoms bottoms, int quantity, ConnectionPool connectionPool) {
        Logger.getLogger("web").log(Level.INFO, "");
        int ts = -1;

        String sql = "insert into product (product_name, topping, bottom, quantity) values (?,?,?,?)";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {


                ps.setString(1, productName);
                ps.setString(2, topping.getToppingName());
                ps.setString(3, bottoms.getBottomsName());
                ps.setInt(4, quantity);

                ps.executeUpdate();
                ResultSet rs = ps.getGeneratedKeys();
                rs.next();


                 ts = rs.getInt(1);

            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

      return ts;
    }

    public static void addOrderIdToProductTwo(int orderId, String topping, String bottom, ConnectionPool connectionPool) throws DatabaseException {
        Logger.getLogger("web").log(Level.INFO, "");

        String sql = "Insert into product (order_id, topping, bottom) values (?,?,?)";
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, orderId);
                ps.setString(2, topping );
                ps.setString(3, bottom);
                ps.executeUpdate();
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "Could not insert order into database");
        }

    }

    static List<Product> selectProductFromOrderId(int orderId, ConnectionPool connectionPool) {
        Logger.getLogger("web").log(Level.INFO, "");
        List<Product> productList = new ArrayList<>();
        String sql = "SELECT product_id, topping, topping.price, bottom,  bottoms.price, quantity, topping_id, bottoms_id FROM product INNER JOIN topping ON product.topping = topping.topping_name INNER JOIN bottoms ON product.bottom = bottoms.bottoms_name WHERE product.order_id = ?";

        try (Connection connection = connectionPool.getConnection()){

            try(PreparedStatement ps = connection.prepareStatement(sql)){
                ps.setInt(1, orderId);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int productId = rs.getInt("product_id");
                    String productName = "cupcake";
                    Topping topping = new Topping(rs.getInt("topping_id"),rs.getString("topping"), rs.getInt("topping.price"));
                    Bottoms bottom = new Bottoms(rs.getInt("bottoms_id"),rs.getString("bottom"), rs.getInt("bottoms.price"));
                    int quantity = rs.getInt("quantity");
                    Product newProduct = new Product(productId, productName, topping, bottom, quantity);
                    productList.add(newProduct);


                }



            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return productList;
    }

    static void deleteProduct(int productId, ConnectionPool connectionPool) throws DatabaseException {
        Logger.getLogger("web").log(Level.INFO, "");
        String sql = "DELETE from product Where product_id = ?";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {

                ps.setInt(1, productId);
                ps.executeUpdate();


            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "Could not insert order into database");
        }

    }



}
package dat.backend.model.persistence;

import dat.backend.model.entities.Order;
import dat.backend.model.entities.User;
import dat.backend.model.exceptions.DatabaseException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OrderMapper {
    public static int addOrder( String username, ConnectionPool connectionPool) throws DatabaseException {
        Logger.getLogger("web").log(Level.INFO, "");
        Order order;
        String sql = "insert into olskercupcakes.order (username) values (?)";
        try (Connection connection = connectionPool.getConnection())
        {
            try (PreparedStatement ps = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS))
            {
                ps.setString(1, username);

                ps.executeUpdate();


                ResultSet rs = ps.getGeneratedKeys();
                rs.next();
                return rs.getInt(1);



            }
        }
        catch (SQLException ex)
        {
            throw new DatabaseException(ex, "Could not insert order into database");
        }

    }

    public static void removeOrder(int orderId,  ConnectionPool connectionPool) {

        String sql = "DELETE FROM olskercupcakes.order WHERE order_id = ?";

        try (Connection connection = connectionPool.getConnection()){

            try(PreparedStatement ps = connection.prepareStatement(sql)){

                ps.setInt(1,orderId);
                ps.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

     static List<Order> selectAllOrders(ConnectionPool connectionPool) {
        Logger.getLogger("web").log(Level.INFO, "");
        List<Order> orderList = new ArrayList<>();
        String sql = "SELECT * FROM olskercupcakes.order";

        try (Connection connection = connectionPool.getConnection()){

            try(PreparedStatement ps = connection.prepareStatement(sql)){

                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int OrderId = rs.getInt("order_id");
                    Timestamp date = rs.getTimestamp("date");
                    String username = rs.getString("username");

                    Order newOrder = new Order(OrderId, date, username);
                    orderList.add(newOrder);


                }



            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return orderList;
    }
    static List<Order> selectAllOrdersFromUser(String user, ConnectionPool connectionPool) {
        Logger.getLogger("web").log(Level.INFO, "");
        List<Order> orderList = new ArrayList<>();
        String sql = "SELECT * FROM olskercupcakes.order WHERE username = ?";

        try (Connection connection = connectionPool.getConnection()){

            try(PreparedStatement ps = connection.prepareStatement(sql)){
                ps.setString(1, user);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int OrderId = rs.getInt("order_id");
                    Timestamp date = rs.getTimestamp("date");
                    String username = rs.getString("username");

                    Order newOrder = new Order(OrderId, date, username);
                    orderList.add(newOrder);


                }



            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return orderList;
    }

    static String SelectUserNameFromOrderId(int orderId, ConnectionPool connectionPool) {
        String sql = "SELECT * FROM olskercupcakes.order WHERE order_id = ?";

        String username = null;

        try (Connection connection = connectionPool.getConnection()) {

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, orderId);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {

                    username = rs.getString("username");




                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return username;

    }

}



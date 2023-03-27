package dat.backend.model.persistence;

import dat.backend.model.entities.Order;
import dat.backend.model.exceptions.DatabaseException;

import java.util.List;

public class OrderFacade {
    public static int addOrder(String username, ConnectionPool connectionPool) throws DatabaseException {
        return OrderMapper.addOrder(username,connectionPool);
    }

    public static void removeOrder(int orderId,  ConnectionPool connectionPool){
        OrderMapper.removeOrder(orderId, connectionPool);
    }

    public static List<Order> selectAllOrders(ConnectionPool connectionPool) {

        return OrderMapper.selectAllOrders(connectionPool);
    }

    public static List<Order> selectAllOrdersFromUser(String user, ConnectionPool connectionPool) {
        return OrderMapper.selectAllOrdersFromUser(user, connectionPool);

    }

   public static String SelectUserNameFromOrderId(int orderId, ConnectionPool connectionPool) {
        return OrderMapper.SelectUserNameFromOrderId(orderId, connectionPool);

   }
}

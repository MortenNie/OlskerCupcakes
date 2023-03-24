package dat.backend.model.persistence;

import dat.backend.model.exceptions.DatabaseException;

public class OrderFacade {
    public static int addOrder(String username, ConnectionPool connectionPool) throws DatabaseException {
        return OrderMapper.addOrder(username,connectionPool);
    }

    public static void removeOrder(int orderId,  ConnectionPool connectionPool){
        OrderMapper.removeOrder(orderId, connectionPool);
    }
}

package dat.backend.model.persistence;

import dat.backend.model.entities.Order;
import dat.backend.model.exceptions.DatabaseException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
            throw new DatabaseException(ex, "Could not insert item into database");
        }

    }
}

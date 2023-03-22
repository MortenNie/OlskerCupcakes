package dat.backend.model.persistence;

import dat.backend.model.entities.User;
import dat.backend.model.exceptions.DatabaseException;

import java.sql.SQLException;
import java.util.List;

public class UserFacade
{
    public static User login(String username, String password, ConnectionPool connectionPool) throws DatabaseException
    {
        return UserMapper.login(username, password, connectionPool);
    }

    public static User createUser(String username, String password, String role,int balance, ConnectionPool connectionPool) throws DatabaseException
    {
        return UserMapper.createUser(username, password, role, balance, connectionPool);
    }

    public static List<User> testIfUserExists(String user, ConnectionPool connectionPool) {
        return UserMapper.testIfUserExist(user, connectionPool);

    }
   public static List<User> getAllUsers(ConnectionPool connectionPool) {

       return UserMapper.getAllUsers(connectionPool);
   }

   public static void changeBalance(String username, int balance, ConnectionPool connectionPool) throws SQLException {
         UserMapper.changeBalance(username, balance, connectionPool);

   }

   public static User SelectUserFromUsername(String username, ConnectionPool connectionPool) {

       return UserMapper.SelectUserFromUsername(username, connectionPool);
   }

}

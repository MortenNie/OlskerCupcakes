package dat.backend.model.persistence;

import dat.backend.model.entities.User;
import dat.backend.model.exceptions.DatabaseException;

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

}

package dat.backend.persistence;

import dat.backend.model.entities.User;
import dat.backend.model.exceptions.DatabaseException;
import dat.backend.model.persistence.ConnectionPool;
import dat.backend.model.persistence.UserFacade;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.*;

class UserMapperTest
{
    // TODO: Change mysql login credentials if needed below

    private final static String USER = "root";
    private final static String PASSWORD = "1234morten";
    private final static String URL = "jdbc:mysql://localhost:3306/olskercupcakes_test?serverTimezone=CET&allowPublicKeyRetrieval=true&useSSL=false";

    private static ConnectionPool connectionPool;

    @BeforeAll
    public static void setUpClass()
    {
        connectionPool = new ConnectionPool(USER, PASSWORD, URL);

        try (Connection testConnection = connectionPool.getConnection())
        {
            try (Statement stmt = testConnection.createStatement())
            {
                // Create test database - if not exist
                stmt.execute("CREATE DATABASE  IF NOT EXISTS olskercupcakes_test;");

                // TODO: Create user table. Add your own tables here
                stmt.execute("CREATE TABLE IF NOT EXISTS olskercupcakes_test.user LIKE olskercupcakes.user;");
            }
        }
        catch (SQLException throwables)
        {
            System.out.println(throwables.getMessage());
            fail("Database connection failed");
        }
    }

    @BeforeEach
    void setUp()
    {
        try (Connection testConnection = connectionPool.getConnection())
        {
            try (Statement stmt = testConnection.createStatement())
            {
                // TODO: Remove all rows from all tables - add your own tables here
                stmt.execute("delete from user");

                // TODO: Insert a few users - insert rows into your own tables here
                stmt.execute("insert into user (username, password, role) " +
                        "values ('user','1234','user'),('admin','1234','admin'), ('ben','1234','user')");
            }
        }
        catch (SQLException throwables)
        {
            System.out.println(throwables.getMessage());
            fail("Database connection failed");
        }
    }

    @Test
    void testConnection() throws SQLException
    {
        Connection connection = connectionPool.getConnection();
        assertNotNull(connection);
        if (connection != null)
        {
            connection.close();
        }
    }

    @Test
    void login() throws DatabaseException
    {
        User expectedUser = new User("user", "1234", "user", 500);
        User actualUser = UserFacade.login("user", "1234", connectionPool);
        assertEquals(expectedUser, actualUser);
    }

    @Test
    void invalidPasswordLogin() throws DatabaseException
    {
        assertThrows(DatabaseException.class, () -> UserFacade.login("user", "123", connectionPool));
    }

    @Test
    void invalidUserNameLogin() throws DatabaseException
    {
        assertThrows(DatabaseException.class, () -> UserFacade.login("bob", "1234", connectionPool));
    }

    @Test
    void createUser() throws DatabaseException
    {
        User newUser = UserFacade.createUser("jill", "1234", "user",500, connectionPool);
        User logInUser = UserFacade.login("jill", "1234", connectionPool);
        User expectedUser = new User("jill", "1234", "user", 500);
        assertEquals(expectedUser, newUser);
        assertEquals(expectedUser, logInUser);

    }
}
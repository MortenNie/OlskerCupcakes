package dat.backend.model.persistence;

import dat.backend.model.entities.User;
import dat.backend.model.exceptions.DatabaseException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

class UserMapper {
    static User login(String username, String password, ConnectionPool connectionPool) throws DatabaseException {
        Logger.getLogger("web").log(Level.INFO, "");

        User user = null;

        String sql = "SELECT * FROM user WHERE username = ? AND password = ?";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1, username);
                ps.setString(2, password);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {

                    int balance = rs.getInt("balance");
                    String role = rs.getString("role");
                    user = new User(username, password, role, balance);
                } else {
                    throw new DatabaseException("Wrong username or password");
                }
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "Error logging in. Something went wrong with the database");
        }
        return user;
    }

    static User createUser(String username, String password, String role, int balance, ConnectionPool connectionPool) throws DatabaseException {
        Logger.getLogger("web").log(Level.INFO, "");
        User user;
        String sql = "insert into user (username, password, role, balance) values (?,?,?,?)";
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1, username);
                ps.setString(2, password);
                ps.setString(3, role);
                ps.setInt(4, balance);
                int rowsAffected = ps.executeUpdate();
                if (rowsAffected == 1) {
                    user = new User(username, password, role, balance);
                } else {
                    throw new DatabaseException("The user with username = " + username + " could not be inserted into the database");
                }
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "Could not insert username into database");
        }
        return user;
    }

    static List<User> testIfUserExist(String user, ConnectionPool connectionPool) {

        String sql = "SELECT * FROM user WHERE username = ?";

        List<User> userList = new ArrayList<>();

        try (Connection connection = connectionPool.getConnection()) {

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1, user);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {

                    String username = rs.getString("username");
                    String password = rs.getString("password");
                    String role = rs.getString("role");
                    int balance = rs.getInt("balance");

                    User newUser = new User(username, password, role, balance);
                    userList.add(newUser);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userList;

    }

    static List<User> getAllUsers(ConnectionPool connectionPool) {

        String sql = "SELECT * FROM user";

        List<User> userList = new ArrayList<>();

        try (Connection connection = connectionPool.getConnection()) {

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {

                    String username = rs.getString("username");
                    String password = rs.getString("password");
                    String role = rs.getString("role");
                    int balance = rs.getInt("balance");

                    User newUser = new User(username, password, role, balance);
                    userList.add(newUser);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userList;

    }

    static void changeBalance(String username, int balance, ConnectionPool connectionPool) throws SQLException {

        Logger.getLogger("web").log(Level.INFO, "");

        String sql = "UPDATE user SET balance = ? WHERE username = ?";
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {

                ps.setInt(1, balance);
                ps.setString(2, username);

                ps.executeUpdate();

            }

        }

    }

     static User SelectUserFromUsername(String username, ConnectionPool connectionPool) {
        String sql = "SELECT * FROM user WHERE username = ?";

        User user = null;

        try (Connection connection = connectionPool.getConnection()) {

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1, username);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    String usernameTwo = rs.getString("username");
                    String password = rs.getString("password");
                    String role = rs.getString("role");
                    int balance = rs.getInt("balance");


                    user = new User(usernameTwo, password, role, balance);

                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;

    }




}
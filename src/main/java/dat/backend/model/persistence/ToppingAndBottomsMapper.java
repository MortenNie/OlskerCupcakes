package dat.backend.model.persistence;

import dat.backend.model.entities.Bottoms;
import dat.backend.model.entities.Topping;
import dat.backend.model.entities.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

 class ToppingAndBottomsMapper {
    static List<Topping> getAllTopping(ConnectionPool connectionPool) {

        String sql = "SELECT * FROM topping";

        List<Topping> toppingList = new ArrayList<>();

        try (Connection connection = connectionPool.getConnection()) {

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {

                    int toppingId = rs.getInt("topping_id");
                    String toppingName = rs.getString("topping_name");
                    int price = rs.getInt("price");


                    Topping newTopping = new Topping(toppingId, toppingName, price);
                    toppingList.add(newTopping);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return toppingList;
    }


    static List<Bottoms> getAllBottoms(ConnectionPool connectionPool) {

        String sql = "SELECT * FROM bottoms";

        List<Bottoms> bottomsList = new ArrayList<>();

        try (Connection connection = connectionPool.getConnection()) {

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {

                    int bottomsId = rs.getInt("bottoms_id");
                    String bottomsName = rs.getString("bottoms_name");
                    int price = rs.getInt("price");


                    Bottoms newBottoms = new Bottoms(bottomsId, bottomsName, price);
                    bottomsList.add(newBottoms);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return bottomsList;


    }

     static Bottoms getBottomsFromName(String bottoms, ConnectionPool connectionPool) {

         String sql = "SELECT * FROM bottoms WHERE bottoms_name = ?";
         Bottoms bottomsTwo = null;


         try (Connection connection = connectionPool.getConnection()) {

             try (PreparedStatement ps = connection.prepareStatement(sql)) {
                 ps.setString(1,bottoms);
                 ResultSet rs = ps.executeQuery();
                 while (rs.next()) {

                     int bottomsId = rs.getInt("bottoms_id");
                     String bottomsName = rs.getString("bottoms_name");
                     int price = rs.getInt("price");


                     bottomsTwo = new Bottoms(bottomsId, bottomsName, price);

                 }
             }

         } catch (SQLException e) {
             e.printStackTrace();
         }

         return bottomsTwo;


     }
     static Topping getToppingsFromName(String topping, ConnectionPool connectionPool) {

         String sql = "SELECT * FROM topping WHERE topping_name = ?";
         Topping toppingTwo = null;


         try (Connection connection = connectionPool.getConnection()) {

             try (PreparedStatement ps = connection.prepareStatement(sql)) {
                 ps.setString(1,topping);
                 ResultSet rs = ps.executeQuery();
                 while (rs.next()) {

                     int toppingId = rs.getInt("topping_id");
                     String toppingName = rs.getString("topping_name");
                     int price = rs.getInt("price");


                     toppingTwo = new Topping(toppingId, toppingName, price);

                 }
             }

         } catch (SQLException e) {
             e.printStackTrace();
         }

         return toppingTwo;


     }
 }


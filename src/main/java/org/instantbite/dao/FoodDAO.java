package org.instantbite.dao;
import org.instantbite.config.DBConnection;
import org.instantbite.model.Food;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;

public class FoodDAO {
    public void addFood(Food food) {
        String sql = "INSERT INTO food (name, price) VALUES (?, ?)";
        try (
            Connection conn = DBConnection.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            )
        {
            statement.setString(1, food.getName());
            statement.setDouble(2, food.getPrice());

            int rows = statement.executeUpdate();
            System.out.println("rows affected: " + rows);
        }catch(Exception e) {
            System.out.println(e.getMessage());
        }


    }

    public void viewFood() {
        String sql = "SELECT * FROM food";
        try(
                Connection conn = DBConnection.getConnection();
                PreparedStatement statement = conn.prepareStatement(sql);
                ResultSet rs = statement.executeQuery();
                )
        {
            while(rs.next()) {
                System.out.println(rs.getInt("id") + " | " +
                                    rs.getString("name") + " | " +
                                    rs.getDouble("price") );
            }
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}

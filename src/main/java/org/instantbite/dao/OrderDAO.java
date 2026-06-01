package org.instantbite.dao;

import org.instantbite.config.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.instantbite.model.Order;

public  class OrderDAO {

    public static void placeOrder(Order order)
    {
      String sql = "INSERT INTO orders (food_id, quantity, total) VALUES (?, ?, ?)";

      try (
              Connection conn = DBConnection.getConnection();
              PreparedStatement ps = conn.prepareStatement(sql);
      ){
          ps.setInt(1, order.getFoodId());
          ps.setInt(2, order.getQuantity());
          ps.setDouble(3, order.getTotal());

          int row = ps.executeUpdate();
      }catch (Exception e) {
          System.out.println(e.getMessage());
      }
    }

    public static Double getFoodPrice(int foodId) {
        String sql = "SELECT * FROM orders WHERE food_id = ?";

        try(
                Connection conn = DBConnection.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);

            ) {
            ps.setInt(1, foodId);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return rs.getDouble("price");
            }

        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return (double) 0;
    }
}
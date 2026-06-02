package org.instantbite.dao;

import org.instantbite.config.DBConnection;
import org.instantbite.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {
    public static void addUser(User user) {
        String sql = "INSERT INTO users (full_name, email, password) VALUES (?, ?, ?)";
        try(
                Connection conn = DBConnection.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);
                ){

            ps.setString(1, user.getFullName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());
            int row = ps.executeUpdate();

            System.out.println(row + " user created.");

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static ResultSet findEmail(String email) {
        String sql = "SELECT * FROM users WHERE email = ?";
        try{
                Connection conn = DBConnection.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, email);

                return ps.executeQuery();
        }catch(Exception e){
            System.out.println(e.getMessage());

            return null;
        }
    }
}

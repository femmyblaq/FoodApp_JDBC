package org.instantbite.config;

import java.sql.Connection;
import java.sql.DriverManager;

//url = System.getenv("DB_URL");
//private static final String user = System.getenv("DB_USERNAME");
//private static final String password = System.getenv("DB_PASSWORD");

public class DBConnection {
    private static final String url = System.getenv("DB_URL");
    private static final String user = System.getenv("DB_USERNAME");
    private static final String password = System.getenv("DB_USERNAME");



    public static Connection getConnection() {
        try {
            Connection con = DriverManager.getConnection(url, user, password);
            System.out.println("Connecting to database...");
            return con;
        }catch(Exception e) {
            System.out.println("Connection Error: " + e.getMessage());
            return null;
        }
    }

}

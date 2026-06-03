package org.instantbite.services;

import org.instantbite.dao.UserDAO;
import org.instantbite.model.Food;
import org.instantbite.dao.FoodDAO;
import org.instantbite.dao.OrderDAO;
import org.instantbite.model.Order;
import org.instantbite.model.User;

import java.sql.ResultSet;

public class FoodService {
    FoodDAO foodDAO =  new FoodDAO();
    public void createFood(String name, double price) {
        Food food = new Food(name, price);
        foodDAO.addFood(food);
    }

    public void displayFood() {
        foodDAO.viewFood();
    }

    public void orderFood(int foodId, int userId, int quantity) {
        double price = OrderDAO.getFoodPrice(foodId);
        double total = price * quantity;

        Order order = new Order(foodId, userId, quantity, total);

        OrderDAO.placeOrder(order);

        System.out.println("Total price: $" + total);
        System.out.println("Order has been placed successfully..");
    }

    public void register(String fullName, String email, String password) {
        User user = new User(fullName, email, password);
        UserDAO.addUser(user);

        System.out.println("User registered successfully.");
    }

    public User login(String email, String password) {
        try {
            ResultSet rs = UserDAO.findEmail(email);
                if(rs.next()) {
                    String password2 = rs.getString("password");
                    if(password.equals(password2)) {
                        System.out.println("Login successful.");

                        return new User(
                                rs.getInt("id"),
                                rs.getString("full_name"),
                                rs.getString("email"),
                                password2
                        );
                    }
                }
        }catch(Exception e) {
            System.out.println("Invalid email or password.");
        }
        System.out.println("Invalid Credentials.");
        return null;
    }
}

package org.instantbite.services;

import org.instantbite.model.Food;
import org.instantbite.dao.FoodDAO;
import org.instantbite.dao.OrderDAO;
import org.instantbite.model.Order;

public class FoodService {
    FoodDAO foodDAO =  new FoodDAO();
    public void createFood(String name, double price) {
        Food food = new Food(name, price);
        foodDAO.addFood(food);
    }

    public void displayFood() {
        foodDAO.viewFood();
    }

    public void orderFood(int foodId, int quantity) {
        double price = OrderDAO.getFoodPrice(foodId);
        double total = price * quantity;

        Order order = new Order(foodId, quantity, total);

        OrderDAO.placeOrder(order);

        System.out.println("Total price: " + total);
    }
}

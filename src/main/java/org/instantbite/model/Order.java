package org.instantbite.model;

public class Order {
    private int foodId;
    private int quantity;
    private double total;

    public Order(int foodId, int quantity, double total) {
        this.foodId = foodId;
        this.quantity = quantity;
        this.total = total;
    }

    public int getFoodId() {
        return foodId;
    }

    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
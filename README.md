# FoodApp_JDBC
A Java Food ordering app where user logs in before the can place order.

# Food Ordering System

Overview

A Java console-based Food Ordering System built with JDBC and MySQL. The application allows users to register, log in, browse available food items, place orders, and view their order history.

Features

	•	User Registration
	•	User Login Authentication
	•	Password Hashing
	•	View Available Foods
	•	Place Food Orders
	•	View Order History
	•	Database Persistence with MySQL
	•	JDBC-Based Database Connectivity

Technologies Used

	•	Java
	•	JDBC
	•	MySQL
	•	Maven
	•	BCrypt (Password Hashing)

Project Structure

src/
├── model/
├── dao/
├── service/
├── util/
├── database/
└── main/

pom.xml
README.md

Database Schema

Users Table

CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(100) UNIQUE,
    email VARCHAR(100) UNIQUE,
    password VARCHAR(255)
);

Foods Table

CREATE TABLE foods (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    price DECIMAL(10,2)
);

Orders Table

CREATE TABLE orders (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    food_id INT,
    quantity INT,
    order_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY(user_id) REFERENCES users(id),
    FOREIGN KEY(food_id) REFERENCES foods(id)
);

Setup Instructions

1. Clone the Repository

git clone https://github.com/femmyblaq/FoodApp_JDBC.git

2. Create Database

CREATE DATABASE food_order_db;

3. Configure Database Connection

Create a local configuration file:

db.url=jdbc:mysql://localhost:3306/food_order_db
db.username=root
db.password=your_password

	Do not commit this file to GitHub.

4. Install Dependencies

mvn clean install

5. Run the Application

Run the main class:

Main.java

Sample Flow

1. Register Account
2. Login
3. View Food Menu
4. Select Food
5. Place Order
6. View Order History
7. Logout

Future Improvements

	•	Admin Dashboard
	•	Food Management (CRUD)
	•	Shopping Cart
	•	Payment Integration
	•	Email Notifications
	•	REST API Version using Spring Boot

Author

Your HY Devinton

GitHub: https://github.com/femmyblaq

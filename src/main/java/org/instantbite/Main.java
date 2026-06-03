package org.instantbite;

import org.instantbite.config.DBConnection;
import org.instantbite.model.User;
import org.instantbite.services.FoodService;

import java.sql.Connection;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

public class Main {

    public static void foodApp() {
        FoodService foodService = new FoodService();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nFood APP");
            System.out.println("1. Add Food");
            System.out.println("2. View Foods");
            System.out.println("3. Place Order");
            System.out.println("4. Exit");

            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    scanner.nextLine();
                    System.out.println("Enter Food Name: ");
                    String name = scanner.nextLine();

                    System.out.println("Enter Price: ");
                    double price = scanner.nextDouble();

                    foodService.createFood(name, price);
                    break;
                case 2:
                    foodService.displayFood();
                    break;
                    case 3:
                        foodService.displayFood();
                        System.out.println("Select food from above: ");
                        int foodId = scanner.nextInt();
                        System.out.println("Select quantity: ");
                        int quantity = scanner.nextInt();

            }
        }
    }
    static void main() {
        Scanner scanner = new Scanner(System.in);
        FoodService foodService = new FoodService();

        User currentUser = null;

        while (true) {
            System.out.println("\nFood APP");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. View Foods");
            System.out.println("4. Place Order");
            System.out.println("5. Exit");


            System.out.print("Enter choice: ");
            int select = scanner.nextInt();
            String email;
            String password;

            switch (select) {
                case 1:
                    scanner.nextLine();
                    System.out.println("\n========CREATE A USER========");
                    System.out.print("Enter full name: ");
                    String fullName = scanner.nextLine();
                    System.out.print("Enter email: ");
                    email = scanner.nextLine();
                    System.out.print("Enter password: ");
                    password = scanner.nextLine();

                    foodService.register(fullName, email, password);
                    break;
                case 2:
                    scanner.nextLine();
                    System.out.println("\n======== LOGIN ========");
                    System.out.print("Enter email: ");
                    email = scanner.nextLine();
                    System.out.print("Enter password: ");
                    password = scanner.nextLine();

                   currentUser = foodService.login(email, password);

                   if (currentUser != null) {
                       System.out.println("\n Welcome " + currentUser.getFullName());
                   }else {
                       System.out.println("\nInvalid email or password");
                   }
                    break;
                case 3:
                    System.out.println("==== Available Foods ====");
                    foodService.displayFood();
                    break;
                    case 4:

                        if(currentUser==null) {
                            System.out.println("\nPlease Long in first");

                            break;
                        }
                        foodService.displayFood();

                        System.out.print("Enter food ID: ");
                        int foodId = scanner.nextInt();
                        System.out.println("Select quantity: ");
                        int quantity = scanner.nextInt();

                        foodService.orderFood(foodId, currentUser.getId(), quantity);

                        break;
                        default:
                            System.out.println("Invalid choice");


            }
        }
    }
}

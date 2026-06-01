package org.instantbite;

import org.instantbite.services.FoodService;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        Scanner scanner = new Scanner(System.in);
        FoodService foodService = new FoodService();

        while (true) {
            System.out.println("\nFood APP");
            System.out.println("1. Add Food");
            System.out.println("2. View Foods");
            System.out.println("3. Place Order");
            System.out.println("4. Exit");

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
            }
        }


    }
}

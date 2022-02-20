package ru.rudikov;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int coffeeTank;
        int waterTank;
        int milkTank;

        try {
            coffeeTank = Integer.parseInt(args[0]);
            waterTank = Integer.parseInt(args[1]);
            milkTank = Integer.parseInt(args[2]);
        } catch (Exception e) {
            System.out.println(
                    "Передайте значения объема резервуаров для кофемашины в качестве аргументов при запуске программы!"
            );
            return;
        }

        CoffeeMachine coffeeMachine = new CoffeeMachine(coffeeTank, waterTank, milkTank);
        System.out.println("switching-on... done!");

        CoffeeService service = new CoffeeService(scanner, coffeeMachine);

        while (true) {
            service.runCoffeeMachine();
        }
    }
}

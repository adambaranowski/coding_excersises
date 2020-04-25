package Enum_exercise;

import java.util.Scanner;

public class Pizzeria {
    public static void main(String[] args) {
        System.out.println("Rodzaje pizzy: ");
        for (Pizza pizza: Pizza.values()
             ) {
            System.out.println(pizza);
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Wybierz pizze");
        Pizza pizza = Pizza.valueOf(scanner.nextLine());

        System.out.println("Wybrałeś " + pizza.name());
    }
}

package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Main {

    static DinnerConstructor dc;
    static Scanner scanner;
    static Random rand = new Random();

    public static void main(String[] args) {
        dc = new DinnerConstructor();
        scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            String command = scanner.nextLine();

            switch (command) {
                case "1":
                    addNewDish();
                    break;
                case "2":
                    generateDishCombo();
                    break;
                case "3":
                    return;
            }
        }
    }

    private static void printMenu() {
        System.out.println("Выберите команду:");
        System.out.println("1 - Добавить новое блюдо");
        System.out.println("2 - Сгенерировать комбинации блюд");
        System.out.println("3 - Выход");
    }

    private static void addNewDish() {
        System.out.println("Введите тип блюда:");
        String dishType = scanner.nextLine();

        if (dc.checkType(dishType)) {

            System.out.println("Введите название блюда:");
            String dishName = scanner.nextLine();

            if (dc.menu.containsKey(dishType)) {
                dc.menu.get(dishType).add(dishName);
            } else {
                ArrayList<String> dishes = new ArrayList<>();
                dishes.add(dishName);
                dc.menu.put(dishType, dishes);
            }
        }
    }

    private static void generateDishCombo() {
        System.out.println("Начинаем конструировать обед...");

        System.out.println("Введите количество наборов, которые нужно сгенерировать:");
        int numberOfCombos = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Вводите типы блюда, разделяя символом переноса строки (enter). Для завершения ввода введите пустую строку");
        String nextType;

        ArrayList<String> dishTypes = new ArrayList<>();

        while (true) {
            nextType = scanner.nextLine();
            if (nextType.isEmpty()) {
                break;
            }

            if (dc.menu.containsKey(nextType)) {
                dishTypes.add(nextType);
            } else {
                System.out.println("Такого типа блюда нет в меню.");
            }
        }

        for (int i = 0; i < numberOfCombos; i++) {
            String[] combo = new String[dishTypes.size()];
            for (int j = 0; j < dishTypes.size(); j++) {
                ArrayList<String> dishList = dc.menu.get(dishTypes.get(j));
                int randomIndex = rand.nextInt(dishList.size());
                String dish = dishList.get(randomIndex);
                combo[j] = dish;
            }
            System.out.printf("Комбо %d:\n", i+1);
            printCombo(combo);
        }
    }

    public static void printCombo(String[] combo) {
        for (String s : combo) {
            System.out.printf("- %s\n", s);
        }
    }
}

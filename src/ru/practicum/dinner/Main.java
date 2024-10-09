package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static DinnerConstructor dc;
    static Scanner scanner;

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

        System.out.println("Введите название блюда:");
        String dishName = scanner.nextLine();

        dc.addNewDish(dishType, dishName);
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

            if (dc.hasDishType(nextType)) {
                dishTypes.add(nextType);
            }
        }

        for (int i = 0; i < numberOfCombos; i++) {
            String[] dishCombo = dc.generateRandomDishCombo(dishTypes);
            System.out.printf("Комбо %d:\n", i+1);
            printCombo(dishCombo);
        }
    }

    public static void printCombo(String[] dishCombo) {
        for (String dish : dishCombo) {
            System.out.printf("- %s\n", dish);
        }
    }
}

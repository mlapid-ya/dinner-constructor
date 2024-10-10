package ru.practicum.dinner;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Random;

public class DinnerConstructor {

    private final HashMap<String, ArrayList<String>> menu = new HashMap<>();

    public boolean isValidDishType(String dishType) {
        switch (dishType) {
            case "Первое", "Второе", "Напиток" -> {
                return true;
            }
            default -> {
                System.out.println("Такой тип блюда не существует.");
                return false;
            }
        }
    }

    public boolean hasDishType(String dishType) {
        if (menu.containsKey(dishType)) {
            return true;
        } else {
            System.out.println("Такого типа блюда нет в меню.");
            return false;
        }
    }

    public void addNewDish(String dishType, String dishName) {
        if (isValidDishType(dishType)) {
            if (!menu.containsKey(dishType)) {
                menu.put(dishType, new ArrayList<>());
                menu.get(dishType).add(dishName);
            } else {
                menu.get(dishType).add(dishName);
            }
        }
    }

    public String[] generateRandomDishCombo(ArrayList<String> dishTypes) {

        Random rand = new Random();
        String[] dishCombo = new String[dishTypes.size()];

        for (int j = 0; j < dishTypes.size(); j++) {
            ArrayList<String> dishList = this.menu.get(dishTypes.get(j));
            int randomIndex = rand.nextInt(dishList.size());
            String dish = dishList.get(randomIndex);
            dishCombo[j] = dish;
        }
        return dishCombo;
    }

    public void printDishCombo(String[] dishCombo) {
        for (String dish : dishCombo) {
            System.out.printf("- %s\n", dish);
        }
    }

}

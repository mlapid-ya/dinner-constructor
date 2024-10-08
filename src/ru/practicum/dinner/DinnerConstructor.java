package ru.practicum.dinner;

import java.util.HashMap;
import java.util.ArrayList;

public class DinnerConstructor {

    HashMap<String, ArrayList<String>> menu;

    public DinnerConstructor() {
        menu = new HashMap<>();
    }

    public boolean checkType(String type) {
        switch (type) {
            case "Первое", "Второе", "Напиток" -> {
                return true;
            }
            default -> {
                System.out.println("Такой тип блюда не существует.");
                return false;
            }
        }
    }

}

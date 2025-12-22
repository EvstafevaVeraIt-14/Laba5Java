package ru.evstafeva.main;

import java.util.*;

public class ListInsertDemo {

    public static <T> boolean insertCopyAfter(List<T> list, T element) {
        if (!list.contains(element)) {
            return false;
        }

        int index = list.indexOf(element);
        List<T> copy = new ArrayList<>(list);
        list.addAll(index + 1, copy);

        return true;
    }


    public static void demonstrate() {

        System.out.println("1. Целые числа:");
        List<Integer> intList = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        System.out.println("Созданный список: " + intList);
        System.out.println("Вставка после 2:");

        if (insertCopyAfter(intList, 2)) {
            System.out.println("Результат: " + intList);
        } else {
            System.out.println("Элемент 2 не найден");
        }

        System.out.println("\n2. Строки:");
        List<String> strList = new ArrayList<>(Arrays.asList("A", "B", "C", "D"));
        System.out.println("Созданный список: " + strList);
        System.out.println("Вставка после C:");

        if (insertCopyAfter(strList, "C")) {
            System.out.println("Результат: " + strList);
        } else {
            System.out.println("Элемент C не найден");
        }

        System.out.println("\n3. Вещественные числа:");
        List<Double> doubleList = new ArrayList<>(Arrays.asList(1.5, 2.7, 3.1));
        System.out.println("Созданный список: " + doubleList);
        System.out.println("Вставка после 2.7:");

        if (insertCopyAfter(doubleList, 2.7)) {
            System.out.println("Результат: " + doubleList);
        } else {
            System.out.println("Элемент 2.7 не найден");
        }

        System.out.println("\n4. Демонстрация с отсутствующим элементом:");
        List<Character> charList = new ArrayList<>(Arrays.asList('a', 'b', 'c'));
        System.out.println("Список: " + charList);
        System.out.println("Попытка вставки после 'z' (которого нет в списке):");

        if (insertCopyAfter(charList, 'z')) {
            System.out.println("Результат: " + charList);
        } else {
            System.out.println("Элемент 'z' не найден в списке. Список не изменился: " + charList);
        }
    }

}

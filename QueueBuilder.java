package ru.evstafeva.queue;

import ru.evstafeva.error.Check;
import java.util.*;

public class QueueBuilder {

    public static <T> Queue<T> buildQueueFromList(List<T> list) {
        Queue<T> queue = new LinkedList<>();

        if (list == null || list.isEmpty()) {
            return queue;
        }

        queue.addAll(list);

        List<T> reversed = new ArrayList<>(list);
        Collections.reverse(reversed);

        if (!reversed.isEmpty()) {
            reversed.remove(0);
        }

        queue.addAll(reversed);

        return queue;
    }

    public static void demonstrateWithUserInput() {
        Check check = new Check();
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Построение очереди по списку ===");
        System.out.println("Правило: список + обратный список без первого элемента");
        System.out.println("Пример: [1, 2, 3] -> [1, 2, 3, 3, 2, 1]\n");

        System.out.print("Введите количество элементов в списке: ");
        int count = check.checkAnInteger();

        while (count < 1) {
            System.out.print("Количество должно быть положительным. Введите снова: ");
            count = check.checkAnInteger();
        }

        System.out.println("Выберите тип элементов:");
        System.out.println("1. Целые числа");
        System.out.println("2. Строки");
        System.out.println("3. Вещественные числа");
        System.out.print("Ваш выбор: ");

        int typeChoice = check.checkAnInteger();
        while (typeChoice < 1 || typeChoice > 3) {
            System.out.print("Введите 1, 2 или 3: ");
            typeChoice = check.checkAnInteger();
        }

        switch (typeChoice) {
            case 1:
                demonstrateIntegerQueue(check, count);
                break;
            case 2:
                demonstrateStringQueue(check, count);
                break;
            case 3:
                demonstrateDoubleQueue(check, count);
                break;
        }

        scanner.close();
    }

    /**
     * Демонстрация с целыми числами
     */
    private static void demonstrateIntegerQueue(Check check, int count) {
        List<Integer> list = new ArrayList<>();

        System.out.println("\nВведите " + count + " целых чисел:");
        for (int i = 0; i < count; i++) {
            System.out.print("Элемент " + (i + 1) + ": ");
            int number = check.checkAnInteger();
            list.add(number);
        }

        Queue<Integer> queue = buildQueueFromList(list);

        System.out.println("\n=== Результат ===");
        System.out.println("Исходный список: " + list);
        System.out.println("Построенная очередь: " + queue);
        System.out.println("Размер очереди: " + queue.size());

    }

    private static void demonstrateStringQueue(Check check, int count) {
        List<String> list = new ArrayList<>();

        System.out.println("\nВведите " + count + " строк (только буквы):");
        for (int i = 0; i < count; i++) {
            System.out.print("Элемент " + (i + 1) + ": ");
            String str = check.checkString();
            list.add(str);
        }

        Queue<String> queue = buildQueueFromList(list);

        System.out.println("\n=== Результат ===");
        System.out.println("Исходный список: " + list);
        System.out.println("Построенная очередь: " + queue);
        System.out.println("Размер очереди: " + queue.size());

    }

    /**
     * Демонстрация с вещественными числами
     */
    private static void demonstrateDoubleQueue(Check check, int count) {
        List<Double> list = new ArrayList<>();

        System.out.println("\nВведите " + count + " вещественных чисел:");
        for (int i = 0; i < count; i++) {
            System.out.print("Элемент " + (i + 1) + ": ");
            double number = check.checkDouble();
            list.add(number);
        }

        Queue<Double> queue = buildQueueFromList(list);

        System.out.println("\n=== Результат ===");
        System.out.println("Исходный список: " + list);
        System.out.println("Построенная очередь: " + queue);
        System.out.println("Размер очереди: " + queue.size());

    }

}

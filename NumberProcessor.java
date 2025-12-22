package ru.evstafeva.streams;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.AbstractMap.SimpleEntry;

public class NumberProcessor {

    public static Map<String, List<String>> process(String filePath) throws IOException {
        List<String> lines = readLinesFromFile(filePath);
        return processLines(lines);
    }

    private static List<String> readLinesFromFile(String filePath) throws IOException {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        }
        return lines;
    }

    public static Map<String, List<String>> processLines(List<String> lines) {
        return lines.stream()
                .map(str -> str.split(":", 2)) // разбиваем строку на имя и номер
                .filter(parts -> parts.length == 2) // должны быть обе части
                .filter(parts -> {
                    String name = parts[0].trim();
                    String number = parts[1].trim();
                    return !name.isEmpty() && !number.isEmpty(); // обе части не пустые
                })
                .map(parts -> { // нормализуем имя: первая буква заглавная, остальные строчные
                    String name = parts[0].trim();
                    String number = parts[1].trim();

                    if (!name.isEmpty()) {
                        name = Character.toUpperCase(name.charAt(0)) +
                                name.substring(1).toLowerCase();
                    }

                    return new SimpleEntry<>(number, name);
                })
                .collect(Collectors.groupingBy( // группируем по номеру
                        SimpleEntry::getKey,
                        Collectors.mapping(
                                SimpleEntry::getValue,
                                Collectors.toList()
                        )
                ));
    }

    public static String formatResult(Map<String, List<String>> result) {
        StringBuilder output = new StringBuilder("[");
        boolean firstGroup = true;

        for (Map.Entry<String, List<String>> entry : result.entrySet()) {
            if (!firstGroup) {
                output.append(", ");
            }
            output.append(entry.getKey())
                    .append(":[")
                    .append(String.join(", ", entry.getValue()))
                    .append("]");
            firstGroup = false;
        }
        output.append("]");

        return output.toString();
    }

    public static void printResult(Map<String, List<String>> result) {
        System.out.println("\nРезультат группировки:");

        if (result.isEmpty()) {
            System.out.println("Нет данных для отображения");
            return;
        }

        // Сортируем по номеру
        result.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry -> {
                    System.out.println("Номер " + entry.getKey() + ":");
                    entry.getValue().forEach(name -> System.out.println("  - " + name));
                });

        System.out.println("\nФорматированный вывод: " + formatResult(result));
    }


}
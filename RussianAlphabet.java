package ru.evstafeva.alpha;

import java.io.*;
import java.util.*;

public class RussianAlphabet {
    private static final String RUSSIAN_ALPHABET = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
    private final Set<Character> allLetters;
    private final Set<Character> discoveredLetters;
    private String filePath;

    public RussianAlphabet() {
        this.allLetters = new TreeSet<>();
        this.discoveredLetters = new TreeSet<>();
        initializeAlphabet();
    }

    public RussianAlphabet(String filePath) {
        this();
        this.filePath = filePath;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    private void initializeAlphabet() {
        for (char c : RUSSIAN_ALPHABET.toCharArray()) {
            allLetters.add(c);
        }
    }

    // Метод для анализа файла
    public void analyzeFile(String filePath) throws IOException {
        this.filePath = filePath;
        analyzeFile();
    }

    public void analyzeFile() throws IOException {
        // Очищаем предыдущие результаты
        discoveredLetters.clear();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                processLine(line.toLowerCase());
            }
        }
    }

    // Обработка одной строки
    private void processLine(String line) {
        for (char c : line.toCharArray()) {
            if (allLetters.contains(c)) {
                discoveredLetters.add(c);
            }
        }
    }

    // Получить отсутствующие буквы
    public Set<Character> getMissingLetters() {
        Set<Character> missingLetters = new TreeSet<>(allLetters);
        missingLetters.removeAll(discoveredLetters);
        return missingLetters;
    }

    // Получить количество отсутствующих букв
    public int getMissingLettersCount() {
        return getMissingLetters().size();
    }

}

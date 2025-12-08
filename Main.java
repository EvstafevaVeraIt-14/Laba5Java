package ru.evstafeva.main;

import ru.evstafeva.error.Check;
import ru.evstafeva.fraction.CachedFraction;
import ru.evstafeva.cats.Cat;
import ru.evstafeva.cats.Funs;
import ru.evstafeva.cats.CountMeow;
import ru.evstafeva.line.Point;
import ru.evstafeva.line.Polyline;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeSet;
import java.util.Set;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        int choice, choice1;
        String file, file2;
        boolean subtask;
        Scanner scanner = new Scanner(System.in);
        Check check = new Check();
        while (true) {
            System.out.println("\nНомер задания:");
            System.out.println("1 - Шаблоны");
            System.out.println("2 - Количество мяуканий");
            System.out.println("3 - 3.4: Список");
            System.out.println("4 - 4.6: Мап");
            System.out.println("5 - 5.8: Сет");
            System.out.println("6 - 6.2: Очередь");
            System.out.println("7 - Стримы");
            System.out.println("0 - Выход");
            System.out.print("Ваш выбор: ");

            choice = check.checkAnInteger();
            switch (choice) {
                case 1: {
                    System.out.println("\nВ класс Дробь, добавить интерфейс на два метода: получение вещественного значения, установка\n" +
                            "числителя и установка знаменателя.\n" +
                            "Сгенерировать такую версию дроби, которая будет кэшировать вычисление вещественного\n" +
                            "значения.\n" +
                            "Если раннее в вашем варианте не было Дроби, то создайте сущность Дробь со следующими\n" +
                            "особенностями:\n" +
                            "• Имеет числитель: целое число\n" +
                            "• Имеет знаменатель: целое число\n" +
                            "• Дробь может быть создана с указанием числителя и знаменателя\n" +
                            "• Может вернуть строковое представление вида “числитель/знаменатель”\n" +
                            "• Необходимо корректно обрабатывать отрицательные значения. Учтите, что знаменатель не может\n" +
                            "быть отрицательным.\n" +
                            "• Переопределите метод сравнения объектов по состоянию таким образом, чтобы две дроби\n" +
                            "считались одинаковыми тогда, когда у них одинаковые значения числителя и знаменателя.\n");

                    CachedFraction fraction1 = new CachedFraction(1, 2);
                    CachedFraction fraction2 = new CachedFraction(7, 28);
                    CachedFraction fraction3 = new CachedFraction(1, 2);
                    CachedFraction fraction4 = new CachedFraction(-9, 10);
                    CachedFraction fraction5 = new CachedFraction(70, -5);

                    System.out.println("Дробь 1: " + fraction1 + " = " + fraction1.getDecimalValue());
                    System.out.println("Дробь 2: " + fraction2 + " = " + fraction2.getDecimalValue());
                    System.out.println("Дробь 3: " + fraction3 + " = " + fraction3.getDecimalValue());
                    System.out.println("Дробь 4: " + fraction4 + " = " + fraction4.getDecimalValue());
                    System.out.println("Дробь 5: " + fraction5 + " = " + fraction5.getDecimalValue());

                    System.out.println("\nСравнение дробей:");
                    System.out.println("Дробь 1 и дробь 2 равны?: " + fraction1.equals(fraction2));
                    System.out.println("Дробь 1 и дробь 3 равны?: " + fraction1.equals(fraction3));

                    break;
                }
                case 2: {
                    System.out.println("\nКоличество мяуканий.\n" +
                            "Необходимо воспользоваться классом Кот и методом принимающим всех мяукающих из задачи 2.5.4.\n" +
                            "Необходимо таким образом передать кота в указанный метод, что бы после окончания его работы\n" +
                            "узнать сколько раз мяукал кот за время его работы. На рисунке показан пример работы. Перед вызовом\n" +
                            "метода создаем кота, отправляем ссылку на кота в метод, после окончания его работы выводим\n" +
                            "количество мяуканий на экран. Кота изменять нельзя.\n" +
                            "Если раннее в вашем варианте не было Кота, то создайте\n" +
                            "1. сущность Кот, которая описывается следующим образом:\n" +
                            "• Имеет Имя (строка)\n" +
                            "• Для создания необходимо указать имя кота.\n" +
                            "• Может быть приведен к текстовой форме вида: “кот: Имя”\n" +
                            "• Может помяукать, что приводит к выводу на экран следующего текста: “Имя: мяу!”,\n" +
                            "вызвать мяуканье можно без параметров.\n" +
                            "2. интерфейс Мяуканье: разработайте метод, который принимает набор объектов способных\n" +
                            "мяукать и вызывает мяуканье у каждого объекта. Мяукающие объекты должны иметь метод со\n" +
                            "следующей сигнатурой:\n" +
                            "public void meow();.\n");

                    Cat cat = new Cat("Чуча");

                    CountMeow CatAndMeowing = new CountMeow(cat); // создаем декоратор для подсчета
                    Funs.meowCare(CatAndMeowing);
                    Funs.meowCare(CatAndMeowing);
                    Funs.meowCare(CatAndMeowing);
                    Funs.meowCare(CatAndMeowing);
                    if (CatAndMeowing.getCount()%10==1 || CatAndMeowing.getCount()%10==0 || CatAndMeowing.getCount()%100==12 || CatAndMeowing.getCount()%100==13 ||
                            CatAndMeowing.getCount()%100==14 || CatAndMeowing.getCount()%100==15 || CatAndMeowing.getCount()%100==16 || CatAndMeowing.getCount()%100==17 ||
                            CatAndMeowing.getCount()%100==18 || CatAndMeowing.getCount()%100==19) {
                        System.out.println("Кот мяукал " + CatAndMeowing.getCount() + " раз");
                    } else {
                        System.out.println("Кот мяукал " + CatAndMeowing.getCount() + " раза");
                    }


                    break;
                }
                case 3: {
                    System.out.println("\nСоставить программу, которая вставляет в список L за первым вхождением элемента E все\n" +
                            "элементы списка L, если E входит в L.\n");

                    System.out.println("1. Целые числа:");
                    UsersList<Integer> intList = new UsersList<>();
                    intList.add(1);
                    intList.add(2);
                    intList.add(3);
                    intList.add(4);

                    System.out.println("Созданный список: " + intList);
                    System.out.println("Вставка после 2:");
                    intList.insertCopyAfter(2);
                    System.out.println("Результат: " + intList);

                    System.out.println("\n2. Строки:");
                    UsersList<String> strList = new UsersList<>();
                    strList.add("A");
                    strList.add("B");
                    strList.add("C");
                    strList.add("D");

                    System.out.println("Созданный список: " + strList);
                    System.out.println("Вставка после С:");
                    strList.insertCopyAfter("C");
                    System.out.println("Результат: " + strList);

                    System.out.println("\n3. Вещественные числа:");
                    UsersList<Double> doubleList = new UsersList<>(List.of(1.5, 2.7, 3.1));
                    System.out.println("Созданный список: " + doubleList);
                    System.out.println("Вставка после 2.7:");
                    doubleList.insertCopyAfter(2.7);
                    System.out.println("Результат: " + doubleList);
                    break;
                }
                case 4: {
                    System.out.println("\nВ некотором вузе абитуриенты проходили предварительное тестирование, по результатам\n" +
                            "которого они могут быть допущены к сдаче вступительных экзаменов в первом потоке.\n" +
                            "Тестирование проводится по трём предметам, по каждому предмету абитуриент может набрать\n" +
                            "от 0 100 баллов. При этом к сдаче экзаменов в первом потоке допускаются абитуриенты,\n" +
                            "набравшие по результатам тестирования не менее 30 баллов по каждому из трёх предметов,\n" +
                            "причём сумма баллов должна быть не менее 140. На вход программы подаются сведения о\n" +
                            "результатах предварительного тестирования. Известно, что общее количество участников\n" +
                            "тестирования не превосходит 500.\n" +
                            "В первой строке вводится количество абитуриентов, принимавших участие в тестировании, N.\n" +
                            "Далее следуют N строк, имеющих следующий формат:\n" +
                            "<Фамилия><Имя><Баллы>\n" +
                            "Здесь <Фамилия> – строка, состоящая не более чем из 20 символов; <Имя> – строка, состоящая не\n" +
                            "более чем из 15 символов, <Баллы> – строка, содержащая два целых числа, разделенных\n" +
                            "пробелом – баллы, полученные на тестировании по каждому из трёх предметов. При этом\n" +
                            "<Фамилия> и <Имя>, <Имя> и <Баллы> разделены одним пробелом. Пример входной строки:\n" +
                            "Романов Вельямин 48 39 55\n" +
                            "Напишите программу, которая будет выводить на экран фамилии и имена абитуриентов,\n" +
                            "допущенных к сдаче экзаменов в первом потоке. При этом имена и фамилии можно\n" +
                            "выводить в произвольном порядке.\n");

                    System.out.print("Введите количество абитуриентов: ");
                    int n = check.checkAnInteger();

                    if (n > 500) {
                        System.out.println("Количество абитуриентов не должно превышать 500");
                        break;
                    }

                    List<String> admitted = new ArrayList<>();

                    System.out.println("Введите данные абитуриентов:");
                    for (int i = 0; i < n; i++) {
                        System.out.print("Абитуриент " + (i + 1) + ": ");

                        String lastName = check.checkString();
                        String firstName = check.checkString();

                        int score1 = check.checkScore("балл1");
                        int score2 = check.checkScore("балл2");
                        int score3 = check.checkScore("балл3");

                        if (score1 >= 30 && score2 >= 30 && score3 >= 30 &&
                                (score1 + score2 + score3) >= 140) {
                            admitted.add(lastName + " " + firstName);
                        }
                    }

                    System.out.println("\nДопущенные абитуриенты:");
                    if (admitted.isEmpty()) {
                        System.out.println("Нет допущенных абитуриентов");
                    } else {
                        for (String name : admitted) {
                            System.out.println(name);
                        }
                    }
                    break;
                }
                case 5: {
                    System.out.println("\nФайл содержит текст на русском языке. Сколько букв русского алфавита не встречается в этом\n" +
                            "тексте?\n");

                    file = "C:\\Users\\HONOR\\IdeaProjects\\Laba5\\src\\ru\\evstafeva\\main\\task5.txt";

                    try {
                        String alphabet = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
                        Set<Character> allLetters = new TreeSet<>(); // используем TreeSet для сохранения алфавитного порядка
                        for (char c : alphabet.toCharArray()) {
                            allLetters.add(c);
                        }

                        Set<Character> discoveredLetters = new TreeSet<>(); //найденные в тексте буквы

                        BufferedReader reader = new BufferedReader(new FileReader(file));
                        String line;
                        while ((line = reader.readLine()) != null) {
                            line = line.toLowerCase(); // нижний регистр
                            for (char c : line.toCharArray()) {
                                if (allLetters.contains(c)) { // если является русской буквой
                                    discoveredLetters.add(c);
                                }
                            }
                        }
                        reader.close();

                        Set<Character> undiscoveredLetters = new TreeSet<>(allLetters); // отсутствующие буквы
                        undiscoveredLetters.removeAll(discoveredLetters); //удаляем совпадения одного множества из другого

                        System.out.println("Отсутствующие буквы: " + undiscoveredLetters);
                        System.out.println("Количество: " + undiscoveredLetters.size());

                    } catch (IOException e) {
                        System.out.println("Ошибка при чтении файла: " + e.getMessage());
                    }
                    break;
                }
                case 6: {
                    System.out.println("По списку L построить очередь (например, по списку из элементов 1, 2, 3 требуется построить\n" +
                            "очередь из элементов 1, 2, 3, 3, 2, 1).");

                    System.out.println("\nОчередь с целыми числами:\n");
                    List<Integer> numbers = Arrays.asList(1, 3, 5, 7);
                    MyQueue<Integer> intQueue = new MyQueue<>(numbers);

                    System.out.println("Исходный список: " + numbers);
                    System.out.println("Результирующая очередь: " + intQueue);


                    System.out.println("Очередь со строками:\n");
                    List<String> strings = Arrays.asList("A", "B", "C", "D", "B", "F", "D");
                    MyQueue<String> stringQueue = new MyQueue<>(strings);

                    System.out.println("Исходный список: " + strings);
                    System.out.println("Результирующая очередь: " + stringQueue);

                    break;
                }
                case 7: {
                    subtask = true;
                    while (subtask) {
                        System.out.println("\nНомер подзадания:");
                        System.out.println("1 - Ломанная линия");
                        System.out.println("2 - Люди и номера");
                        System.out.print("Ваш выбор: ");
                        choice1 = check.checkAnInteger();
                        switch (choice1) {
                            case 1: {
                                System.out.println("Необходимо написать стрим:\n" +
                                        "Дан набор объектов типа Point, необходимо взять все Point в разных координатах, убрать с\n" +
                                        "одинаковыми X,Y, отсортировать по X, отрицательные Y сделать положительными и собрать это\n" +
                                        "все в ломаную (объект типа Polyline)\n" +
                                        "Если раннее в вашем варианте не было задание с классом Point и Polyline, то написать их:\n" +
                                        "1. класс Point:\n" +
                                        "• Координата Х: число.\n" +
                                        "• Координата Y: число.\n" +
                                        "• Может возвращать текстовое представление вида “{X;Y}”.\n" +
                                        "2. класс Line (Линия), расположенная на двумерной плоскости, которая описывается:\n" +
                                        "• Координата начала: Точка\n" +
                                        "• Координата конца: Точка\n" +
                                        "• Может возвращать текстовое представление вида “Линия от {X1;Y1} до {X2;Y2}”\n" +
                                        "3. класс Polyline (Ломаная), которая будет представлять собой ломаную линию. Ломаная\n" +
                                        "линия представляет собой набор следующих характеристик:\n" +
                                        "• Имеет массив Точек, через которые линия проходит.\n" +
                                        "• Может быть приведена к строковой форме вида “Линия [Т1,T2,…,TN]”, где TN – это\n" +
                                        "результат приведения к строке Точки с номером N\n");

                                List<Point> points = Arrays.asList(
                                        new Point(1, 2),
                                        new Point(3, -4),
                                        new Point(1, 2),
                                        new Point(5, 6),
                                        new Point(-2, -3),
                                        new Point(0, -1),
                                        new Point(5, 6)
                                );

                                System.out.println("Исходные точки: " + points);

                                // Стрим для обработки точек
                                Polyline polyline = points.stream()
                                        .distinct() // удаление дубликатов
                                        .sorted(Comparator.comparing(Point::getX)) // сортировка по X
                                        .map(Point::makeYPositive) // преобразование Y в положительные
                                        .collect(Collectors.collectingAndThen(
                                                Collectors.toList(),
                                                Polyline::new // сбор в Polyline
                                        ));

                                System.out.println("Результирующая ломаная: " + polyline);
                                break;
                            }
                            case 2: {
                                try {
                                    String filePath = "C:\\Users\\HONOR\\IdeaProjects\\Laba5\\src\\ru\\evstafeva\\main\\task7.txt";

                                    // Чтение всех строк из файла
                                    List<String> lines = new ArrayList<>();
                                    BufferedReader reader = new BufferedReader(new FileReader(filePath));
                                    String line;
                                    while ((line = reader.readLine()) != null) {
                                        lines.add(line);
                                    }
                                    reader.close();

                                    System.out.println("Исходные данные из файла:");
                                    lines.forEach(System.out::println);
                                    System.out.println();

                                    // Обработка стримом
                                    Map<String, List<String>> result = lines.stream()
                                            .map(str -> str.split(":", 2))// разбиваем строку на имя и номер c
                                            .filter(parts -> parts.length == 2)// должны быть обе части и обе не пустые
                                            .filter(parts -> {
                                                String name = parts[0].trim();
                                                String number = parts[1].trim();
                                                return !name.isEmpty() && !number.isEmpty();
                                            })
                                            .map(parts -> { // обрабатываем каждую запись: первая буква заглавная, остальные строчные
                                                String name = parts[0].trim();
                                                String number = parts[1].trim();
                                                if (name.length() > 0) {
                                                    name = Character.toUpperCase(name.charAt(0)) +
                                                            name.substring(1).toLowerCase();
                                                }

                                                return new AbstractMap.SimpleEntry<>(number, name);
                                            })
                                            .collect(Collectors.groupingBy( // группируем по номеру
                                                    Map.Entry::getKey,
                                                    Collectors.mapping(
                                                            Map.Entry::getValue,
                                                            Collectors.toList()
                                                    )
                                            ));

                                    System.out.println("Результат группировки:");
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

                                    System.out.println(output.toString());

                                } catch (IOException e) {
                                    System.out.println("Ошибка при чтении файла: " + e.getMessage());
                                }
                            }

                        }
                    }
                    break;
                }
                case 0: {
                    System.out.println("Выход из программы");
                    return;
                }
                default:
                    System.out.println("Неверный выбор, попробуйте снова");
            }
        }
    }
}
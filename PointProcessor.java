package ru.evstafeva.streams;

import ru.evstafeva.error.Check;

import java.util.*;
import java.util.stream.Collectors;
import ru.evstafeva.line.*;

public class PointProcessor {

    public static Polyline processPoints(List<Point> points) {
        return points.stream()
                .distinct() // удаление дубликатов
                .sorted(Comparator.comparing(Point::getX)) // сортировка по X
                .map(Point::makeYPositive) // преобразование Y в положительные
                .collect(Collectors.collectingAndThen(
                        Collectors.toList(),
                        Polyline::new // сбор в Polyline
                ));
    }

    public static void demonstrate() {
        Check check = new Check();

        System.out.println("Создание ломаной из точек:");

        List<Point> points = new ArrayList<>();

        System.out.print("Сколько точек создать? ");
        int count = check.checkAnInteger();

        while (count < 1) {
            System.out.print("Количество должно быть положительным. Введите снова: ");
            count = check.checkAnInteger();
        }

        for (int i = 0; i < count; i++) {
            System.out.println("\nТочка " + (i + 1) + ":");

            System.out.print("  X = ");
            double x = check.checkDouble();

            System.out.print("  Y = ");
            double y = check.checkDouble();

            points.add(new Point(x, y));
        }

        System.out.println("\nИсходные точки:");
        for (int i = 0; i < points.size(); i++) {
            Point p = points.get(i);
            System.out.println("  " + (i + 1) + ". " + p);
        }

        Polyline polyline = processPoints(points);

        System.out.println("\nРезультирующая ломаная:");
        System.out.println("  " + polyline);
        System.out.println("  Количество точек: " + polyline.getPointCount());

    }

}
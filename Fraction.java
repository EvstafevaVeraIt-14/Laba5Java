package ru.evstafeva.fraction;

import java.util.Objects;

public class Fraction implements FractionMethods {
    private int numerator;
    private int denominator;

    // Конструкторы
    public Fraction(int numerator, int denominator) {
        setNumeratorAndDenominator(numerator, denominator);
    }

    public Fraction() {
        this(0, 1);
    }

    // Реализация методов интерфейса
    @Override
    public double getDecimalValue() {
        return (double) numerator / denominator;
    }

    @Override
    public void setNumeratorAndDenominator(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Знаменатель не может быть равен 0");
        }

        // Нормализация: знаменатель всегда положительный
        if (denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }

        this.numerator = numerator;
        this.denominator = denominator;
    }

    // Геттеры (не часть интерфейса!)
    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    // Сеттеры (не часть интерфейса, кроме общего метода)
    public void setNumerator(int numerator) {
        setNumeratorAndDenominator(numerator, this.denominator);
    }

    public void setDenominator(int denominator) {
        setNumeratorAndDenominator(this.numerator, denominator);
    }

    // Остальные методы (toString, equals, hashCode) без изменений
    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Fraction other = (Fraction) obj;
        // Сравниваем в нормализованном виде
        Fraction reducedThis = this.reduce();
        Fraction reducedOther = other.reduce();

        return reducedThis.numerator == reducedOther.numerator &&
                reducedThis.denominator == reducedOther.denominator;
    }

    @Override
    public int hashCode() {
        Fraction reduced = this.reduce();
        return Objects.hash(reduced.numerator, reduced.denominator);
    }

    // Вспомогательные методы
    public Fraction reduce() {
        int gcd = gcd(Math.abs(numerator), denominator);
        return new Fraction(numerator / gcd, denominator / gcd);
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
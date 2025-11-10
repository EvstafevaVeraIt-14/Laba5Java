package ru.evstafeva.fraction;

import ru.evstafeva.fraction.FractionMethods;

import java.util.Objects; // утилитный класс в Java, который содержит статические методы для работы с объектами

public class Fraction implements FractionMethods {
    private int numerator;      // числитель
    private int denominator;    // знаменатель
    private Double cachedDecimalValue; // кэшированное вещественное значение
    private boolean isCacheValid;      // флаг валидности кэша


    public Fraction(int numerator, int denominator) { // конструктор дроби
        setNumeratorAndDenominator(numerator, denominator);
    }

    public Fraction() { // конструктор по умолчанию
        this(0, 1);
    }

    @Override
    public double getDecimalValue() { //получение вещественного значения
        if (!isCacheValid || cachedDecimalValue == null) { // если кэш невалиден, то пересчитываем значение
            cachedDecimalValue = (double) numerator / denominator;
            isCacheValid = true;
        }
        return cachedDecimalValue;
    }

    @Override
    public void setNumeratorAndDenominator(int numerator, int denominator) { // сеттер из интерфейса
        if (denominator == 0) {
            throw new IllegalArgumentException("Недопустимое значение. Знаменатель не может быть равен 0");
        }

        if (denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }

        this.numerator = numerator;
        this.denominator = denominator;

        invalidateCache(); // при установке инвалидируем кэш
    }

    public void setNumerator(int numerator) { // сеттер числителя
        setNumeratorAndDenominator(numerator, this.denominator);
    }

    public void setDenominator(int denominator) { //сеттер знаменателя
        setNumeratorAndDenominator(this.numerator, denominator);
    }

    public int getNumerator() { // геттер числителя
        return numerator;
    }

    public int getDenominator() { // геттер знаменателя
        return denominator;
    }

   private void invalidateCache() { // инвалидация значения в кэше (неактуален)
        isCacheValid = false;
        cachedDecimalValue = null;
    }


    @Override
    public String toString() { //троковое представление
        return numerator + "/" + denominator;
    }

    @Override
    public boolean equals(Object obj) { // сравнение дробей по числителю и знаменателю
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Fraction other = (Fraction) obj;
        return numerator == other.numerator && denominator == other.denominator;
    }

    @Override
    public int hashCode() { //хэш-код
        return Objects.hash(numerator, denominator);
    }

}

package ru.evstafeva.cats;

public class Cat implements Meowable {
    private final String name;

    public Cat(String name) { // конструктор
        this.name = name;
    }

    @Override
    public void meow() { // мяуканье из интерфейса
        System.out.println(name + ": мяу!");
    }

    @Override
    public String toString() { // вывод
        return "кот: " + name;
    }
}

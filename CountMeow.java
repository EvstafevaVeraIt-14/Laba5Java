package ru.evstafeva.cats;

public class CountMeow implements Meowable {
    private final Cat cat;
    private int count;

    public CountMeow(Cat cat) {
        this.cat = cat;
        this.count = 0;
    }

    @Override
    public void meow() {
        cat.meow();
        count++;
    }

    public int getCount() {
        return count;
    }
}

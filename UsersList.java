package ru.evstafeva.main;

import java.util.ArrayList;
import java.util.List;

public class UsersList<T> {
    private List<T> items;

    public UsersList() {
        this.items = new ArrayList<>();
    }

    public UsersList(List<T> initialList) {
        this.items = new ArrayList<>(initialList);
    }

    public void insertCopyAfter(T element) {
        int index = items.indexOf(element);
        if (index != -1) {
            List<T> copy = new ArrayList<>(items);
            items.addAll(index + 1, copy);
        }
    }

    public void add(T item) {
        items.add(item);
    }

    public T get(int index) {
        return items.get(index);
    }

    public int size() {
        return items.size();
    }

    public boolean contains(T item) {
        return items.contains(item);
    }

    @Override
    public String toString() {
        return items.toString();
    }
}
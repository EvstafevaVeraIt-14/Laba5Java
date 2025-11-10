package ru.evstafeva;

import java.util.ArrayList;
import java.util.List;

public class ListWithAnInsert {

    public static <T> void insert(List<T> L, T E) {
        int index = L.indexOf(E); //индекс первого входа элемента, если нет в списке -> -1

        if (index != -1) {
            List<T> copy = new ArrayList<>(L); // создаём копию списка для вставки
            L.addAll(index + 1, copy); //вставляем копию
        }
    }
}

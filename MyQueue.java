package ru.evstafeva.main;

import java.util.LinkedList;
import java.util.List;

public class MyQueue<T> {
        private LinkedList<T> elements; // двусвязный список

        public MyQueue() {
            this.elements = new LinkedList<>();
        }

        public MyQueue(List<T> list) { // конструктор, который строит очередь по списку L в порядке: L + reverse(L)
            this.elements = new LinkedList<>();
            buildQueueFromList(list);
        }

        public void buildQueueFromList(List<T> list) { // метод для построения очереди по списку
            elements.clear();

            for (T element : list) { // добавляем элементы в прямом порядке
                elements.add(element);
            }

            for (int i = list.size() - 1; i >= 0; i--) { // добавляем элементы в обратном порядке
                elements.add(list.get(i));
            }
        }

        public void enqueue(T element) { // добавление элемента в конец очереди
            elements.add(element);
        }

        public T dequeue() { // извлечение элемента из начала очереди
            if (isEmpty()) {
                throw new IllegalStateException("Очередь пуста");
            }
            return elements.removeFirst();
        }

        public boolean isEmpty() { //пПроверка на пустоту
            return elements.isEmpty();
        }

        public int size() { // размер очереди
            return elements.size();
        }

        @Override
        public String toString() { // представление очереди в виде строки
            return elements.toString();
        }
}

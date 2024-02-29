package homework1.myList.impl;

import homework1.myList.MyList;

import java.util.Arrays;

/**
 * Моя реализация двусвязного списка LinkedList.
 *
 * @param <T> тип элементов в списке.
 */
public class MyLinkedList<T> implements MyList<T> {

    /**
     * Указатель на первый узел.
     */
    private Node<T> head;
    /**
     * Указатель на последний узел.
     */
    private Node<T> tail;
    /**
     * Количество элементов в списке.
     */
    private int size;

    /**
     * Создает пустой список.
     */
    public MyLinkedList() {

    }

    /**
     * Вложенный класс "Узел".
     */
    private static class Node<T> {
        T element;
        Node<T> next;
        Node<T> prev;

        /**
         * Создает новый узел.
         *
         * @param element элемент, который будет добавлен в узел.
         */
        Node(T element) {
            this.element = element;
        }

        @Override
        public String toString() {
            return this.element.toString();
        }
    }

    /**
     * Добавляет указанный элемент в конец списка.
     *
     * @param element элемент, который будет добавлен в список.
     * @return true при удачном добавлении элемента.
     */
    @Override
    public boolean add(T element) {
        Node<T> newNode = new Node<>(element);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }

        size++;
        return true;
    }

    /**
     * Вставляет указанный элемент в указанную позицию в списке.
     * Смещает элемент, находящийся в данный момент в этой позиции (если есть),
     * и любые последующие элементы вправо.
     *
     * @param index   индекс, по которому должен быть вставлен указанный элемент.
     * @param element элемент, который должен быть вставлен.
     * @throws IndexOutOfBoundsException если индекс выходит за пределы диапазона (index < 0 || index >= size()).
     */
    @Override
    public void add(int index, T element) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }
        if (index == size) {
            add(element);
            return;
        }
        Node<T> newNode = new Node<>(element);
        if (index == 0) {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        } else {
            Node<T> current = getNode(index);
            newNode.prev = current.prev;
            newNode.next = current;
            current.prev.next = newNode;
            current.prev = newNode;
        }
        size++;
    }

    /**
     * Возвращает элемент находящийся в указанной позиции в списке.
     *
     * @param index индекс возвращаемого элемента.
     * @return элемент в указанной позиции в списке.
     * @throws IndexOutOfBoundsException если индекс выходит за пределы диапазона (index < 0 || index >= size()).
     */
    @Override
    public T get(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> node = getNode(index);
        return node.element;
    }

    /**
     * Удаляет элемент находящийся в указанной позиции в списке.
     * Сдвигает любые последующие элементы влево.
     *
     * @param index индекс элемента, который нужно удалить.
     * @return элемент, который был удален из списка.
     * @throws IndexOutOfBoundsException если индекс выходит за пределы диапазона (index < 0 || index >= size()).
     */
    @Override
    public T remove(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> current = getNode(index);
        T removedElement = current.element;
        if (current == head) {
            head = current.next;
        } else {
            current.prev.next = current.next;
        }
        if (current == tail) {
            tail = current.prev;
        } else {
            current.next.prev = current.prev;
        }
        size--;
        return removedElement;
    }

    /**
     * Удаляет все элементы из списка.
     */
    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * Сортировка списка в естественном порядке.
     */
    @Override
    public void sort() {
        T[] array = (T[]) new Object[size];

        for (int i = 0; i < array.length; i++) {
            array[i] = getNode(i).element;
        }

        Arrays.sort(array);
        clear();
        for (T element : array) {
            add(element);
        }
    }

    /**
     * @return количество элементов в списке.
     */
    @Override
    public int size() {
        return this.size;
    }

    /**
     * Возвращает узел находящийся в указанной позиции в списке.
     *
     * @param index индекс возвращаемого элемента.
     * @return узел находящийся в указанной позиции в списке.
     */
    private Node<T> getNode(int index) {
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        String separator = "";
        for (int i = 0; i < size; i++) {
            sb.append(separator).append(getNode(i));
            separator = ", ";
        }
        sb.append("]");
        return sb.toString();
    }
}

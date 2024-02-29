package homework1.myList.impl;

import homework1.myList.MyList;

import java.util.*;

/**
 * Моя реализация динамического массива ArrayList.
 *
 * @param <T> тип элементов в списке.
 */

public class MyArrayList<T> implements MyList<T> {

    /**
     * Массив типа Т.
     */
    private T[] array;

    /**
     * Количество элементов в списке.
     */
    private int size = 0;

    /**
     * Начальная емкость по умолчанию.
     */
    private final int CAPACITY = 10;

    /**
     * Создает пустой список с емкостью по умолчанию.
     */
    public MyArrayList() {
        array = (T[]) new Object[CAPACITY];
    }

    /**
     * Создает пустой список с указанной начальной емкостью.
     *
     * @param capacity начальная емкость списка.
     * @throws IllegalArgumentException, если указана отрицательная емкость.
     */
    public MyArrayList(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Размер списка не может быть меньше или равен 0");
        } else {
            array = (T[]) new Object[capacity];
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
        if (size == array.length) {
            array = Arrays.copyOf(array, array.length * 3 / 2 + 1);
        }
        array[size++] = element;
        return true;
    }

    /**
     * Вставляет указанный элемент в указанную позицию в списке.
     * Смещает элемент, находящийся в данный момент в этой позиции (если есть),
     * и любые последующие элементы вправо (добавляет единицу к их индексам).
     *
     * @param index   индекс, по которому должен быть вставлен указанный элемент.
     * @param element элемент, который должен быть вставлен.
     * @throws IndexOutOfBoundsException если индекс выходит за пределы диапазона (index < 0 || index > size()).
     */
    @Override
    public void add(int index, T element) {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException();
        }
        if (size == array.length) {
            array = Arrays.copyOf(array, array.length * 3 / 2 + 1);
        }
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = element;
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
        return array[index];
    }

    /**
     * Удаляет элемент находящийся в указанной позиции в списке.
     * Сдвигает любые последующие элементы влево (вычитает единицу из их индексов).
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
        T element = array[index];
        System.arraycopy(array, index + 1, array, index, size - index - 1);
        size--;
        return element;
    }

    /**
     * Удаляет все элементы из списка.
     */
    @Override
    public void clear() {
        array = (T[]) new Object[CAPACITY];
        size = 0;
    }

    /**
     * Сортировка списка в естественном порядке.
     */
    @Override
    public void sort() {
        Arrays.sort(array);
    }

    /**
     * @return количество элементов в списке.
     */
    @Override
    public int size() {
        return this.size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        String separator = "";
        for (int i = 0; i < size; i++) {
            sb.append(separator).append(array[i]);
            separator = ", ";
        }
        sb.append("]");
        return sb.toString();
    }
}
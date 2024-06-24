package org.example.ListRealisation;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;


@Getter
@Setter
public class CustomArrayList<E> {
        private static final int DEFAULT_CAPACITY = 10;

        private Object[] array;
        private int size;

    /**
     * Конструктор класса CustomArrayList.
     * Создается новый объект с длиной внутреннего массива DEFAULT_CAPACITY = 10,
     * длина внутреннего массива не указана явно.
     */
        public CustomArrayList() {
            array = new Object[DEFAULT_CAPACITY];
            size = 0;
        }

    /**
     * Метод для получения объекта по индексу в CustomArrayList.
     * @param index - индекс объекта
     */
        public E get(int index) {
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException();
            }
            return (E) array[index];
        }

    /**
     * Метод для замены элемента в списке по индексу.
     * @param index индекс заменяемого элемента;
     * @param element элемент для замены;
     */
        public void set(int index, E element) {
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException();
            }
            array[index] = element;
        }

    /**
     * Метод для добавления элемента в список.
     * @param element элемент для добавления в список
     */
        public void add(E element) {
            ensureCapacity();
            array[size++] = element;
        }

    /**
     * Метод для добавления элемента в список по индексу
     * @param index индекс в списке куда элемент должен быть помещен
     * @param element элемент для вставки в список
     * @throws IndexOutOfBoundsException выдаст исключение если введенный индекс < 0 или
     * больше размера внутреннего массива
     */
        public void addToIndex(int index, E element) {
            if (index < 0 || index > size) {
                throw new IndexOutOfBoundsException();
            }
            ensureCapacity();
            System.arraycopy(array, index, array, index + 1, size - index);
            array[index] = element;
            size++;
        }

    /**
     * Метод для удаления элемента
     * @param index индекс элемента который должен быть удален
     * @throws IndexOutOfBoundsException выдаст исключение если введенный индекс < 0 или больше размера внутреннего массива
     */
        public E remove(int index) {
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException();
            }
            E removedElement = (E) array[index];
            System.arraycopy(array, index + 1, array, index, size - index - 1);
            size--;
            return removedElement;
        }

    /**
     * Метод для получения части списка.
     * @param fromIndex начальный индекс
     * @param toIndex конечный индекс(не включительно)
     * @throws IndexOutOfBoundsException выдаст исключение если начальный индекс < 0 или конечный индекс
     * больше размера внутреннего массива, либо начальный индекс больше конечного индекса
     */
        public CustomArrayList<E> sublist(int fromIndex, int toIndex) {
            if (fromIndex < 0 || toIndex > size || fromIndex > toIndex) {
                throw new IndexOutOfBoundsException();
            }
            CustomArrayList<E> sublist = new CustomArrayList<>();
            for (int i = fromIndex; i < toIndex; i++) {
                sublist.add(get(i));
            }
            return sublist;
        }

    /**
     *Метод Возвращает размер списка
     */
        public int size() {
            return size;
        }

    /**
     * Метод для увеличения размера списка в 2 раза, если размер списка равен длине массива
     */
        private void ensureCapacity() {
            if (size == array.length) {
                Object[] newArray = new Object[size * 2];
                System.arraycopy(array, 0, newArray, 0, size);
                array = newArray;
            }
        }

    /**
     *Метод toString для отображения списка в консоли
     */
    @Override
         public String toString() {
             return Arrays.toString(array);
    }
}

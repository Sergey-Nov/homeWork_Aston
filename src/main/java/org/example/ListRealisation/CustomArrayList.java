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

        public CustomArrayList() {
            array = new Object[DEFAULT_CAPACITY];
            size = 0;
        }

        public E get(int index) {
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException();
            }
            return (E) array[index];
        }

        public void set(int index, E element) {
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException();
            }
            array[index] = element;
        }

        public void add(E element) {
            ensureCapacity();
            array[size++] = element;
        }

        public void add(int index, E element) {
            if (index < 0 || index > size) {
                throw new IndexOutOfBoundsException();
            }
            ensureCapacity();
            System.arraycopy(array, index, array, index + 1, size - index);
            array[index] = element;
            size++;
        }

        public E remove(int index) {
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException();
            }
            E removedElement = (E) array[index];
            System.arraycopy(array, index + 1, array, index, size - index - 1);
            size--;
            return removedElement;
        }

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

        public int size() {
            return size;
        }

        private void ensureCapacity() {
            if (size == array.length) {
                Object[] newArray = new Object[size * 2];
                System.arraycopy(array, 0, newArray, 0, size);
                array = newArray;
            }
        }
}

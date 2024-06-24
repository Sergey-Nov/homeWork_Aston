package org.example.ListRealisation;



public class CustomLinkedList<E> {
    private Node<E> head;
    private int size;

    public CustomLinkedList() {
        head = null;
        size = 0;
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    public void set(int index, E element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        current.data = element;
    }

    public void add(E element) {
        Node<E> newNode = new Node<>(element);
        if (head == null) {
            head = newNode;
        } else {
            Node<E> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    public void add(int index, E element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            Node<E> newNode = new Node<>(element);
            newNode.next = head;
            head = newNode;
        } else {
            Node<E> newNode = new Node<>(element);
            Node<E> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
        size++;
    }

    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> current = head;
        if (index == 0) {
            head = current.next;
        } else {
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
        }
        size--;
        return current.data;
    }

    public CustomLinkedList<E> sublist(int startIndex, int endIndex) {
        if (startIndex < 0 || endIndex >= size || startIndex > endIndex) {
            throw new IndexOutOfBoundsException();
        }
        CustomLinkedList<E> sublist = new CustomLinkedList<>();
        Node<E> current = head;

        for (int i = 0; i < startIndex; i++) {
            current = current.next;
        }

        for (int i = startIndex; i <= endIndex; i++) {
            sublist.add(current.data);
            current = current.next;
        }

        return sublist;
    }

    public int size() {
        return size;
    }

    private static class Node<E> {
        E data;
        Node<E> next;

        Node(E data) {
            this.data = data;
            next = null;
        }
    }
}

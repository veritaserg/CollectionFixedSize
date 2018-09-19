package com.mycollection;

public class CollectionFixedSize<E> {
    private E[] array;
    private static final int DEFAULT_CAPACITY = 16;
    int size = 0;

    public CollectionFixedSize() {
        array = (E[]) new Object[DEFAULT_CAPACITY];
    }

    public CollectionFixedSize(int initialCapacity) {
        if (initialCapacity > 0) {
            this.array = (E[]) new Object[initialCapacity];
        } else if (initialCapacity == 0) {
            array = (E[]) new Object[DEFAULT_CAPACITY];
        } else {
            throw new IllegalArgumentException("Illegal Capacity: " +
                    initialCapacity);
        }
    }

    public boolean add(E element) {
        if (size >= array.length) {
            E[] temp = array;
            System.arraycopy(temp, 1, array, 0, temp.length - 1);
            array[array.length - 1] = element;
        } else {
            array[size] = element;
            size++;
        }
        return true;
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return array[index];
    }
}

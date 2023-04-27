package pl.javastart.task;

import java.util.Arrays;

// Uzupełnij klasę. Możesz ją dowolnie modyfikować.
// Celem jest, żeby przechodziły testy w src/test/java/[...]/CustomListTest
public class CustomList<T> {

    private static final int DEFAULT_CAPACITY = 1;
    private int size = 0;
    private Object[] elements;

    public CustomList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
        if (!(index >= 0 && index <= size)) {
            throw new IndexOutOfBoundsException();
        }
        return (T) elements[index];
    }

    public void add(T t) {
        if (size == elements.length) {
            increaseCapacity();
        }
        elements[size] = t;
        size++;
    }

    public void add(int index, T t) {
        if (!(index >= 0 && index <= size)) {
            throw new IndexOutOfBoundsException();
        }
        if (size == elements.length) {
            increaseCapacity();
        }
        addElementToIndicatedIndex(index, t);
    }

    private void increaseCapacity() {
        int newCapacity = elements.length * 3;
        elements = Arrays.copyOf(elements, newCapacity);
    }

    @SuppressWarnings("unchecked")
    private void addElementToIndicatedIndex(int index, T t) {
        for (int i = size; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = t;
        size++;
    }

    public int size() {
        return size;
    }

    public void remove(int index) {
        if (!(index >= 0 && index <= size)) {
            throw new IndexOutOfBoundsException();
        }
        shiftOtherIndexesToTheLeft(index);
        size--;
    }

    @SuppressWarnings("")
    private void shiftOtherIndexesToTheLeft(int index) {
        for (int i = index + 1; i < size; i++) {
            elements[i - 1] = elements[i];
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(elements[i]).append(", ");
        }
        sb.replace(sb.length() - 2, sb.length(), "]");
        return sb.toString();
    }
}


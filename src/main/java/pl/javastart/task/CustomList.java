package pl.javastart.task;

// Uzupełnij klasę. Możesz ją dowolnie modyfikować.
// Celem jest, żeby przechodziły testy w src/test/java/[...]/CustomListTest
public class CustomList<T> {

    private static final int DEFAULT_CAPACITY = 100;
    private int size = 0;
    private final Object[] elements;

    public CustomList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
        return (T) elements[index];
    }

    public void add(T t) {
        if (size < DEFAULT_CAPACITY) {
            elements[size] = t;
            size++;
        }
    }

    public void add(int index, T t) {
        if (size < DEFAULT_CAPACITY) {
            elements[size] = t;
            size++;
            moveIndex(index, t);
        }
    }

    @SuppressWarnings("unchecked")
    private void moveIndex(int index, T t) {
        for (int i = size - 1; i > index; i--) {
            T temp = (T) elements[i - 1];
            elements[i - 1] = elements[i];
            elements[i] = temp;
        }
    }

    public int size() {
        return size;
    }

    public void remove(int index) {
        elements[index] = null;
        moveRemovedIndex(index);
        size--;
    }

    @SuppressWarnings("")
    private void moveRemovedIndex(int index) {
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


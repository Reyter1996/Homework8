import java.util.Arrays;

public class MyArrayList {
    private static final int INITIAL_CAPACITY = 10;
    Object[] items;
    private int capacity;
    private int size = 0;

    public MyArrayList(int capacity) {
        this.capacity = capacity;
        this.items = new Object[capacity];
    }

    public MyArrayList() {
        this(INITIAL_CAPACITY);
    }

    private void increaseCapacity() {
        this.capacity = (int) (capacity * 1.5 + 1);
        this.items = Arrays.copyOf(items, capacity);
    }

    public void add(Object value) {
        int index = 0;
        while (this.items[index] != null) {
            index++;
            if (index == this.items.length - 1) {
                this.increaseCapacity();
            }
        }
        items[index] = value;
        size++;
    }

    public void remove(int index) {
        if (size == 0 || index > size) {
            System.out.println("nothing to remove");
            return;
        }
        Object[] buffer = Arrays.copyOfRange(this.items, index + 1, this.items.length - 1);
        System.arraycopy(buffer, 0, this.items, index, buffer.length);
        this.items[size] = null;
        size--;
    }
    // тестовый метод для отладки.
    public String toString() {
        StringBuilder builder = new StringBuilder();
        int i = 0;
        while (this.items[i] != null) {
            builder.append(this.items[i] + " ");
            i++;
        }
        return builder.toString().trim();
    }

    public int size() {
        return size;
    }

    public Object get(int index) {
        return this.items[index];
    }

    public void clear() {
        this.capacity = INITIAL_CAPACITY;
        this.items = new Object[capacity];
        this.size = 0;
    }
}
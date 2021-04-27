public class MyHashMap {
    static final int INITIAL_CAPACITY = 1 << 4;
    static final int MAX_CAPACITY = 1 << 30;
    static final float LOAD_FACTOR = 0.75f;
    static final float REBUILD_FACTOR = 1.5f;
    private int capacity;
    private EntryList[] map;

    public MyHashMap() {
        this(INITIAL_CAPACITY);
    }

    public MyHashMap(int capacity) {
        this.capacity = capacity;
        map = EntryList.arrayCreate(capacity);
    }

    public void put(Object key, Object value) {
        if (key == null) {
            if (value == null) {
                return;
            }
            map[0].add(new Entry(null, value));
            return;
        }
        int hash = Math.abs(key.hashCode());
        if (size() > capacity * LOAD_FACTOR && capacity < MAX_CAPACITY) {
            rebuild();
        }
        int position = hash % (map.length - 1);
        map[position].add(new Entry(key, value));
    }

    public void remove(Object key) throws IllegalKeyException {
        if (key == null) {
            map[0].remove(null);
            return;
        }
        int hash = Math.abs(key.hashCode());
        int position = hash % (map.length - 1);
        map[position].remove(key);
    }

    public void clear() {
        capacity = INITIAL_CAPACITY;
        map = EntryList.arrayCreate(capacity);
    }

    public int size() {
        int size = 0;
        for (int i = 0; i < map.length - 1; i++) {
            size += map[i].getSize();
        }
        return size;
    }

    public Object get(Object key) throws IllegalKeyException {
        if (key == null) {
            return map[0].get(null);
        }
        int hash = Math.abs(key.hashCode());
        int position = hash % (map.length - 1);
        return map[position].get(key);
    }

    private void rebuild() {
        int newCapacity = (int) ((capacity * REBUILD_FACTOR <= MAX_CAPACITY) ?
                (capacity * REBUILD_FACTOR) : MAX_CAPACITY);
        MyHashMap newMap = new MyHashMap(newCapacity);
        for (int i = 0; i < capacity; i++) {

            entryListCopyTo(map[i], newMap);
        }
        this.capacity = newCapacity;
        this.map = newMap.map;
    }

    private void entryListCopyTo(EntryList source, MyHashMap target) {
        Entry tail = source.head;
        target.put(tail.getKey(), tail.getValue());

        while (tail.hasNext()) {
            tail = tail.getNext();
            target.put(tail.getKey(), tail.getValue());
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < map.length - 1; i++) {
            builder.append("[").append(i).append("]").append(" - ").append(map[i].toString()).append("\n");
        }
        return builder.toString();
    }

    private static class EntryList {
        private Entry head = new Entry();
        private int size = 0;

        private static EntryList[] arrayCreate(int capacity) {
            EntryList[] entries = new EntryList[capacity];
            for (int i = 0; i < capacity; i++) {
                entries[i] = new EntryList();
            }
            return entries;
        }

        protected void add(Entry entry) {
            if (entry.getKey() == null) {
                if (head.getValue() == null) {
                    size++;
                }
                head.setValue(entry.getValue());
                return;
            }
            Entry tail = head;
            while (tail.hasNext()) {
                tail = tail.getNext();
                if (tail.keyIsEqual(entry.getKey())) {
                    tail.setValue(entry.getValue());
                    return;
                }
            }
            tail.setNext(entry);
            size++;
        }

        protected void remove(Object key) throws IllegalKeyException {
            if (key == null) {
                if (head.getValue() != null) {
                    head.setValue(null);
                    size--;
                }
                return;
            }
            Entry tail = head;
            Entry previous;
            while (tail.hasNext()) {
                previous = tail;
                tail = tail.getNext();
                if (tail.keyIsEqual(key)) {
                    previous.setNext(tail.next);
                    size--;
                    return;
                }
            }
            throw new IllegalKeyException("nothing to remove", key);
        }

        protected Object get(Object key) throws IllegalKeyException {
            if (key == null && head.getValue() != null) {
                return head.getValue();
            }
            if (key == null) {
                throw new IllegalKeyException("nothing with null-key", null);
            }
            Entry tail = head;
            while (tail.hasNext()) {
                tail = tail.getNext();
                if (tail.keyIsEqual(key)) {
                    return tail.getValue();
                }
            }
            throw new IllegalKeyException("key is missing", key);
        }


        protected int getSize() {
            return size;
        }

        //метод для тестового вывода
        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            if (head.getValue() != null) {
                builder.append(head.getValue().toString());
            }
            if (this.head.hasNext()) {
                Entry tail = head;
                while (tail.hasNext()) {
                    tail = tail.getNext();
                    if (tail.getValue() != null) {
                        builder.append(tail.getValue().toString()).append(" - ");
                    }
                }
            }
            return builder.toString();
        }
    }

    private static class Entry {
        private Object key;
        private Object value;
        private Entry next;

        private Entry() {
            this(null, null);
        }

        private Entry(Object key, Object value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }


        private Object getKey() {
            return key;
        }


        private Object getValue() {
            return value;
        }

        private void setValue(Object value) {
            this.value = value;
        }

        private Entry getNext() {
            return next;
        }

        private void setNext(Entry next) {
            this.next = next;
        }

        private boolean hasNext() {
            return next != null;
        }

        private <E> boolean keyIsEqual(E key) {
            if (this.key == null && key == null) {
                return true;
            }
            if (this.key == null || key == null) {
                return false;
            }
            if (key.getClass().isInstance(this.key)) {
                E keyToCompare = (E) this.key;
                return key.equals(keyToCompare);

            }
            return false;
        }

        @Override
        public String toString() {
            if (key != null && value != null) {
                return key.toString() + " - " + value.toString();
            } else if (key != null) {
                return key.toString() + " - null";
            } else {
                return null;
            }
        }
    }
}

class IllegalKeyException extends Exception {
    private final Object key;

    public IllegalKeyException(String message, Object key) {
        super(message);
        this.key = key;

    }

    public Object getKey() {
        return key;
    }
}
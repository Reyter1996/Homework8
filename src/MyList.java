public abstract class MyList {
    private Node head = new Node();
    private int size = 0;


    public void remove(int index) {
        if (index <= size && index >= 0) {
            Node tail = this.getHead().getNext();
            for (int i = 0; i < index; i++) {
                if (tail.hasNext()) {
                    tail = tail.getNext();
                }
            }
            tail.previous.next = tail.next;
            tail.next.previous = tail.previous;
            sizeDecrease();
        } else {
            System.out.println("invalid index");
        }
    }

    public void clear() {
        head.next = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public void sizeIncrease() {
        size++;
    }

    public void sizeDecrease() {
        size--;
    }

    protected Node getHead() {
        return head;
    }


    static class Node {
        private Node previous;
        private Node next;
        private Object object;

        Node(Node previous, Object object) {

            this.object = object;
            this.previous = previous;
            if (previous != null) {
                if (previous.next != null) {
                    this.next = previous.next;
                    this.next.previous = this;
                }
                previous.next = this;
            }
        }

        private Node() {
            this(null, null);
        }

        protected Node getNext() {
            return this.next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        protected Object getObject() {
            return this.object;
        }

        public Node getPrevious() {
            return previous;
        }

        protected boolean hasNext() {
            return !(this.getNext() == null);
        }
    }
}
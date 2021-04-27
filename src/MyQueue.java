public class MyQueue extends MyList {
    public Object peek() {
        return this.getHead().hasNext() ? this.getHead().getNext().getObject() : null;
    }

    public void add(Object value) {
        Node tail = this.getHead();
        while (tail.hasNext()) {
            tail = tail.getNext();
        }
        Node newNode = new Node(tail, value);
        tail.setNext(newNode);
        sizeIncrease();
    }

    public Object poll() {
        Object o = this.getHead().getNext().getObject();
        this.remove(0);
        return o;
    }

}
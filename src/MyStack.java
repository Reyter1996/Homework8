public class MyStack extends MyList {
    private Node tail = this.getHead();

    public void push(Object value) {
        tail = new Node(tail, value);
        sizeIncrease();
    }

    public Object peek() {
        return tail.getObject();
    }

    public Object pop() {
        Object o = this.tail.getObject();
        if (tail != this.getHead()) {
            this.tail.getPrevious().setNext(null);
            tail = tail.getPrevious();
            return o;
        } else {
            return null;
        }
    }

    @Override
    public void clear() {
        super.clear();
        tail = this.getHead();
    }

}
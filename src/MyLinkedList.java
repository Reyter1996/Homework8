public class MyLinkedList extends MyList {
    public Object get(int index) {
        Node tail = this.getHead().getNext();
        for (int i = 0; i < index; i++) {
            if (tail.hasNext()) {
                tail = tail.getNext();
            } else {
                System.out.println("invalid index");
                return null;
            }
        }
        return tail.getObject();
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

}
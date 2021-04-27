public class MyQueueTest {
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        System.out.println("Testing add");
        for (int i = 0; i < 20; i++) {
            String o = "" + i;
            myQueue.add(o);
        }
        System.out.println(myQueue.peek());
        System.out.println(myQueue.peek());
        System.out.println("\nsize is " + myQueue.size());

        System.out.println("Testing remove");
        myQueue.remove(12);
        myQueue.remove(17);

        System.out.println("\nsize is " + myQueue.size());

        System.out.println("size is " + myQueue.size());
        System.out.println("\npeek test");
        for (int i = 0; i < 3; i++) {
            System.out.print(myQueue.peek() + " ");
        }
        System.out.println("\npoll test");
        for (int i = 0; i < 3; i++) {
            System.out.print(myQueue.poll() + " ");
        }
        System.out.println();
        System.out.println(myQueue.size());

        System.out.println("\nTesting clear");
        myQueue.clear();
        System.out.println(myQueue.peek());

    }

}
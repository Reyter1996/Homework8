public class MyStackTest {
    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        System.out.println("testing push");
        myStack.push(1);
        myStack.push("--2--");
        myStack.push(new String[]{"***", "*-*", "(*) (*)"});
        System.out.println("\nsize is " + myStack.size());
        System.out.println("Testing remove");
        myStack.remove(12);
        myStack.remove(1);
        System.out.println("\nsize is " + myStack.size());
        System.out.println("size is " + myStack.size());
        System.out.println("\npeek test");
        for (int i = 0; i < 3; i++) {
            System.out.print(myStack.peek() + " ");
        }
        System.out.println("\npop test");
        for (int i = 0; i < 3; i++) {
            System.out.print(myStack.pop() + " ");
        }
        System.out.println();
        System.out.println("\nTesting clear");
        myStack.clear();
        System.out.println("\nTesting pop for void stack");
        System.out.println(myStack.pop());
    }
}
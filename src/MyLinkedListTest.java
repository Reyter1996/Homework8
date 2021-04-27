public class MyLinkedListTest {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        System.out.println("Testing add");
        for (int i = 0; i < 20; i++) {
            String o = "" + i;
            myLinkedList.add(o);
        }
        for (int i = 0; i < myLinkedList.size(); i++) {
            System.out.print(myLinkedList.get(i) + " ");
        }
        System.out.println("\nsize is " + myLinkedList.size());

        System.out.println("Testing remove");
        myLinkedList.remove(12);
        myLinkedList.remove(25);

        System.out.println("\nsize is " + myLinkedList.size());
        System.out.println("remove[0]");
        myLinkedList.remove(0);
        for (int i = 0; i < myLinkedList.size(); i++) {
            System.out.print(myLinkedList.get(i) + " ");
        }
        System.out.println("removing  [-1]");
        myLinkedList.remove(-1);
        myLinkedList.remove(0);
        for (int i = 0; i < myLinkedList.size(); i++) {
            System.out.print(myLinkedList.get(i) + " ");
        }
        System.out.println("Testing clear");
        myLinkedList.clear();
        for (int i = 0; i < myLinkedList.size(); i++) {
            System.out.print(myLinkedList.get(i) + " ");
        }
        System.out.println("size is " + myLinkedList.size());
    }
}
public class MyArrayListTest {


    public static void main(String[] args) {
        MyArrayList myArrayList = new MyArrayList();
        System.out.println("Add test");
        for (int i = 0; i < 20; i++) {

            String o = "" + (i);
            myArrayList.add(o);
        }
        System.out.println(myArrayList.toString());

        System.out.println("get element test");
        System.out.println(myArrayList.get(10));
        System.out.println("\nremove test");
        myArrayList.remove(8);

        System.out.println(myArrayList.toString());
        myArrayList.remove(15);
        System.out.println(myArrayList.toString());

        System.out.println("Size test");
        System.out.println("actual collection size is " + myArrayList.size());
        System.out.println("get element second test");
        System.out.println(myArrayList.get(10));
        System.out.println("clear() test");
        //myArrayList.clear();
        System.out.println(myArrayList.toString());
        System.out.println(myArrayList.size());
        System.out.println("***************");
        MyArrayList myArrayList2 = new MyArrayList();

        myArrayList2.add("4");
        myArrayList2.add(4);
        myArrayList2.add("5");
        System.out.println(myArrayList2.size());

        System.out.println(myArrayList2.get(0));
        myArrayList2.remove(1);
        System.out.println(myArrayList2.size());

        myArrayList2.add(17);
        myArrayList2.add("25");
        System.out.println(myArrayList2.get(4));
        System.out.println(myArrayList2.size());
        myArrayList2.remove(3);
        System.out.println(myArrayList2.size());
        myArrayList2.remove(2);
        System.out.println(myArrayList2.size());
        System.out.println("remove [0] test");
        System.out.println(myArrayList.toString());
        myArrayList.remove(0);
        System.out.println(myArrayList.toString());
        myArrayList.remove(3);
        System.out.println(myArrayList);
        myArrayList.remove(33);
        myArrayList.clear();
        myArrayList.remove(0);
        myArrayList.remove(8);
    }

}
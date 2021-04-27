public class MyHashMapTest {
    public static void main(String[] args) {
        MyHashMap map = new MyHashMap();
        System.out.println("testing put");
        for (int i = 0; i < 20; i++) {
            map.put("key is " + i, i);
        }
        System.out.println(map);
        System.out.println(map.size());
        System.out.println("\n\n****************");
        map.put(null, "zero object");
        System.out.println(map.size());
        System.out.println(map);
        try {
            System.out.println(map.get("key is 9"));
            System.out.println(map.get(null));
        } catch (IllegalKeyException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("\n\n***************");
        System.out.println("testing remove");
        try {
//            map.remove(3);
            map.remove("key is 5");
            map.remove(null);
            System.out.println(map);
            map.remove(null);
            System.out.println(map.size());
        } catch (IllegalKeyException e) {
            System.out.println(e.getMessage() + e.getKey());
        }
        map.clear();
        System.out.println(map);
        System.out.println(map.size());
    }
}
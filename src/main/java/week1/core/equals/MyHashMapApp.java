package week1.core.equals;

public class MyHashMapApp {
    public static void main(String[] args) {
        MyHashMap<String, String> map = new MyHashMap<>();

        map.put("a", "1");
        map.put("2", "2");
        map.put("a", "3");

        System.out.println(map.get("a")); // 3
        System.out.println(map.size());   // 2
    }
}

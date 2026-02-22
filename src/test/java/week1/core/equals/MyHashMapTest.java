package week1.core.equals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MyHashMapTest {
    @Test
    public void testMyHashMapWithHashOne() {
        final int size = 200;
        MyHashMapWithHashOne<String, String> myHashMap = new MyHashMapWithHashOne<>();

        for (int i = 0; i < size; i++) {
            myHashMap.put("key_" + i, "val_" + i);
        }

        Assertions.assertEquals(size, myHashMap.size());

        for (int i = 0; i < size; i++) {
            String key = "key_" + i;
            String value = "val_" + i;

            Assertions.assertEquals(value, myHashMap.get(key));
        }
    }

    @Test
    public void testMyHashMap() {
        final int size = 200;
        MyHashMap<String, String> myHashMap = new MyHashMap<>();

        for (int i = 0; i < size; i++) {
            myHashMap.put("key_" + i, "val_" + i);
        }

        Assertions.assertEquals(size, myHashMap.size());

        for (int i = 0; i < size; i++) {
            String key = "key_" + i;
            String value = "val_" + i;

            Assertions.assertEquals(value, myHashMap.get(key));
        }
    }

}
package week1.core.equals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyHashMapWithHashOneTest {
    @Test
    public void test() {
        final int size = 20;
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

}
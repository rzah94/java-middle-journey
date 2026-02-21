package week1.core.equals;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MyHashMap<K, V> {
    private static final int CAPACITY = 16;
    private int size = 0;
    private Node<K, V>[] table = new Node[CAPACITY];

    public MyHashMap() {
    }

    private int getIndex(K key) {
        return key.hashCode() & (table.length - 1);
    }

    public void put(K key, V value) {
        int index = getIndex(key);

        Node<K, V> current = table[index];

        // Если корзина пуста - просто вставляем
        if (current == null) {
            table[index] = new Node<>(key, value);
            size++;
            return;
        }

        // Ищем ключ в связном списке
        Node<K, V> prev = null;

        while (current != null) {
            if (current.getKey().equals(key)) {
                current.setValue(value);
                return;
            }
            prev = current;
            current = current.getNext();
        }

        // Ключ не найден - добавляем в конец списка
        prev.setNext(new Node<>(key, value));
        size++;
    }

    public V get(K key) {
        int index = getIndex(key);

        Node<K, V> current = table[index];

        while (current != null) {
            if (current.getKey().equals(key)) {
                return current.getValue();
            }
            current = current.getNext();
        }

        return null;
    }

    public int size() {
        return size;
    }

    @Getter
    @Setter
    public static class Node<K, V> {
        private final K key;
        private V value;
        private Node<K, V> next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}

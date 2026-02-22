package week1.core.equals;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class MyHashMap<K, V> {
    private int capacity = 16;
    private int size = 0;
    private Node<K, V>[] table;
    private final float loadFactor = 0.75f;
    private int threshold;

    public MyHashMap() {
        recalculateThreshold();
        table = new Node[capacity];
    }

    private int getIndex(K key) {
        int hash = key == null ? 0 : key.hashCode();
        return hash & (table.length - 1);
    }

    private void recalculateThreshold() {
        threshold = (int) (capacity * loadFactor);
    }

    private void resize() {
        System.out.println("=== Resize ===");
        System.out.println("Старая емкость: " + capacity);
        System.out.println("Элементов: " + size);

        capacity *= 2;
        recalculateThreshold();

        Node<K, V>[] oldTable = table;
        table = new Node[capacity];

        for (int i = 0; i < oldTable.length; i++) {
            if (oldTable[i] != null) {
                Node<K, V> node = oldTable[i];

                while (node != null) {
                    Node<K, V> next = node.getNext();
                    int newIndex = getIndex(node.getKey());

                    node.setNext(table[newIndex]);
                    table[newIndex] = node;

                    node = next;
                }
            }
        }

        System.out.println("Новая емкость: " + capacity);
        System.out.println("Новый порог: " + threshold);
    }

    public void put(K key, V value) {
        if (size >= threshold) {
            resize();
        }

        int index = getIndex(key);

        Node<K, V> node = table[index];

        while (node != null) {
            if (Objects.equals(node.getKey(), key)) {
                node.setValue(value);
                return;
            }
            node = node.getNext();
        }

        Node<K, V> newNode = new Node(key, value);
        newNode.setNext(table[index]);
        table[index] = newNode;
        size++;
    }

    public V get(K key) {
        int index = getIndex(key);

        Node<K, V> node = table[index];

        while (node != null) {
            if (Objects.equals(node.getKey(), key)) {
                return node.getValue();
            }
            node = node.getNext();
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

import java.util.*;

public class MyHashTable<K, V> {
    class HashNode<K, V> {
        K key;
        V value;
        HashNode<K, V> next;

        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "{" + key + ": " + value + "}";
        }
    }

    public ArrayList<HashNode<K, V>> chainArray;
    private int M = 10;
    public int size;

    public MyHashTable() {
        chainArray = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            chainArray.add(null);
        }
        size = 0;
    }

    private int hash(K key) {
        return Math.abs(key.hashCode()) % M;
    }

    public void put(K key, V value) {
        int index = hash(key);
        HashNode<K, V> head = chainArray.get(index);

        while (head != null) {
            if (head.key.equals(key)) {
                head.value = value;
                return;
            }
            head = head.next;
        }

        size++;
        head = chainArray.get(index);
        HashNode<K, V> newNode = new HashNode<>(key, value);
        newNode.next = head;
        chainArray.set(index, newNode);
    }

    public V get(K key) {
        int index = hash(key);
        HashNode<K, V> head = chainArray.get(index);

        while (head != null) {
            if (head.key.equals(key)) {
                return head.value;
            }
            head = head.next;
        }

        return null;
    }

    public V remove(K key) {
        int index = hash(key);
        HashNode<K, V> head = chainArray.get(index);
        HashNode<K, V> prev = null;

        while (head != null) {
            if (head.key.equals(key)) {
                break;
            }
            prev = head;
            head = head.next;
        }

        if (head == null) return null;

        size--;

        if (prev != null) {
            prev.next = head.next;
        } else {
            chainArray.set(index, head.next);
        }

        return head.value;
    }

    public boolean contains(K key) {
        return get(key) != null;
    }

    public V getKey(V value) {
        for (HashNode<K, V> headNode : chainArray) {
            while (headNode != null) {
                if (headNode.value.equals(value)) {
                    return headNode.value;
                }
                headNode = headNode.next;
            }
        }
        return null;
    }
}

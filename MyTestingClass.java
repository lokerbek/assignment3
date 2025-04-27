import java.util.Random;

public class MyTestingClass {
    public static void main(String[] args) {
        Random rand = new Random();

        MyHashTable<Integer, String> table = new MyHashTable<>();
        for (int i = 0; i < 10000; i++) {
            int key = rand.nextInt(1_000_000);
            table.put(key, "Value" + key);
        }

        System.out.println("MyHashTable testing. Size: " + table.size);

        BST<Integer, String> bst = new BST<>();
        for (int i = 0; i < 1000; i++) {
            int key = rand.nextInt(1_000_000);
            bst.put(key, "Node" + key);
        }

        System.out.println("\nBST testing:");
        for (BST<Integer, String>.Node node : bst) {
            System.out.println("Key: " + node.getKey() + ", Value: " + node.getValue());
        }
    }
}

class MyHashMap {
    // 1. Define our custom Node to hold Key-Value pairs
    class Node {
        int key;
        int val;
        Node next;
        
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    
    // 2. The array of buckets
    private Node[] map;
    private int SIZE = 769; // A prime number for better distribution
    
    public MyHashMap() {
        map = new Node[SIZE];
        // Initialize every bucket with a Dummy Node (-1, -1)
        for (int i = 0; i < SIZE; i++) {
            map[i] = new Node(-1, -1);
        }
    }
    
    // The Hash Function
    private int hash(int key) {
        return key % SIZE;
    }
    
    public void put(int key, int value) {
        // Start at the dummy node
        Node curr = map[hash(key)]; 
        
        // Traverse the chain looking for the key
        while (curr.next != null) {
            if (curr.next.key == key) {
                // If it exists, UPDATE the value and return immediately
                curr.next.val = value;
                return;
            }
            curr = curr.next;
        }
        // If we reach the end and didn't find it, add a new Node
        curr.next = new Node(key, value);
    }
    
    public int get(int key) {
        // Start AFTER the dummy node
        Node curr = map[hash(key)].next;
        
        while (curr != null) {
            if (curr.key == key) {
                return curr.val; // Found it!
            }
            curr = curr.next;
        }
        return -1; // Not found
    }
    
    public void remove(int key) {
        // Start at the dummy node so we can safely check curr.next
        Node curr = map[hash(key)];
        
        while (curr.next != null) {
            if (curr.next.key == key) {
                // Snip the node out of the chain
                curr.next = curr.next.next;
                return;
            }
            curr = curr.next;
        }
    }
}
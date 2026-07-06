class MyHashSet {
    // 1. Define the size of our primary array (a prime number)
    private int bucketSize;
    // 2. Create an array where every slot holds a LinkedList of Integers
    private LinkedList<Integer>[] buckets;

    public MyHashSet() {
        bucketSize = 769; 
        buckets = new LinkedList[bucketSize];
        
        // Initialize an empty LinkedList in every single bucket
        for (int i = 0; i < bucketSize; i++) {
            buckets[i] = new LinkedList<>();
        }
    }
    
    // The Hash Function: Maps any massive key to a valid array index
    private int hash(int key) {
        return key % bucketSize;
    }
    
    public void add(int key) {
        int index = hash(key);
        LinkedList<Integer> bucket = buckets[index];
        
        // Only add it if it doesn't already exist in the chain
        if (!bucket.contains(key)) {
            bucket.add(key);
        }
    }
    
    public void remove(int key) {
        int index = hash(key);
        LinkedList<Integer> bucket = buckets[index];
        
        // THE JAVA TRAP: 
        // bucket.remove(key) will treat 'key' as an INDEX and crash!
        // We must cast it to an Object (Integer) so Java removes the VALUE.
        bucket.remove(Integer.valueOf(key));
    }
    
    public boolean contains(int key) {
        int index = hash(key);
        LinkedList<Integer> bucket = buckets[index];
        
        return bucket.contains(key);
    }
}
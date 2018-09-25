/** An Integer HashMap implementation using Array and LinkedList. */
public class MyHashMap<K, V> {

    /** ListNode class holds each key-value pair, next pointer connect to the next node.*/
    private class ListNode<K, V> {
        K key;
        V val;
        ListNode next;
        ListNode(K key, V val) {
            this.key = key;
            this.val = val;
        }
    }

    /** Tracking the size of current HashMap */
    private int size;

    /** ListNode container */
    private ListNode<K, V>[] holder;

    /** Capacity index of the holder, a prime number */
    private int capacityIndex;

    /** A list of capacity size to be used */
    private static final int[] capacityArray = new int[]{
            53, 97, 193, 389, 769, 1543, 3079, 6151, 12289, 24593,
            49157, 98317, 196613, 393241, 786433, 1572869, 3145739, 6291469,
            12582917, 25165843, 50331653, 100663319, 201326611, 402653189, 805306457, 1610612741};

    private static final int UPPER_LIMIT_FACTOR = 8;
    private static final int LOWER_LIMIT_FACTOR = 2;

    public MyHashMap() {
        this.capacityIndex = 0;
        this.holder = new ListNode[capacityArray[this.capacityIndex]];
        this.size = 0;
    }

    /** Add a new key-value pair if key doesn't exist, update an existing key-value pair */
    public void put(K key, V value) {

        // Get the node contains target key
        // Update value if such node is found
        ListNode node = getNode(key);
        if(node != null){
            node.val = value;
            return;
        }

        // Get the corresponding index in the array by using hash.
        int index = getIndex(key);
        ListNode temp = holder[index];

        // Create a new ListNode if there isn't any ListNode in the current index position,
        if(temp == null){
            holder[index] = new ListNode<>(key, value);
            this.size++;
        } else {
            // If there exist any node, then add it at the end.
            while(temp.next != null)
                temp = temp.next;

            temp.next = new ListNode<>(key, value);
            this.size++;
        }

        // If there is a larger capacity in the list, and current size is greater than threshold
        // Increase capacity index first then resize.
        // Using long type here to prevent integer overflow.
        if(this.size >= (long)capacityArray[this.capacityIndex] * UPPER_LIMIT_FACTOR
                && this.capacityIndex < capacityArray.length - 1)
            resize(capacityArray[++this.capacityIndex]);
    }

    // Get the value for a given key.
    // Returns -1 if not found.
    public V get(K key) {
        ListNode<K, V> node = getNode(key);
        if(node == null)
            return null;
        return node.val;
    }

    // Remove a key-value pair in the map.
    public void remove(K key) {
        if(!containsKey(key))
            return;

        int index = getIndex(key);
        ListNode temp = holder[index];

        // If current node is has the key.
        if(temp.key.equals(key)){

            // If there isn't any node connecting to it, then set this index position to null.
            if(temp.next == null){
                holder[index] = null;
                this.size--;
                return;
            }

            // If there is other node, then set the next node as the first item.
            // Current temp node will be cleaned up.
            holder[index] = temp.next;
            this.size--;
        } else {
            // If first node in the index position is not the target node.
            // Then keep checking for the next node to see if it's the target node.
            // When found, we skip that node by setting current node.next to next.next.
            while(!temp.next.key.equals(key)){
                temp = temp.next;
            }

            temp.next = temp.next.next;
            this.size--;
        }
        // If there is a smaller capacity in the list, and current size is lesser than threshold
        // Decrease capacity index first then resize.
        // Using long type here to prevent integer overflow.
        if(this.capacityIndex > 0 && this.size < (long)capacityArray[this.capacityIndex] * LOWER_LIMIT_FACTOR)
            resize(capacityArray[--this.capacityIndex]);
    }

    private void resize(int volume) {
        ListNode[] newHolder = new ListNode[volume];

        // Loop through each node chain in the bucket.
        // Add all nodes to the new holder.
        for(ListNode<K, V> node : this.holder){
            while(node != null){
                // Locate the node position in the new holder.
                ListNode firstNode = newHolder[getIndex(node.key)];
                // Bucket is empty.
                if(firstNode == null)
                    newHolder[getIndex(node.key)] = new ListNode<>(node.key, node.val);
                else{ // Bucket already contains at least a node.
                    while(firstNode.next != null)
                        firstNode = firstNode.next;
                    firstNode.next = new ListNode<>(node.key, node.val);
                }
                node = node.next; // Loop through the node chain.
            }
        }

        this.holder = newHolder;
    }

    /** Return number of items in the map */
    public int size(){
        return this.size;
    }

    /** Return the maximum capacity of the holder, it does not represents the # of items we can hold */
    public int capacity(){
        return capacityArray[this.capacityIndex];
    }

    /** Check if the current map contains the target Key */
    public boolean containsKey(K key){
        int index = getIndex(key);
        ListNode temp = holder[index];
        while(temp != null){
            if(temp.key.equals(key))
                return true;
            temp = temp.next;
        }
        return false;
    }

    /** Return the node contains the target key */
    private ListNode getNode(K key){
        int index = getIndex(key);
        ListNode temp = holder[index];
        while(temp != null){
            if(temp.key.equals(key))
                return temp;
            temp = temp.next;
        }
        return null;
    }

    /** A hash function to locate the index in the container */
    private int getIndex(K key){
        // First ensure it's a positive number
        // Second ensure it's within capacity of the holder(array).
        return (key.hashCode() & 0x7fffffff) % capacityArray[this.capacityIndex];
    }
}

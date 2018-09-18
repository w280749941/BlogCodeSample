/** An Integer HashMap implementation using Array and LinkedList. */
public class HashMap<K, V> {

    /** ListNode class holds each key-value pair, next pointer connect to the next node.*/
    private class ListNode {
        K key;
        V val;
        ListNode next;
        ListNode(K key, V val) {
            this.key = key;
            this.val = val;
        }
    }

    private int capactity = 10000;

    /** Tracking the size of current HashMap */
    private int size;

    /** ListNode container */
    private ListNode[] holder;

    public HashMap() {
        this.holder = new ListNode[capactity];
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
            holder[index] = new ListNode(key, value);
            size++;
            return;
        }

        // If there exist any node, then add it at the end.
        while(temp.next != null)
            temp = temp.next;

        temp.next = new ListNode(key, value);
        size++;
    }

    // Get the value for a given key.
    // Returns -1 if not found.
    public int get(K key) {
        ListNode node = getNode(key);
        if(node == null)
            return -1;
        return node.val;
    }

    // Remove a key-value pair in the map.
    public void remove(int key) {
        if(!containsKey(key))
            return;

        int index = getIndex(key);
        ListNode temp = holder[index];

        // If current node is has the key.
        if(temp.key == key){

            // If there isn't any node connecting to it, then set this index position to null.
            if(temp.next == null){
                holder[index] = null;
                size--;
                return;
            }

            // If there is other node, then set the next node as the first item.
            // Current temp node will be cleaned up.
            holder[index] = temp.next;
            size--;
            return;
        }

        // If first node in the index position is not the target node.
        // Then keep checking for the next node to see if it's the target node.
        // When found, we skip that node by setting current node.next to next.next.
        while(temp.next.key != key){
            temp = temp.next;
        }

        temp.next = temp.next.next;
        size--;
    }

    public int size(){
        return this.size;
    }

    /** Check if the current map contains the target Key */
    public boolean containsKey(K key){
        int index = getIndex(key);
        ListNode temp = holder[index];
        while(temp != null){
            if(temp.key == key)
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
            if(temp.key == key)
                return temp;
            temp = temp.next;
        }
        return null;
    }

    /** A hash function to locate the index in the container */
    private int getIndex(K key){
        if(K instanceof String){
            return String.hashCode(key) & (holder.length-1);
        }
    }
}
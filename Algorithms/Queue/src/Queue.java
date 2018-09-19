public class Queue<T> {

    private class ListNode {
        T val;
        ListNode next;
        ListNode(T val) {
            this.val = val;
            next = null;
        }
    }

    private int size;
    private ListNode head;
    private ListNode tail;

    public Queue() {}

    public void offer(T val) {
        if(head == null){
            head = new ListNode(val);
            tail = head;
        } else{
            this.tail.next = new ListNode(val);
            tail = tail.next;
        }
        this.size++;
    }

    public T poll() {
        T result = this.head.val;
        this.head = this.head.next;
        this.size--;
        return result;
    }

    public T peek() {
        return this.head.val;
    }

    public int size() {
        return this.size;
    }

    public boolean empty(){
        return this.size == 0;
    }
}

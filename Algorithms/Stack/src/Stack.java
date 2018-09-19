public class Stack<T> {

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

    public Stack() {}

    public void push(T val) {
        if(head == null){
            head = new ListNode(val);
        } else{
            ListNode temp = head;
            head = new ListNode(val);
            head.next = temp;
        }
        this.size++;
    }

    public T pop() {
        T result = this.head.val;
        this.head = this.head.next;
        this.size--;
        return result;
    }

    public T peek() {
        return this.head.val;
    }

    public boolean empty(){
        return this.size == 0;
    }

    public int size(){
        return this.size;
    }
}

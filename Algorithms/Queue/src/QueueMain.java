public class QueueMain {

    public static void main(String[] args) {
        Queue<String> qu = new Queue<>();
        System.out.println(qu.empty());
        qu.offer("Hello");
        qu.offer("World");
        System.out.println(qu.empty());
        System.out.println(qu.size());
        System.out.println(qu.peek());
        System.out.println(qu.poll());
        System.out.println(qu.poll());
        System.out.println(qu.size());
    }
}

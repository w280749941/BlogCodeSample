public class PriorityQueueMain {

    public static void main(String[] args) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
        maxHeap.offer(5);
        maxHeap.offer(8);
        maxHeap.offer(9);
        maxHeap.offer(1);
        maxHeap.offer(4);
        System.out.println(maxHeap.size());
        int size = maxHeap.size();
        for(int i=0; i<size; i++){
            System.out.println(maxHeap.poll());
        }
    }
}

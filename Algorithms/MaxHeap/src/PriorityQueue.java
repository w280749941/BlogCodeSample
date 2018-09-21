public class PriorityQueue<T extends Comparable<T>> {
    MaxHeap<T> maxHeap;
    PriorityQueue(){
        maxHeap = new MaxHeap<>();
    }

    PriorityQueue(T[] array){
        maxHeap = new MaxHeap<>();
        for(T item : array)
            maxHeap.insert(item);
    }

    public int size(){
        return maxHeap.size();
    }

    public boolean isEmpty(){
        return maxHeap.isEmpty();
    }

    public T top(){
        return maxHeap.getMax();
    }

    public void offer(T item){
        maxHeap.insert(item);
    }

    public T poll(){
        return maxHeap.extractMax();
    }
}

import java.util.ArrayList;
import java.util.List;

public class MaxHeap<T extends Comparable<T>> {

    private List<T> array;

    public MaxHeap(){
        this.array = new ArrayList<>();
    }

    /** If left child index outOfBound return -1 */
    private int getLeftChildIndex(int index){
        return index * 2 + 1;
    }

    /** If right child index outOfBound return -1 */
    private int getRightChildIndex(int index){
        return index * 2 + 2;
    }

    /** If Parent index outOfBound return -1 */
    private int getParentIndex(int index){
        int result = (index-1)/2;
        if(result < 0)
            return -1;
        return result;
    }

    /** Swap element value between two indexes */
    private void swap(int left, int right){
        T temp = this.array.get(left);
        this.array.set(left, this.array.get(right));
        this.array.set(right, temp);
    }

    /** Return whether there is element in the heap */
    public boolean isEmpty(){
        return this.array.isEmpty();
    }

    /** Return the size of current heap */
    public int size(){
        return this.array.size();
    }

    /** Return whether heap contains a element */
    public boolean contains(T item){
        return this.array.contains(item);
    }

    /** Update a value in the array */
    public void update(int index, T value){
        this.array.set(index, value);
    }

    /** Retrieve an item at a specific index */
    public T get(int index){
        return this.array.get(index);
    }

    /** Return the index of an item */
    public int getIndex(T item){
        return this.array.indexOf(item);
    }

    /** Return the maximum item of the heap */
    public T getMax(){
        return this.array.get(0);
    }

    /** Return the maximum item and remove it */
    public T extractMax(){
        T result = getMax();
        swap(0, this.array.size()-1);
        this.array.remove(this.array.size()-1);
        heapify(0);
        return result;
    }

    /** Maintain the Max heap structure
     *  Keeping parent node greater than both children.
     * */
    private void heapify(int i) {

        int largestIndex = i;
        int leftIndex = getLeftChildIndex(i);
        int rightIndex = getRightChildIndex(i);

        if(leftIndex < this.array.size()
            && this.array.get(leftIndex).compareTo(this.array.get(largestIndex)) > 0){
            largestIndex = leftIndex;
        }

        if(rightIndex < this.array.size()
            && this.array.get(rightIndex).compareTo(this.array.get(largestIndex)) > 0){
            largestIndex = rightIndex;
        }

        if(largestIndex != i){
            swap(largestIndex, i);
            heapify(largestIndex);
        }
    }

    /** Insert an item into the heap */
    public void insert(T item){
        this.array.add(item);
        pushUp(this.array.size()-1);
    }

    /** Remove an item from heap at a specific index */
    public void remove(int index){
        this.array.remove(index);
    }

    /** Remove a given item */
    public void removeItem(T item){
        this.array.remove(item);
    }

    /** Push larget value item to the top */
    private void pushUp(int i) {
        int parentIndex = getParentIndex(i);
        if(parentIndex == -1)
            return;
        if(this.array.get(parentIndex).compareTo(this.array.get(i)) < 0) {
            swap(parentIndex, i);
            pushUp(parentIndex);
        }
    }
}
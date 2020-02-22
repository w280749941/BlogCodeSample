import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * Ring Buffer implementation.
 * @param <T>
 */
public class CircularQueue<T> {

    private final int capacity;
    private final T[] array;
    private int readPtr = 0;
    private int writePtr = 0;
    private boolean overwrite = false;

    public CircularQueue(int capacity) {
        if(capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be a positive number");
        }
        this.capacity = capacity;
        this.array = (T[]) new Object[capacity];
    }

    public void offer(T data) {
        this.array[writePtr] = data;
        writePtr = (writePtr+1) % this.capacity;
        if(writePtr == readPtr) {
            overwrite = true;
        } else if(overwrite && writePtr == readPtr + 1) {
            readPtr++;
        }
    }

    public T poll() {
        if(!overwrite && readPtr == writePtr) {
            throw new NoSuchElementException("No data is available");
        }

        T data = this.array[readPtr];
        readPtr = (readPtr + 1) % this.capacity;
        if(readPtr > writePtr) {
            overwrite = false;
        }

        return data;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public int getCurrentSize() {
        if(writePtr > readPtr) {
            return writePtr - readPtr;
        }

        return overwrite ? this.capacity : 0;
    }

    public void clear() {
        this.writePtr = 0;
        this.readPtr = 0;
        this.overwrite = false;
        Arrays.fill(this.array, null);
    }

    public static void main(String[] args) {
        CircularQueue<Integer> qu = new CircularQueue<>(5);
        for(int i=1; i<100; i++) {
            qu.offer(i);
        }

        for(int i=95; i<100; i++) {
            int num = qu.poll();
            if(i != num) {
                throw new RuntimeException(String.format("Expect %d but found %d", i, num));
            }
        }
    }
}

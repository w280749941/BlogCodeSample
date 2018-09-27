import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import sorters.*;
import utility.PerformanceFactor;
import utility.Utility;

public class SortMain {

    public static void main(String[] args) {
        Utility utility = new Utility();
        PerformanceFactor pf = new PerformanceFactor(10000, 1, 100000);
        BubbleSort bubbleSort = new BubbleSort();
        SelectionSort selectionSort = new SelectionSort();
        InsertionSort insertionSort = new InsertionSort();
        HeapSort heapSort = new HeapSort();
        MergeSort mergeSort = new MergeSort();
        MergeSortOptimized mergeSortOptimized = new MergeSortOptimized();
        QuickSort quickSort = new QuickSort();
        QuickSortOptimized quickSortOptimized = new QuickSortOptimized();

        ExecutorService pool = Executors.newFixedThreadPool(8);
        pool.execute(() -> utility.testPerformance(bubbleSort, pf));
        pool.execute(() -> utility.testPerformance(selectionSort, pf));
        pool.execute(() -> utility.testPerformance(insertionSort, pf));
        pool.execute(() -> utility.testPerformance(heapSort, pf));
        pool.execute(() -> utility.testPerformance(mergeSort, pf));
        pool.execute(() -> utility.testPerformance(mergeSortOptimized, pf));
        pool.execute(() -> utility.testPerformance(quickSort, pf));
        pool.execute(() -> utility.testPerformance(quickSortOptimized, pf));

        pool.shutdown();
    }
}

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import sorters.BubbleSort;
import sorters.SelectionSort;
import utility.PerformanceFactor;
import utility.Utility;

public class SortMain {

    public static void main(String[] args) {
        Utility utility = new Utility();
        PerformanceFactor pf = new PerformanceFactor(100000, 10, 100);
        BubbleSort bubbleSort = new BubbleSort();
        SelectionSort selectionSort = new SelectionSort();

        ExecutorService pool = Executors.newFixedThreadPool(2);
        pool.execute(() -> utility.testPerformance(bubbleSort, pf));
        pool.execute(() -> utility.testPerformance(selectionSort, pf));

    }
}

public class SortMain {

    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        Utility utility = new Utility();
        PerformanceFactor pf = new PerformanceFactor(1000, 10, 100);
        utility.testPerformance(bubbleSort, pf);
    }
}

public class SortMain {

    public static void main(String[] args) {
        int[] arr = new int[]{2, 1, 5, 3, 4};
        BubbleSort bubbleSort = new BubbleSort(arr);
        int[] out = bubbleSort.sort();
        for (int num : out){
            System.out.print(num + " ");
        }
    }
}

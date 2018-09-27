package sorters;

import utility.Sortable;
import utility.Utility;

public class QuickSort implements Sortable {

    private int[] nums;

    public QuickSort() {
    }

    public QuickSort(int[] nums) {
        this.nums = nums;
    }


    @Override
    public int[] sort() {
        sortArray(0, nums.length - 1);
        return nums;
    }

    private void sortArray(int left, int right) {
        if (left >= right)
            return;

        int partitionIndex = partition(left, right);
        sortArray(left, partitionIndex - 1); // Exclude element at partitionIndex
        sortArray(partitionIndex + 1, right);
    }

    private int partition(int left, int right) {
        int pivot = nums[right];

        int largerItemIndex = left;
        for (int i = left; i < right; i++) {
            if (nums[i] <= pivot) {
                Utility.swap(nums, largerItemIndex, i);
                largerItemIndex++;
            }
        }
        Utility.swap(nums, largerItemIndex, right);
        return largerItemIndex;
    }

    @Override
    public void setArray(int[] nums) {
        this.nums = nums;
    }
}

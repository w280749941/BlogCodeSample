package sorters;

import utility.Sortable;
import utility.Utility;

public class QuickSortOptimized implements Sortable {

    private int[] nums;

    public QuickSortOptimized(){}
    public QuickSortOptimized(int[] nums){this.nums = nums;}


    @Override
    public int[] sort() {
        sortArray(0, nums.length-1);
        return nums;
    }

    private void sortArray(int left, int right) {
        if(right - left <= 15){
            InsertionSort.sort(nums, left, right);
            return;
        }

        int partitionIndex = partition(left, right);
        sortArray(left, partitionIndex-1); // Exclude element at partitionIndex
        sortArray(partitionIndex+1, right);
    }

    private int partition(int left, int right) {
        Utility.swap(nums, right, Utility.rand.nextInt(right-left) + left);
        int pivot = nums[right];

        int l = left;
        int r = right-1;
        while(true){
            while(l <= right-1 && nums[l] < pivot)
                l++;

            while(r >= left && nums[r] > pivot)
                r--;

            if(l > r)
                break;

            Utility.swap(nums, l++, r--);
        }
        Utility.swap(nums, right, ++r); // r could be lesser than 0
        return r;
    }

    @Override
    public void setArray(int[] nums) {
        this.nums = nums;
    }
}

package sorters;

import utility.Sortable;
import utility.Utility;

public class SelectionSort implements Sortable {

    private int[] nums;

    public SelectionSort(){}
    public SelectionSort(int[] nums){this.nums = nums;}


    @Override
    public int[] sort() {
        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++)
                if (nums[j] < nums[i])
                    Utility.swap(nums, i, j);
        }
        return nums;
    }

    @Override
    public void setArray(int[] nums) {
        this.nums = nums;
    }
}

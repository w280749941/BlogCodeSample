package sorters;

import utility.Sortable;
import utility.Utility;

public class BubbleSort implements Sortable {

    private int[] nums;

    public BubbleSort(int[] arr){
        nums = arr;
    }
    public BubbleSort(){}

    @Override
    public int[] sort(){
        for(int i=nums.length-1; i >= 0; i--){
            boolean swapped = false;
            for(int j=0; j<i; j++){
                if(nums[j] > nums[j+1]){
                    swapped = true;
                    Utility.swap(nums, j, j+1);
                }
            }
            if (!swapped)
                break;
        }
        return nums;
    }

    @Override
    public void setArray(int[] nums) {
        this.nums = nums;
    }

}

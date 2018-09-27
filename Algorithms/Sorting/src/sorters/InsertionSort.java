package sorters;

import utility.Sortable;
import utility.Utility;

public class InsertionSort implements Sortable {
    private int[] nums;

    public InsertionSort(int[] arr){
        nums = arr;
    }
    public InsertionSort(){}

    @Override
    public int[] sort(){
        for(int i=1; i<nums.length; i++){
            int temp = nums[i];
            int j=i-1;
            while(j >=0 && nums[j] > temp){
                nums[j+1] = nums[j];
                j--;
            }
            nums[j+1] = temp;
        }
        return nums;
    }

    @Override
    public void setArray(int[] nums) {
        this.nums = nums;
    }

    static void sort(int[] array, int left, int right){
        for(int i=left+1; i<right+1; i++){
            int temp = array[i];
            int j=i-1;
            while(j >=left && array[j] > temp){
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = temp;
        }
    }
}

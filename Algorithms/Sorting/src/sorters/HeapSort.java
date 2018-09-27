package sorters;

import utility.Sortable;
import utility.Utility;

public class HeapSort implements Sortable {

    private int[] nums;

    public HeapSort(int[] arr){
        nums = arr;
    }
    public HeapSort(){}

    @Override
    public int[] sort(){

        // Build a maximum heap, from the mid element back to first element.
        // It will cover all elements in the array.
        for(int i=(nums.length-1)/2; i>=0; i--)
            heapfiy(nums, nums.length, i);

        // Swap element to sort array.
        for(int i=nums.length-1; i>=0; i--){
            Utility.swap(nums, i, 0);
            heapfiy(nums, i, 0);
        }
        return nums;
    }

    @Override
    public void setArray(int[] nums) {
        this.nums = nums;
    }

    private void heapfiy(int[] nums, int size, int rootIndex) {
        int leftChildIndex = 2 * rootIndex + 1;
        int rightChildIndex = 2 * rootIndex + 2;
        int largetValueIndex = rootIndex;

        if(leftChildIndex < size && nums[largetValueIndex] < nums[leftChildIndex])
            largetValueIndex = leftChildIndex;
        if(rightChildIndex < size && nums[largetValueIndex] < nums[rightChildIndex])
            largetValueIndex = rightChildIndex;

        if(largetValueIndex != rootIndex){
            Utility.swap(nums, largetValueIndex, rootIndex);
            // Now need to compare this node value with its children. Going downwards
            heapfiy(nums, size, largetValueIndex);
        }
    }
}

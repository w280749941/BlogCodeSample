package sorters;

import utility.Sortable;

public class MergeSortOptimized implements Sortable {
    private int[] nums;

    public MergeSortOptimized(int[] arr){
        nums = arr;
    }
    public MergeSortOptimized(){}

    @Override
    public int[] sort(){
        sortArray(0, nums.length-1);
        return nums;
    }

    @Override
    public void setArray(int[] nums) {
        this.nums = nums;
    }

    private void sortArray(int left, int right){
        if(right - left <= 15){
            InsertionSort.sort(nums, left, right);
            return;
        }
        int mid = left + (right - left)/2;
        sortArray(left, mid);
        sortArray(mid+1, right);
        // If left side array's right most element is lesser than and equal
        // to right side array's left most element, no need to merge.
        if(nums[mid] > nums[mid+1])
            mergeArray(left, mid, right);
    }

    private void mergeArray(int left, int mid, int right) {
        int sizeA = mid - left + 1;
        int sizeB = right - mid;

        int[] subArrayA = new int[sizeA];
        for(int a=0; a<sizeA; a++)
            subArrayA[a] = nums[left + a];

        int[] subArrayB = new int[sizeB];
        for(int b=0; b<sizeB; b++)
            subArrayB[b] = nums[mid + b + 1];

        int a = 0;
        int b = 0;
        int index = left;
        while(a < sizeA && b < sizeB){
            if(subArrayA[a] < subArrayB[b])
                nums[index++] = subArrayA[a++];
            else
                nums[index++] = subArrayB[b++];
        }

        while(a < sizeA)
            nums[index++] = subArrayA[a++];

        while(b < sizeB)
            nums[index++] = subArrayB[b++];
    }


}

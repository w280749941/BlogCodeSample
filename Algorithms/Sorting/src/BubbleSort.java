public class BubbleSort {

    private int[] nums;
    Utility utility = new Utility();

    public BubbleSort(int[] arr){
        nums = arr;
    }

    public int[] sort(){
        sortArray();
        return nums;
    }

    private void sortArray(){
        for(int i=nums.length-1; i >= 0; i--){
            boolean swapped = false;
            for(int j=0; j<i; j++){
                if(nums[j] > nums[j+1]){
                    swapped = true;
                    utility.swap(nums, j, j+1);
                }
            }
            if (!swapped)
                break;
        }
    }
}

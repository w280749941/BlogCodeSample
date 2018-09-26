package utility;

import java.util.Random;

public class Utility {

    private Random rand;
    public Utility(){
        this.rand = new Random();
    }

    public static void swap(int[] nums, int l, int r){
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }

    // Generate a Random Array
    private int[] generateRandomArray(int size, int lowerBound, int upperBound){
        int[] generatedArray = new int[size];

        for(int i=0; i<size; i++)
            generatedArray[i] = lowerBound + rand.nextInt(upperBound - lowerBound);

        return generatedArray;
    }

    // Generate a Sorted Array
    private int[] generateSortedArray(int size, int initial){
        int[] generatedArray = new int[size];

        int index=0;
        while(index < size)
            generatedArray[index++] = initial++;

        return generatedArray;
    }

    // Generate a Reversed Array
    private int[] generateReversedArray(int size, int initial){
        int[] generatedArray = new int[size];

        int index=0;
        while(index < size)
            generatedArray[index++] = initial--;

        return generatedArray;
    }

    // Is sorted
    public boolean isSorted(int[] nums){
        for(int i=0; i<nums.length-1; i++)
            if(nums[i] > nums[i+1])
                return false;

        return true;
    }

    // Test Array Performance
    public void testPerformance(Sortable sortable, PerformanceFactor pf){

        // Test random array
        int[] randomArray = generateRandomArray(pf.getSize(), pf.getLowerBound(), pf.getUpperBound());
        double timeRandom = getSortingTime(sortable, randomArray);
        if (timeRandom < 0)
            System.out.printf("%s not sorted on random array with size %d\n", sortable.getClass().getName(), pf.getSize());
        else
            System.out.printf("%s spent %.5fs on random array with size %d\n", sortable.getClass().getName(), timeRandom, pf.getSize());

        // Test sorted array
        int[] sortedArray = generateSortedArray(pf.getSize(), pf.getLowerBound());
        double timeSorted = getSortingTime(sortable, sortedArray);
        if (timeSorted < 0)
            System.out.printf("%s not sorted on random array with size %d\n", sortable.getClass().getName(), pf.getSize());
        else
            System.out.printf("%s spent %.5fs on sorted array with size %d\n", sortable.getClass().getName(), timeSorted, pf.getSize());

        // Test reversed array
        int[] reversedArray = generateReversedArray(pf.getSize(), pf.getUpperBound());
        double timeReversed = getSortingTime(sortable, reversedArray);
        if (timeReversed < 0)
            System.out.printf("%s not sorted on random array with size %d\n", sortable.getClass().getName(), pf.getSize());
        else
            System.out.printf("%s spent %.5fs on reversed array with size %d\n", sortable.getClass().getName(), timeReversed, pf.getSize());
    }

    private double getSortingTime(Sortable sortable, int[] randomArray) {
        sortable.setArray(randomArray);
        long tick = System.nanoTime();
        int[] nums = sortable.sort();
        long tok = System.nanoTime();
        return isSorted(nums) ? (tok - tick) / 1000000000.0 : -1;
    }
}

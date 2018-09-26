import java.util.Random;

public class Utility {

    private Random rand;
    public Utility(){
        this.rand = new Random();
    }

    public void swap(int[] nums, int l, int r){
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }

    // Generate a Random Array
    public int[] generateRandomArray(int size, int lowerBound, int upperBound){
        int[] generatedArray = new int[size];

        for(int i=0; i<size; i++)
            generatedArray[i] = lowerBound + rand.nextInt(upperBound - lowerBound);

        return generatedArray;
    }

    // Generate a Sorted Array
    public int[] generateSortedArray(int size, int initial){
        int[] generatedArray = new int[size];

        for(int i=initial; i<size + initial; i++)
            generatedArray[i] = i;

        return generatedArray;
    }

    // Generate a Reversed Array
    public int[] generateReversedArray(int size, int initial){
        int[] generatedArray = new int[size];

        for(int i= initial; i>initial-size; i++)
            generatedArray[i] = i;

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
        sortable.setArray(randomArray);
        long tick = System.nanoTime();
        sortable.sort();
        long tok = System.nanoTime();
        double time = (tok - tick) / 1000000000.0;
        System.out.printf("%s spent %.5fs on sorted array with size %d\n", sortable.getClass().getName(), time, pf.getSize());

        // Test sorted array

        // Test reversed array
    }
}

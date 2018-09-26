public class PerformanceFactor {

    private int size;
    private int upperBound;
    private int lowerBound;

    public PerformanceFactor(int size, int lowerBound, int upperBound) {
        this.size = size;
        this.upperBound = upperBound;
        this.lowerBound = lowerBound;
    }

    public int getSize() {
        return size;
    }

    public int getUpperBound() {
        return upperBound;
    }

    public int getLowerBound() {
        return lowerBound;
    }
}

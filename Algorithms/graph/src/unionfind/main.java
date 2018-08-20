package unionfind;

public class main {

    public static void main(String[] args) throws Exception {
        int size = 3000000;
        //UnionFindDemo.test(size);
        //UnionFindOptimized1Demo.test(size); // Optimized union but find takes longer time.
        UnionFindOptimized2Demo.test(size);
        UnionFindOptimized3Demo.test(size);
        UnionFindPathCompressionDemo.test(size);
        UnionFindPathCompressionOptimizedDemo.test(size);
    }
}

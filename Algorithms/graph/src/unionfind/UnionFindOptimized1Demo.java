package unionfind;

import java.util.Random;

public class UnionFindOptimized1Demo {

    public static void test(int size) throws Exception {
        Random rand = new Random();

        long start = System.currentTimeMillis();
        UnionFindOptimized1 unionFind = new UnionFindOptimized1(size);


        for(int i = 0; i<size; i++){
            int x = rand.nextInt(size);
            int y = rand.nextInt(size);
            unionFind.unionItems(x, y);
        }

        for(int i = 0; i<size; i++){
            int x = rand.nextInt(size);
            int y = rand.nextInt(size);
            unionFind.isConnected(x, y);
        }

        long end = System.currentTimeMillis();
        System.out.println((end-start));
    }
}

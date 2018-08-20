package unionfind;


public class UnionFindOptimized2 {

    private int[] parent;
    private int[] count;

    public UnionFindOptimized2(int n){
        parent = new int[n];
        count = new int[n];
        for(int i=0; i<n; i++){
            parent[i] = i;
            count[i] = 1;
        }
    }

    public int find(int x) throws Exception {
        if(x < 0 || x >= parent.length){
            throw new Exception(String.format("Index out of bound, size: %d, x: %d", parent.length, x));
        }

        while(x != parent[x]){
            x = parent[x];
        }
        return x;
    }

    public boolean isConnected(int x, int y) throws Exception {
        return this.find(x) == this.find(y);
    }

    public void unionItems(int x, int y) throws Exception {
        int xId = find(x);
        int yId = find(y);

        if (xId == yId) {
            return;
        }

        // Smaller length connect to longer length.
        if(count[yId] < count[xId]){
            parent[yId] = xId;
            count[xId] += count[yId];
        } else{
            parent[xId] = yId;
            count[yId] += count[xId];
        }
    }
}

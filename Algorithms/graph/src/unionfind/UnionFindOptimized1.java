package unionfind;

public class UnionFindOptimized1 {

    private int[] parent;


    public UnionFindOptimized1(int n){
        parent = new int[n];
        for(int i=0; i<n; i++){
            parent[i] = i;
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

        parent[xId] = yId;
    }
}

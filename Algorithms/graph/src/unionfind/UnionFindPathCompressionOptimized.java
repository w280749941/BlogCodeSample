package unionfind;

public class UnionFindPathCompressionOptimized {

    private int[] parent;
    private int[] rank;

    public UnionFindPathCompressionOptimized(int n){
        parent = new int[n];
        rank = new int[n];
        for(int i=0; i<n; i++){
            parent[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int x) throws Exception {
        if(x < 0 || x >= parent.length){
            throw new Exception(String.format("Index out of bound, size: %d, x: %d", parent.length, x));
        }

        if(x != parent[x]){
            parent[x] = find(parent[x]);
        }
        return parent[x];
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

        // Smaller rank appended to the higher rank, no need to add rank since the height of the
        // higher rank doesn't change
        if(rank[yId] < rank[xId]){
            parent[yId] = xId;
        } else if(rank[yId] > rank[xId]){
            parent[xId] = yId;
        } else {
            parent[xId] = yId;
            rank[yId]++;
        }
    }
}

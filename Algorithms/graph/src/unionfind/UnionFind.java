package unionfind;

public class UnionFind {

    private int[] arr;


    public UnionFind(int n){
        arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = i;
        }
    }

    public int find(int x) throws Exception {
        if(x < 0 || x >= arr.length){
            throw new Exception(String.format("Index out of bound, size: %d, x: %d", arr.length, x));
        }

        return arr[x];
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

        for (int i = 0; i < arr.length; i++) {
            if(yId == arr[i]){
                arr[i] = xId;
            }
        }
    }
}

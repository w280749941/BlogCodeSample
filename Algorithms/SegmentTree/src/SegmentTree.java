public class SegmentTree<T> {
    private class ListNode {
        T val;
        int start;
        int end;
        ListNode left;
        ListNode right;
        ListNode(int start, int end) {
            this.start = start;
            this.end = end;
        }
        ListNode(T val, int start, int end) {
            this.val = val;
            this.start = start;
            this.end = end;
        }
    }

    private T[] tree;
    private ListNode root;
    private Merger<T> merger;

    public SegmentTree(T[] arr, Merger<T> merger){
        this.merger = merger;

        buildSegmentTree(arr, 0, arr.length-1);
    }

    private ListNode buildSegmentTree(T[] arr, int left, int right) {
        if(left == right){
            return new ListNode(arr[left], left, right);
        }

        ListNode root = new ListNode(left, right);
        int mid = left + (right-left)/2;
        root.left = buildSegmentTree(arr, left, mid);
        root.right = buildSegmentTree(arr, mid+1, right);
        root.val = merger.merge(root.left.val, root.right.val);
        return root;
    }
}

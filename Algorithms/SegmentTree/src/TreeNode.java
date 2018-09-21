public class TreeNode<T> {
    T val;
    int start;
    int end;
    TreeNode<T> left;
    TreeNode<T> right;
    TreeNode(int start, int end) {
        this.start = start;
        this.end = end;
    }
    TreeNode(T val, int start, int end) {
        this.val = val;
        this.start = start;
        this.end = end;
    }
}
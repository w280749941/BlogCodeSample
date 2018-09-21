public class SegmentTreeMain{
    public static void main(String[] args) {
        Integer[] nums = new Integer[]{1, 2, 3, 4, 5};
        SegmentTree<Integer> segmentTree = new SegmentTree<>(nums, new Merger<Integer>() {
            @Override
            public Integer merge(Integer a, Integer b) {
                return a + b;
            }
        });
        BinaryTreeTraversal<Integer> btt = new BinaryTreeTraversal<>();
        btt.BFS(segmentTree.getRoot());
        System.out.println(segmentTree.findBetween(0, 0));
        TreeNode root = segmentTree.update(0, 9);
        btt.BFS(root);
    }
}
public class BSTMain {

    /* Current tree structure
				   5
			  3			  11
		  1		 4	   9	 15
					 7
     */
    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        bst.add(5);
        bst.add(3);
        bst.add(11);
        bst.add(1);
        bst.add(4);
        bst.add(15);
        bst.add(9);
        bst.add(7);

        BinaryTreeTraversal<Integer> btr = new BinaryTreeTraversal<>();
        System.out.print("Preorder traversal recursive:\t");
        btr.preOrderTraversal(bst.rootElement(), true);
        System.out.print("Preorder traversal iterative:\t");
        btr.preOrderTraversal(bst.rootElement(), false);

        System.out.print("Inorder traversal recursive:\t");
        btr.inOrderTraversal(bst.rootElement(), true);
        System.out.print("Inorder traversal iterative:\t");
        btr.inOrderTraversal(bst.rootElement(), false);

        System.out.print("Postorder traversal recursive:\t");
        btr.postOrderTraversal(bst.rootElement(), true);
        System.out.print("Postorder traversal iterative:\t");
        btr.postOrderTraversal(bst.rootElement(), false);

        System.out.print("Breadth first search traversal:\t");
        btr.BFS(bst.rootElement());

        bst.remove(5);
        System.out.print("Removed current root:\t");
        btr.BFS(bst.rootElement());

        System.out.println("min: " + bst.minimum().val);
        System.out.println("max: " + bst.maximum().val);
        System.out.println("size: " + bst.size());
    }
}
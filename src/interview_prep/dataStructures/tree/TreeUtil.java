package interview_prep.dataStructures.tree;

public class TreeUtil {

    public static TreeNode<Integer> createIntBinaryTree() {
        TreeNode<Integer> root = new TreeNode<>(20);
        root.left = new TreeNode<>(5);
        root.right = new TreeNode<>(7);
        root.left.left = new TreeNode<>(9);
        root.left.right = new TreeNode<>(8);
        root.left.right.left = new TreeNode<>(15);

        root.right.right = new TreeNode<>(10);

        return root;
    }
}

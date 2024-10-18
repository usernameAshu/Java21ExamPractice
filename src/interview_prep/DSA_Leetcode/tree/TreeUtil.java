package interview_prep.DSA_Leetcode.tree;

public class TreeUtil {

    public static Tree_Node<Integer> createIntBinaryTree() {
        Tree_Node<Integer> root = new Tree_Node<>(20);
        root.left = new Tree_Node<>(5);
        root.right = new Tree_Node<>(7);
        root.left.left = new Tree_Node<>(9);
        root.left.right = new Tree_Node<>(8);
        root.left.right.left = new Tree_Node<>(15);

        root.right.right = new Tree_Node<>(10);

        return root;
    }

    public static interview_prep.DSA_Leetcode.leetcode.tree.TreeNode createBinaryTree() {
        interview_prep.DSA_Leetcode.leetcode.tree.TreeNode root = new interview_prep.DSA_Leetcode.leetcode.tree.TreeNode(20);
        root.left = new interview_prep.DSA_Leetcode.leetcode.tree.TreeNode(5);
        root.right = new interview_prep.DSA_Leetcode.leetcode.tree.TreeNode(7);
        root.left.left = new interview_prep.DSA_Leetcode.leetcode.tree.TreeNode(9);
        root.left.right = new interview_prep.DSA_Leetcode.leetcode.tree.TreeNode(8);
        root.left.right.left = new interview_prep.DSA_Leetcode.leetcode.tree.TreeNode(15);

        root.right.right = new interview_prep.DSA_Leetcode.leetcode.tree.TreeNode(10);

        return root;
    }


}

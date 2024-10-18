package interview_prep.DSA_Leetcode.leetcode.tree;

import interview_prep.DSA_Leetcode.tree.TreeUtil;

/**
 * LeetCode 114. Flatten Binary Tree to Linked List
 */
public class Flatten_BTreeToLinkedList {

    public static void main(String[] args) {

        TreeNode root = TreeUtil.createBinaryTree();
        new Flatten_BTreeToLinkedList().flatten(root);
        System.out.println(root);
    }

    /**
     * Recursive Approach:
     * Store the left and right subtrees in temp
     * Make root-> left as null
     * Flatten the left subtree & right subtree
     * Attach the right of root to flattened left subtree
     * Iterate to the last right most element, and attach the right flattened subtree
     * @param root
     */
    public void flatten(TreeNode root) {
        if(root == null ) return;

        TreeNode tempLeft = root.left;
        TreeNode tempRight = root.right;
        root.left = null;
        flatten(tempLeft);
        flatten(tempRight);

        root.right = tempLeft;

        TreeNode current = root;

        while(current.right != null) {
            current = current.right;
        }
        current.right = tempRight;
    }


}

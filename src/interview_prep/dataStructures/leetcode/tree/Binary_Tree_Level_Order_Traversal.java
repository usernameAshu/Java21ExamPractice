package interview_prep.dataStructures.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


//Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

/**
 * LeetCode 102
 * Given the root of a binary tree,
 * return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
 *
 * Example:
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[3],[9,20],[15,7]]
 *
 * Example 2:
 *
 * Input: root = [1]
 * Output: [[1]]
 * Example 3:
 *
 * Input: root = []
 * Output: []
 */
public class Binary_Tree_Level_Order_Traversal {

    public static void main(String[] args) {
        TreeNode root = createBinaryTree();
        List<List<Integer>> result = new Binary_Tree_Level_Order_Traversal().levelOrder(root);

        System.out.println(result);
    }


    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> tree = new ArrayList<>();
        if(root == null) return tree;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> currLevel = new ArrayList<>();
            while(size-- > 0) {
                TreeNode node = queue.poll();
                currLevel.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }

            }
        tree.add(currLevel);
        }
        return tree;
    }

    public static TreeNode createBinaryTree() {

        TreeNode root = new TreeNode(20);
            root.left = new TreeNode(5);
            root.right = new TreeNode(7);
            root.left.left = new TreeNode(9);
            root.left.right = new TreeNode(8);
            root.left.right.left = new TreeNode(15);

            root.right.right = new TreeNode(10);

            return root;
      
    }
}

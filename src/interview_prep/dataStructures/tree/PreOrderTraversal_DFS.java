package interview_prep.dataStructures.tree;

import interview_prep.dataStructures.leetcode.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

//Root - Left - Right
public class PreOrderTraversal_DFS {

    public static void main(String[] args) {
        TreeNode root = TreeUtil.createBinaryTree();
        Queue<Integer> queue = new LinkedList<>();
        new PreOrderTraversal_DFS().preOrderTraversal(root, queue);
        System.out.println(queue);
        System.out.println(root);
    }


    private void preOrderTraversal(TreeNode root, Queue<Integer> queue) {
        if(root == null) return;

        queue.add(root.val);
        preOrderTraversal(root.left, queue);
        preOrderTraversal(root.right, queue);

    }
}

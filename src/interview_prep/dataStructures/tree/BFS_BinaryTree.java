package interview_prep.dataStructures.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS_BinaryTree {

    public static void main(String[] args) {
        TreeNode<Integer> root = TreeUtil.createIntBinaryTree();
        List<Integer> res = new BFS_BinaryTree().BFS(root);

        System.out.println(res);
    }

    public List<Integer> BFS(TreeNode<Integer> root) {
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode<Integer> node = queue.poll();
            res.add(node.data);

            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }

        }

        return res;
    }
}

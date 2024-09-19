package interview_prep.dataStructures.tree;

/**
 * Class representation of a Binary tree
 * @param <E>
 */
public class TreeNode<E> {
    public E data;
    public TreeNode<E> left;
    public TreeNode<E> right;

    public TreeNode(E data) {
        this.data = data;
        left = null;
        right  = null;
    }

}

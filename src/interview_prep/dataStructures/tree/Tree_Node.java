package interview_prep.dataStructures.tree;

/**
 * Class representation of a Binary tree
 * @param <E>
 */
public class Tree_Node<E> {
    public E data;
    public Tree_Node<E> left;
    public Tree_Node<E> right;

    public Tree_Node(E data) {
        this.data = data;
        left = null;
        right  = null;
    }

}

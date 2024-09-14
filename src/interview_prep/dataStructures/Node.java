package interview_prep.dataStructures;

public class Node {

    public int val;
    public Node next;

    public Node() {}

    public Node(int x) {
        val = x;
        this.next = null;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}

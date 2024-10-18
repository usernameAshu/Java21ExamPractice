package interview_prep.DSA_Leetcode.linkedlist;

import interview_prep.DSA_Leetcode.Node;

/**
 * Using 3 pointers
 * prev, curr, next
 */
public class ReverseLinkedList {

    public static void main(String[] args) {
        new ReverseLinkedList().reverseList();
    }

    void reverseList() {
        Node head = createList();
        System.out.println("------Original list----------");
        iterateNodes(head);
        head = reverse(head);
        System.out.println("\n------Reversed list----------");
        iterateNodes(head);
    }


    Node createList() {
        Node head = new Node(7);
        head.next = new Node(1);
        head.next.next = new Node(9);
        head.next.next.next = new Node(8);
        head.next.next.next.next = new Node(3);
        return head;
    }

    void iterateNodes(Node head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    Node reverse(Node head) {
        Node prev = null;
        Node curr = head;

        while(curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}

package interview_prep.DSA_Leetcode.linkedlist;

import interview_prep.DSA_Leetcode.Node;

public class SortLinkedList {

    public static void main(String[] args) {
        new SortLinkedList().sortLinkedList();
    }

    void sortLinkedList() {
        Node head = createList();
        iterateNodes(head);
        head = sort(head);
        System.out.println();
        iterateNodes(head);
    }

    Node sort(Node head) {

        //If one or no elements in the list
        if (head == null || head.next == null) {
            return head;
        }

        Node mid = findMid(head);
        System.out.print("\nMid: "+ mid.val);
        Node left = head;
        Node right = mid.next;
        mid.next = null;

        left = sort(left);
        right = sort(right);

        return mergeSort(left, right);
    }

    Node mergeSort(Node left, Node right) {
        if (left == null) return right;
        if (right == null) return left;

        Node result;
        if (left.val <= right.val) {
            result = left;
            result.next = mergeSort(left.next, right);
        } else {
            result = right;
            result.next = mergeSort(left, right.next);
        }
        return result;
    }


    Node findMid(Node head) {
        Node slow = head;
        Node fast = head.next;  //to find the 1st mid incase of even size

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
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


}

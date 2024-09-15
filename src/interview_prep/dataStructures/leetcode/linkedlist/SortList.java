package interview_prep.dataStructures.leetcode.linkedlist;

import interview_prep.dataStructures.Node;

/**
 * LeetCode 148
 * Given the head of a linked list, return the list after sorting it in ascending order.
 * Given: 4->2->1->3
 * Output:1->2->3->4
 */
public class SortList {

    public static void main(String[] args) {

        ListNode head = createList();
        iterateNodes(head);
        System.out.println("\n---------------");
        new SortList().sortList(head);
        iterateNodes(head);

    }

    public ListNode sortList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode leftTail = findMid(head);
        ListNode rightHead = leftTail.next;
        leftTail.next = null;

        ListNode head1 = sortList(head);
        ListNode head2 = sortList(rightHead);
        merge(head1, head2);
        return head;
    }

    ListNode merge(ListNode head1, ListNode head2) {
        ListNode ansHead = new ListNode(-1);
        ListNode ansTail = ansHead;

        while (head1 != null && head2 != null) {
            if(head1.val < head2.val) {
                ansTail.next = new ListNode(head1.val);
                head1 = head1.next;
            } else if(head1.val > head2.val) {
                ansTail.next = new ListNode(head2.val);
                head2 = head2.next;
            } else {
                ansTail.next = new ListNode(head1.val);
                head1 = head1.next;
                head2 = head2.next;
            }
            ansTail = ansTail.next;
        }

        while (head1 != null) {
            ansTail.next = new ListNode(head1.val);
            ansTail = ansTail.next;
            head1 = head1.next;
        }

        while (head2 != null) {
            ansTail.next = new ListNode(head2.val);
            ansTail = ansTail.next;
            head2 = head2.next;
        }

        return ansTail.next;
    }

    // 1 -> 2 -> 3 -> 4 -> 5
    //
    private ListNode findMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = slow.next; //returns first middle
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }


    static ListNode createList() {
        ListNode head = new ListNode(7);
        head.next = new ListNode(1);
        head.next.next = new ListNode(9);
        head.next.next.next = new ListNode(8);
        head.next.next.next.next = new ListNode(3);
        return head;
    }

    static void iterateNodes(ListNode head) {
        ListNode tempHead = head;
        while (tempHead != null) {
            System.out.print(tempHead.val + " ");
            tempHead = tempHead.next;
        }
    }
}

package interview_prep.DSA_Leetcode.leetcode.linkedlist;

/**
 * Using 3 pointers
 * prev
 * curr
 * next
 */
public class ReverseLinkedList {

    public static void main(String[] args) {

        ListNode head = LLUtil.createList();
        LLUtil.printHead(head);
        ListNode newHead = new ReverseLinkedList().reverse(head);
        LLUtil.printHead(newHead);

    }

    ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = curr;

        while(curr !=null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}

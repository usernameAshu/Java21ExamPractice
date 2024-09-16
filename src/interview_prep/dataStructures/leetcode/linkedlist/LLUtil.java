package interview_prep.dataStructures.leetcode.linkedlist;

public class LLUtil {

    public static ListNode createList() {
        ListNode head = new ListNode(7);
        head.next = new ListNode(1);
        head.next.next = new ListNode(9);
        head.next.next.next = new ListNode(8);
        head.next.next.next.next = new ListNode(3);
        return head;
    }

    public static ListNode createListForKGroup() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        return head;
    }

    private static void iterateNodes(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    public static void printHead(ListNode head1) {
        iterateNodes(head1);
        System.out.println();
    }
}

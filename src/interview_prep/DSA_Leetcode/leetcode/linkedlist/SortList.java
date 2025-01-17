package interview_prep.DSA_Leetcode.leetcode.linkedlist;

/**
 * LeetCode 148
 * Given the head of a linked list, return the list after sorting it in ascending order.
 * Given: 4->2->1->3
 * Output:1->2->3->4
 * https://www.youtube.com/watch?v=13UkRumpqZw
 */
public class SortList {

    public static void main(String[] args) {

        ListNode head = createList();
        printHead(head);
        System.out.println("\n---------------");
        ListNode sortedHead = new SortList().sortList(head);
        printHead(sortedHead);

    }

    public ListNode sortList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = head;
        while(fast!=null && fast.next!=null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null; //first list tail points to null

        ListNode head1 = sortList(head);
        //printHead(head1);
        ListNode head2 = sortList(slow);
        //printHead(head2);

        return merge(head1, head2);
    }

    ListNode merge(ListNode head1, ListNode head2) {
        ListNode ansHead = new ListNode(-1);
        ListNode ansTail = ansHead;

        while (head1 != null && head2 != null) {
            if(head1.val <= head2.val) {
                ansTail.next = new ListNode(head1.val);
                head1 = head1.next;
            } else {
                ansTail.next = new ListNode(head2.val);
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

//        ListNode t = ansHead;
//        ansHead = ansHead.next;
//        t = null;
        return ansHead.next;
    }

    private static void printHead(ListNode head1) {
        iterateNodes(head1);
        System.out.println();
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
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}

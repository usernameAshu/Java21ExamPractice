package interview_prep.dataStructures.leetcode.linkedlist;

/**
 * LC 25
 *
 * Given the head of a linked list, reverse the nodes of the list k at a time,
 * and return the modified list.
 *
 * k is a positive integer and is less than or equal to the length of the linked list.
 * If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.
 *
 * You may not alter the values in the list's nodes, only nodes themselves may be changed.
 *
 * Input: head = [1,2,3,4,5], k = 2
 * Output: [2,1,4,3,5]
 *
 * Input: head = [1,2,3,4,5], k = 3
 * Output: [3,2,1,4,5]
 */
public class ReverseKGroup {

    public static void main(String[] args) {
        ListNode head = LLUtil.createListForKGroup();
        LLUtil.printHead(head);
        ListNode ansHead = new ReverseKGroup().reverseKGroup(head, 2);
        LLUtil.printHead(ansHead);

    }

    public int len(ListNode head) {
        int len = 0;
        while(head!=null) {
            len++;
            head = head.next;
        }
        return len;
    }


    public ListNode reverseKGroup(ListNode head, int k) {
        int N = len(head);
        ListNode prevHead = null;
        ListNode currHead = head;
        ListNode ansNode = null;
        int groups = N/k;

        for(int i = 0; i< groups; i++) {
            ListNode prev = null;
            ListNode curr = currHead;
            ListNode next = null;

            for(int j=0; j<k;j++) {
                //reverse logic
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            if(prevHead == null) {
                ansNode = prev;
            } else {
                prevHead.next = prev;
            }

            prevHead = currHead;
            currHead = curr;
        }

        //link the last incomplete group
        // ,if last group was complete
        //currHead would be null
        prevHead.next = currHead;

        return ansNode;
    }
}

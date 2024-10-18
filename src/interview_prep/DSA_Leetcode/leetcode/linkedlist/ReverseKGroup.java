package interview_prep.DSA_Leetcode.leetcode.linkedlist;

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
        //calculate number of nodes
        int N = len(head);
        int groups = N/k;

        ListNode prevHead = null;
        ListNode ansHead = null;
        ListNode currHead = head;

        //iterate over each group
        for(int i=0; i<groups;i++) {
            ListNode prev =null;
            ListNode curr = currHead;
            ListNode next = null;

            for(int j=0;j<k;j++) {
                //reverse the group
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            //link the prev head of previous group with prev of next group to make a continues chain
            //also take care of edge case - first time, no prev head will be there
            if(prevHead == null) {
                ansHead = prev;
            } else {
                prevHead.next = prev;
            }

            //prevHead to be shifted to current head
            //and we need to shift currHead to the next current group/node
            prevHead = currHead;
            currHead = curr;
        }

        //after the selected groups have been reversed,
        //we need to link the remaining nodes, with previous head
        //curr head will be at the new node.
        //In case there is no node after reversing the groups, curr head will be at NULL
        prevHead.next = currHead;

        //this was stored when the 1st group was reversed
        return ansHead;
    }
}

package interview_prep.DSA_Leetcode.leetcode.linkedlist;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 *
 * Explaination: https://www.youtube.com/watch?v=oDL8vuu2Q0E
 */
public class ReverseSubLinkedList {

    public static void main(String[] args) {

        new ReverseSubLinkedList().test2();
    }

    void test2() {
        ListNode head = new ListNode(3);
        head.next = new ListNode(5);

        int left = 1;
        int right = 2;
        ListNode resultHead = new ReverseSubLinkedList().reverseBetween(head, left, right);

        iterateNodes(resultHead);
    }

    void test1() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int left = 2;
        int right = 4;
        ListNode resultHead = new ReverseSubLinkedList().reverseBetween(head, left, right);

        iterateNodes(resultHead);
    }


    void iterateNodes(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    /**
     * 1 -> 2 -> 3 -> 4 -> 5
     * 1 -> 4 -> 3 -> 2 -> 5
     *
     * @param head
     * @param left
     * @param right
     * @return
     */

    public ListNode reverseBetween(ListNode head, int left, int right) {
        //dummy is pointing to head, curr is at head
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = head;
        ListNode leftPrev = dummy;

        //move to a sublist head place
        for(int i=0; i < left -1; i++) {
            leftPrev = leftPrev.next;
            curr = curr.next;
        }

        ListNode leftHead = curr;
        ListNode prev = null;
        ListNode next = null;

        //iterate thorugh the sublist
        for(int i=left; i<= right ; i++) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        //connect the lefthead and righttails
        leftPrev.next = prev;
        leftHead.next = curr;

        return dummy.next;

    }

    public ListNode reverseBetween_2(ListNode head, int left, int right) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = curr.next;
        ListNode prevLeft = null;
        ListNode leftNode = null;
        int lc = 1;
        int rc = 1;

        while (lc <= right) {
            if (lc == left) {
                prevLeft = prev;
                leftNode = curr;
                next = curr.next;
                prev = curr;
                curr = next;

            } else if (lc == right) {
                prev.next = null;
                next = curr.next;
                curr.next = prev;

                if(prevLeft != null) {
                    //when left is the starting node
                    prevLeft.next = curr;
                }
                if(leftNode != null && next != null) {
                    leftNode.next = next;
                }
                if(next == null && prevLeft == null) {
                    //this is a total reversal of linked list
                    head = curr;
                }

            } else if (lc > left && lc < right) {
                //inside the sub list
                //reverse the list
                prev.next = null;
                next = curr.next;
                System.out.println("next: "+next);
                System.out.println("curr: "+curr);
                System.out.println("prev: "+prev);
                curr.next = prev;

                prev = curr;
                curr = next;

            } else if (lc < left) {
                next = curr.next;
                prev = curr;
                curr = next;

            }
            lc++;
        }

        return head;
    }


    public ListNode reverseBetween_(ListNode head, int left, int right) {
        //Go to the left and right node
        ListNode tempHead = head;
        ListNode leftNode = null;
        ListNode rightNode = null;
        int j = 1;
        while (j < left) {
            leftNode = tempHead.next;
            tempHead = leftNode;
            j++;
        }
        if (left == right) {
            rightNode = leftNode;
        } else {
            while (j < right) {
                rightNode = tempHead.next;
                tempHead = rightNode;
                j++;
            }
        }

        System.out.println("left node: " + leftNode);
        System.out.println("right node: " + rightNode);
        return null;
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode reverseList(ListNode head) {
        /* Iterative Solution
        ListNode prevNode = null;
        ListNode currNode = head;

        while (currNode != null) {
            ListNode nextNode = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;
        }
        return prevNode;
        end of Iterative Solution */

        /* Recursive Solution */

        // base case
        if (head == null || head.next == null) {
            return head;
        }

        // recurse to the end
        ListNode newHead = reverseList(head.next);

        // reverse the connections
        head.next.next = head;
        head.next = null;

        return newHead;

        /* end of Recursive Solution */
    }
}

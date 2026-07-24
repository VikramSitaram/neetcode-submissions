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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) {
            return head;
        }
        
        // dummy node pointing to head to cover edge case where left = head
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode leftPrev = dummy;
        ListNode curr = head;

        // move leftPrev to one place before left and curr to left
        for (int i=1;i<left;i++) {
            leftPrev = leftPrev.next;
            curr = curr.next;
        }

        // reverse the sub-segment
        ListNode prev = null;
        ListNode nxt = null;
        for (int i=1;i<=(right-left+1);i++) {
            nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }

        // reconnect the tail and head pieces
        leftPrev.next.next = curr;
        leftPrev.next = prev;

        return dummy.next;
    }
}
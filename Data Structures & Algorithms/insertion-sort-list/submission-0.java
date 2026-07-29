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
    public ListNode insertionSortList(ListNode head) {
        // dummy node
        ListNode dummy = new ListNode(-5001);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val >= prev.val) {
                prev = cur;
                cur = cur.next;
                continue;
            }

            // we have hit a node that is smaller then prev node
            // start from beginning of list to find insertion point
            ListNode tmp = dummy;
            while (cur.val > tmp.next.val) {
                tmp = tmp.next;
            }
            // perform swap and insert
            prev.next = cur.next;
            cur.next = tmp.next;
            tmp.next = cur;
            cur = prev.next;
        }

        return dummy.next;
    }
}
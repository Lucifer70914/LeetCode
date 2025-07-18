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
    public ListNode deleteMiddle(ListNode head) {
        // If only one element, return null
        if (head.next == null) return null;

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        // Classic slow-fast approach
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }

        // Delete the middle node
        prev.next = slow.next;
        return head;
    }
}

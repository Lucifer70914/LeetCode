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
        // Edge case: only one node
        if (head == null || head.next == null) return null;

        // Initialize slow and fast pointers
        ListNode slow = head, fast = head;
        ListNode prev = null;

        // Move fast by 2 and slow by 1 to find the middle
        while (fast != null && fast.next != null) {
            prev = slow;         // store previous of slow
            slow = slow.next;    // move slow by 1
            fast = fast.next.next; // move fast by 2
        }

        // Remove the middle node
        prev.next = slow.next;

        return head;
    }
}

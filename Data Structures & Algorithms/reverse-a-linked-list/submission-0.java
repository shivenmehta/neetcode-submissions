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
        if (head == null || head.next == null) { //Handle empty or 1-element case
            return head;
        }
        ListNode current = head;
        ListNode next = current.next;
        ListNode forwarder = next.next;
        next.next = current;
        current.next = null;

        while (forwarder != null) {
            current = next;
            System.out.println(current.val);
            next = forwarder;
            forwarder = next.next;
            next.next = current;
        }

        return next;

    }
}

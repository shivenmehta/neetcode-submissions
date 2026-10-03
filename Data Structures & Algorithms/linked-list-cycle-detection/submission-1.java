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
    public boolean hasCycle(ListNode head) {

        Set<ListNode> tracker = new HashSet<>(); //Node, Index (Key-Value Pair)
        
        ListNode current = head;
        int counter = 0;
        while (current != null) {
            if (tracker.contains(current)) {
                return true;
            } else {
                tracker.add(current);
                counter = counter + 1;
            }
            current = current.next;
        }
        return false;
    }
}

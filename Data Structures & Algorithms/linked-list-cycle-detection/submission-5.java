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
        if (head==null||head.next==null){
            return false;
        }

        ListNode curr = head;
        ListNode fast = head;

        while (fast!=null&&fast.next!=null){
            fast = fast.next.next;
            curr = curr.next;

            if (curr == fast){
                return true;
            }
        }

        return false;
    }
}

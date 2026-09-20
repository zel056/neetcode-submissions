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
        if (head==null){
            return false;
        }
        ListNode curr = head;
        ListNode next = curr.next;
        if (next==null){
            return false;
        }
       

        while (curr!=null&&next!=null&&next.next!=null){
            if (curr.val==next.val){
                return true;
            }
            curr = curr.next;
            next = next.next.next;
        }

        return false;

    }
}

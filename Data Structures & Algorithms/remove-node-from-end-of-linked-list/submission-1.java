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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode curr = head;
        int length = 0;
        while (curr!=null){
            length++;
            curr = curr.next;
        }
        int idx = length - n ;

        if (idx ==0 &&length!=0){
            return head.next;
        }
        int tracker = 0;
        ListNode prev = null;

        curr = head;
        while (tracker!=idx){
            tracker++;
            prev = curr;
            curr = curr.next;
        }

        if (prev==null||curr == null){
            return null;
        }

        prev.next = curr.next;
        return head;
        
    }
}

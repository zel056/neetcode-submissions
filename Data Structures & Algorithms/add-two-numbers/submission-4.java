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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1==null){
            return l2;
        }
        else if (l2==null){
            return l1;
        }
        else if (l1==null&&l2==null){
            return null;
        }
        ListNode dummy = new ListNode (0);
        ListNode curr = dummy;

        ListNode head1 = l1;
        ListNode head2 = l2;
        int placeholder =0;

        while (head1!=null&&head2!=null){
            int digit = (head1.val+head2.val+placeholder)%10;
            if ((head1.val+head2.val+placeholder)/10>=1){
                placeholder = 1;
            }
            else{
                placeholder =0;
            }
            curr.next = new ListNode(digit);
            curr = curr.next;
            head1 = head1.next;
            head2 = head2.next;
        }

        if (head1!=null){
            while (head1!=null){
                int digit = (head1.val+placeholder)%10;
                if ((head1.val+placeholder)/10>=1){
                    placeholder =1;
                }
                else{
                    placeholder = 0;
                }
                curr.next = new ListNode(digit);
                curr = curr.next;
                head1 = head1.next;
            }
        }

        if (head2!=null){
            while (head2!=null){
                int digit = (head2.val+placeholder)%10;
                if ((head2.val+placeholder)/10>=1){
                    placeholder =1;
                }
                else{
                    placeholder = 0;
                }
                curr.next = new ListNode(digit);
                curr = curr.next;
                head2 = head2.next;
            }
        }

        if (head1==null&&head2==null&&placeholder>=1){
            curr.next = new ListNode(placeholder);
            curr = curr.next;
        }

        return dummy.next;
    }
}

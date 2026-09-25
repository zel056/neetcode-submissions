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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length==0){
            return null;
        }
        int interval = 1;
        while (interval<lists.length){
            for (int i = 0; i+interval<lists.length; i+=interval*2){
                lists[i] = mergeTwoLists(lists[i],lists[i+interval]);
            }
            interval *=2;
        }

        return lists[0];
    }

    public ListNode mergeTwoLists(ListNode node1, ListNode node2){
        ListNode curr1 = node1;
        ListNode curr2 = node2;
        ListNode dummy = new ListNode(0);
        ListNode result = dummy;
        if (node1==null&&node2!=null){
            return node2;
        }
        else if (node2==null&&node1!=null){
            return node1;
        }
        else if (node1==null&&node2==null){
            return null;
        }

        while (curr1!=null&&curr2!=null){
            if (curr1.val<=curr2.val){
                result.next = curr1;
                curr1 = curr1.next;
            }
            else{
                result.next = curr2;
                curr2 = curr2.next;
            }
            result = result.next;
        }
        if (curr1!=null){
            result.next = curr1;
        }
        else{
            result.next = curr2;
        }
        return dummy.next;
    }
}

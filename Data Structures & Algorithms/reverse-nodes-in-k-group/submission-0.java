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
    public ListNode reverseKGroup(ListNode head, int k) {
        int total = 0; //find how many nodes that should not be adjust
        ListNode curr = head;
        while (curr!=null){
            total++;
            curr = curr.next;
        }

        int leftover = total%k; //the last leftover elements shouldn't change
        if (total/k==0){
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode groupprev = dummy;
        curr = head;
        ListNode groupPrev = dummy;
        for (int i=0; i<(total/k);i++){
            ListNode prev = null;
            ListNode groupTail = curr;

            for(int j =0; j<k;j++){
                ListNode nextTemp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = nextTemp;
            }

            groupPrev.next = prev;
            groupTail.next = curr; //connect to the unreverse next linkedlist

            groupPrev = groupTail;
        }
        return dummy.next;
        //curr is currently at the head of next set of LinkedList
        //need a way to save the prev at this time, keep it and reverse next set then connect together
        //NOTICE THAT WHEN YOU ITERATE BOTH SET AT THE SAME TIME, IT WILL CONNECT THE TWO REVERSE LINKED_LIST PROPPERLY

    }
}

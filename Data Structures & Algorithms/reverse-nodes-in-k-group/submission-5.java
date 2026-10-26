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
        int total = 0; 
        
        // BUG 1 FIX: Use a temp node to count so 'head' isn't destroyed
        ListNode tempNode = head;
        while (tempNode!=null){ 
            total++; 
            tempNode = tempNode.next; 
        } 
        
        if (total/k==0){ 
            return head; 
        } 

        // BUG 2 FIX: Create a dummy node to avoid losing contact with the first element
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = null; 
        ListNode curr = head; 
        
        // BUG 2 FIX: Start predecessor at dummy so it can connect the first group
        ListNode predecessor = dummy; 
        ListNode successor = curr; 
        int tracker = 0; 
        
        for (int i=0; i<(total/k);i++){ 
            // Save the node that WILL become the tail of this group after reversal
            ListNode groupTail = curr;

            while (curr!=null && tracker<k && predecessor!=null){ 
                ListNode nextTemp = curr.next; 
                curr.next = prev; 
                prev = curr; 
                successor = prev; 
                curr = nextTemp; 
                tracker++; 
            } 
            
            // BUG 3 FIX: Replace the inner while loop with direct stitching
            predecessor.next = prev;       // Connect previous group's tail to this group's new head
            groupTail.next = curr;         // Connect this group's new tail to the remaining list
            
            predecessor = groupTail;       // Set up predecessor for the next group iteration
            prev = null; 
            tracker = 0; 
        } 
        
        return dummy.next; // Returns the preserved first element
    } 
}


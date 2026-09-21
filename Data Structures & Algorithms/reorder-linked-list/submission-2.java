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
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        // Step 1: Count total nodes and build the reversed clone
        int length = 0;
        ListNode reverseHead = null;
        ListNode curr = head;

        while (curr != null) {
            length++;
            ListNode copyNode = new ListNode(curr.val);
            copyNode.next = reverseHead;
            reverseHead = copyNode;
            curr = curr.next;
        }

        // Step 2: Weave nodes one by one using a structural pointer
        ListNode pointer = head;
        ListNode forwardNext = head.next;
        ListNode reverseNext = reverseHead.next;

        // We alternate back and forth. True means connect next reverse node.
        boolean sourceFromReverse = true; 

        // We only need to attach exactly (length - 1) nodes to our head
        for (int i = 0; i < length - 1; i++) {
            if (sourceFromReverse) {
                pointer.next = reverseHead;
                reverseHead = reverseNext;
                if (reverseNext != null) reverseNext = reverseNext.next;
            } else {
                pointer.next = forwardNext;
                forwardNext = forwardNext.next;
            }
            pointer = pointer.next;
            sourceFromReverse = !sourceFromReverse; // Toggle turn
        }

        // Step 3: Strictly terminate the tail to prevent any cyclic loops
        pointer.next = null;
    }
}

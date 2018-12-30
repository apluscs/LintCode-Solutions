/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class Solution {
    /**
     * @param head: head is the head of the linked list
     * @return: head of linked list
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode prev=head; ListNode curr=head; ListNode start=head;
        while(curr!=null){
            if(curr.val==prev.val) prev.next=curr.next; //found duplicate
            else prev = curr;   //updates "current value"
            curr=curr.next;
        }
        return start;
    }
}

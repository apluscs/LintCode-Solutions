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
     * @param head: a ListNode
     * @param val: An integer
     * @return: a ListNode
     */
    public ListNode removeElements(ListNode head, int val) {
        ListNode result=new ListNode(-10);  result.next=head;   head=result;
        while(head.next!=null){ //think of head as the node immediately before the one being examined
            if(head.next.val==val){
                head.next=head.next.next;
            } else{ //only move ahead if you're certain head.next.val != val. In the case above, head.next changes, so you don't know for sure
                head=head.next;
            }
        }
        return result.next;
    }
}

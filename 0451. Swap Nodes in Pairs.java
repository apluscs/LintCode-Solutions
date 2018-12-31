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
     * @return: a ListNode
     */
    public ListNode swapPairs(ListNode head) {
        ListNode result=new ListNode(-1);   
        result.next=head;
        ListNode former=head;   
        ListNode latter=result; //at the start of each loop, latter marks the node immediately before the first one that needs to be swapped
        while(former!=null&&former.next!=null){
            latter.next=former.next;
            
            latter=former;//latter and former slide down 1
            former=former.next; 
            
            latter.next=former.next;
            former.next=latter;
            
            former=latter.next;
        }
        return result.next;
    }
}

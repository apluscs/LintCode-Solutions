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
     * @param head: The first node of linked list.
     * @param n: An integer
     * @return: The head of linked list.
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null) return head;
        ListNode block=head;
        for(int i = 0; i<n; i++){
            block=block.next;   //I imagine a person walking into a wall with a long block of wood protruding from their chest. When the block hits the wall, you've found the one to delete!
        }
        ListNode start=new ListNode(-1);     start.next=head;   //connect start to head
        head=start;
        while(block !=null){
            block=block.next;
            head=head.next;
        }
        head.next=head.next.next;
        return start.next;
    }
}

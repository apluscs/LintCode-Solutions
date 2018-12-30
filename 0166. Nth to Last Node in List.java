/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */


public class Solution {
    /*
     * @param head: The first node of linked list.
     * @param n: An integer
     * @return: Nth to last node of a singly linked list. 
     */
    public ListNode nthToLast(ListNode head, int n) {   
        ListNode block=head;    //I imagine a person walking into a wall with a long block of wood protruding from their chest. When the block hits the wall, you've found the right answer!
        ListNode result =head;
        for(int i=0;i<n;i++){
            block=block.next;
        }
        while(block!=null){
            result=result.next; 
            block=block.next;
        }
        return result;
    }
}

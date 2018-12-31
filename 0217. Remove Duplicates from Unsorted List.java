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
     * @return: Head node.
     */
    public ListNode removeDuplicates(ListNode head) {
        ListNode result=head;
        HashSet<Integer> visited=new HashSet<>();   //tracks previously encountered numbers
        while(head!= null &&head.next!=null){
            visited.add(head.val);
            if(visited.contains(head.next.val)){
                head.next=head.next.next;
            } else{ //only move if you're certain head.next is unique 
                head=head.next;   
            }
        }
        return result;
    }
}

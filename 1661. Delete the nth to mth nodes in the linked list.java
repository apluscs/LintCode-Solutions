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
     * @param head: The first node of linked list
     * @param n: the start index
     * @param m: the end node
     * @return: A ListNode
     */
    public ListNode deleteNode(ListNode head, int n, int m) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy; //will end on the last node of the first chain
        int count = 0;
        while(count < n){
            first = first.next;
            count++;
        }
        ListNode second = first;    //will end on the last node of the chain that needs to be deleted
        while(count <= m){  
            second = second.next;
            count++;
        }
        first.next = second.next;
        return dummy.next;
    }
}

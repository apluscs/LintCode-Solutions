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
     * @param head: The head of linked list.
     * @param val: An integer.
     * @return: The head of new linked list.
     */
    public ListNode insertNode(ListNode head, int val) {
        ListNode result = new ListNode(0);  //must add this initial node in case val goes before head.val
        result.next = head;
        head = result;
        ListNode addThis = new ListNode(val);
        if(head == null){
            return addThis;
        }
        while(head.next != null && head.next.val < val){
            head = head.next;
        }
        addThis.next = head.next;
        head.next = addThis;
        return result.next;
    }
}

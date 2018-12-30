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
     * @param l1: ListNode l1 is the head of the linked list
     * @param l2: ListNode l2 is the head of the linked list
     * @return: ListNode head of linked list
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode a=l1;  ListNode b=l2;  ListNode result=new ListNode(-1);   ListNode curr=result;
        while(a!=null||b!=null){
            if(a!=null && (b==null ||a.val < b.val)){
                curr.next=a;
                a = a.next;
            } else {    //b must not be null
                curr.next=b;
                b=b.next;
            }
            curr=curr.next;
        }
        return result.next;
    }
}

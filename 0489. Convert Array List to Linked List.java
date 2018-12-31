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
     * @param nums: an integer array
     * @return: the first node of linked list
     */
    public ListNode toLinkedList(List<Integer> nums) {
        ListNode result = new ListNode(-1); ListNode curr=result;
        for(int num:nums){
            curr.next=new ListNode(num);
            curr=curr.next;
        }
        return result.next;
    }
}

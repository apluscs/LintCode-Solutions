public class Solution {
    /**
     * @param head: the given linked list
     * @return:  the weighted sum in reverse order
     */
    public int weightedSumReverse(ListNode head) {  //better than 64% of submissions, whereas recursion beats 97%. How is 
     //recursion better?
        int weight=0;
        ListNode start=head;
        while(head!=null){
            weight++;
            head=head.next;
        }
        int result=0;
        while(start!=null){ 
            result+= weight-- *start.val;
            start=start.next;
        }
        return result;
    }
}

public class Solution {
    /**
     * @param head: the given linked list
     * @return:  the weighted sum in reverse order
     */
    public int weightedSumReverse(ListNode head) {
        int result=0;
        while(head!=null){
            result+= weight(head) *head.val;
            head=head.next;
        }
        return result;
    }
    
    public int weight(ListNode curr){
        if(curr==null) return 0;
        return weight(curr.next)+1;
    }
}

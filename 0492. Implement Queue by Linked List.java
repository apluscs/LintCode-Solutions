public class MyQueue {
    /*
     * @param item: An integer
     * @return: nothing
     */
    private ListNode head=new ListNode(-1); //marks last dequeued node
    private ListNode curr=head; //marks last placed node
    
    public void enqueue(int item) {
        curr.next=new ListNode(item);
        curr=curr.next;
    }

    /*
     * @return: An integer
     */
    public int dequeue() {
        int result=head.next.val;
        head=head.next;  
        // head.next=head.next.next;    This won't work if you dequeue when there is only one number in the queue
        return result;
    }
}

class ListNode{
    int val;
    ListNode next;
    ListNode(int val){
        this.val=val;
        this.next=null;
    }
}

public class Dequeue {
    ListNode start = new ListNode(-1);  //marks the node last discarded
    ListNode end = start;   //marks last relevant node
    
    public void push_front(int item) {
        ListNode curr=new ListNode(item);
        curr.next=start.next;
        start.next=curr;
        curr.prev=start;
        if(curr.next!=null){
            curr.next.prev=curr;
        } else{
            end=curr;   //if it's the only node in the queue
        }
    }
    
    public void push_back(int item) {
        ListNode curr=new ListNode(item);
        curr.prev=end;
        end.next=curr;
        end=end.next;
    }
    
    public int pop_front() {
        start=start.next;
        return start.val;
    }
    
    public int pop_back() {
        int result=end.val;
        end=end.prev;
        end.next=null;  //cuts off the one we removed
        return result;
    }
}

class ListNode{
    int val;
    ListNode prev;
    ListNode next;
    public ListNode(int val){
        this.val=val;
    }
}

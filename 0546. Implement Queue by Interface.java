interface InterfaceQueue {
    void push(int val);
    int pop();
    int top();
    // define an interface for pop method
    /* write your code here */

    // define an interface for top method
    /* write your code here */
}

public class MyQueue implements InterfaceQueue{
    
    ListNode head = new ListNode(-1), tail=head;    //tail is last one added, head is last one discarded
    public MyQueue() {  //confusion: where was class ListNode defined??
    }

    // implement the push method
    public void push(int val){
        tail.next=new ListNode(val);
        tail=tail.next;
        
    }

    @Override
    public int pop() {
        head=head.next;
        return head.val;
    }

    @Override
    public int top() {
        return head.next.val;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue queue = new MyQueue();
 * queue.push(123);
 * queue.top(); will return 123;
 * queue.pop(); will return 123 and pop the first element in the queue
 */

public class Stack {
    /*
     * @param x: An integer
     * @return: nothing
     */
    
    Queue<Integer> que = new LinkedList<>();
    Queue<Integer> temp = new LinkedList<>();
    int last;   //last added number
    
    public void push(int x) {
        que.offer(x);
        last=x;
    }

    public void pop() { 
        while(que.size()>1){
            temp.offer(que.poll());  //moving que to rue in the same order
        }
        que.clear();    //except the top one in que is discarded
        while(temp.size()>0){
            if(temp.size() ==1){
                last=temp.peek();
            }
            que.offer(temp.poll());  //moving rue back to que in same order
        }
    }

    public void pop2() { 
        while(que.size()>1){
            temp.offer(que.poll());  //moving que to rue in the same order
        }
        que.clear();    //except the top one in que is discarded
        while(temp.size()>1){
            que.offer(temp.poll());  //moving rue back to que in same order
        }
        if(temp.size()==1){
            last=temp.peek();
            que.offer(temp.poll());
        } 
    }
    
    public int top() {
        return last;
    }

    public boolean isEmpty() {
        return que.isEmpty();
    }
}

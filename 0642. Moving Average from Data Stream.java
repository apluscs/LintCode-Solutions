public class MovingAverage {
    
    Queue<Integer> window=new LinkedList<>();
    long sum=0;
    int max;
    
    /*
    * @param size: An integer
    */public MovingAverage(int size) {
        max=size;
    }

    /*
     * @param val: An integer
     * @return:  
     */
    public double next(int val) {
        window.offer(val);
        if(window.size() <= max){
            sum+= val;
        } else {
            sum+=val -window.poll();    //discard the first one added
        }
         return (double)sum/window.size(); 
    }
}

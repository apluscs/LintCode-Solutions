public class Tower {
    private Stack<Integer> disks;
    /*
    * @param i: An integer from 0 to 2
    */
    public Tower(int i) {
        disks=new Stack<>();
    }

    /*
     * @param d: An integer
     * @return: nothing
     */
    public void add(int d) {
        // Add a disk into this tower
        if (!disks.isEmpty() && disks.peek() <= d) {
            System.out.println("Error placing disk " + d);
        } else {
            disks.push(d);
        }
    }

    /*
     * @param t: a tower
     * @return: nothing
     */
    public void moveTopTo(Tower t) {
        t.add(disks.pop());   //disks.pop() is top disk of this Tower
    }

    /*
     * @param n: An integer
     * @param destination: a tower
     * @param buffer: a tower
     * @return: nothing
     */
    public void moveDisks(int n, Tower destination, Tower buffer) {
        if(n==1){
            moveTopTo(destination);
            return;
        }
        moveDisks(n-1,buffer,destination);
        moveTopTo(destination);
        buffer.moveDisks(n-1,destination,this);
    }

    public Stack<Integer> getDisks() {
        return disks;
    }
}

/**
 * Your Tower object will be instantiated and called as such:
 * Tower[] towers = new Tower[3];   
 * for (int i = 0; i < 3; i++) towers[i] = new Tower(i);
 * for (int i = n - 1; i >= 0; i--) towers[0].add(i);   
 * towers[0].moveDisks(n, towers[2], towers[1]);
 * print towers[0], towers[1], towers[2]
*/

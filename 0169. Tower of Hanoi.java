public class Solution {
    /**
     * @param n: the number of disks
     * @return: the order of moves
     */
    public List<String> towerOfHanoi(int n) {
        List<String> result=new ArrayList<>();
        int[] towers = new int[] {n,0,0};
        moveDisks(result, towers, 'A', 'C', 'B', n);
        return result;
    }
    
    public void moveDisks(List<String> result, int[] towers, char curr, char dest, char buff, int disks){
        if(disks==1){
            result.add("from " + curr + " to "+dest);
            towers[curr-'A']--;
            towers[dest-'A']++;
            return;
        }
        moveDisks(result, towers, curr, buff, dest, disks-1);   //move all except bottom to buffer
        moveDisks(result, towers, curr, dest, buff, 1); //move bottom to destination
        moveDisks(result, towers, buff, dest, curr, disks-1);   //move [everything you moved onto buffer] now onto destination
    }
}

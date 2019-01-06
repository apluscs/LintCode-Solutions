public class Solution {
    /**
     * @param n: a non-negative integer
     * @return: the total number of full staircase rows that can be formed
     */
    public int arrangeCoins(int n) {
        int sum=0;
        for(int i=1;i<Integer.MAX_VALUE;i++){
            sum+=i;
            if(sum>n){
                return i-1;
            }
        }
        return -1;
    }
}

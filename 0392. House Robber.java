public class Solution {
    /**
     * @param A: An array of non-negative integers
     * @return: The maximum amount of money you can rob tonight
     */
    public long houseRobber(int[] A) {
        if (A.length == 0) return 0;
        long[] result = new long[A.length + 1]; //result[i+1] answers "what if you only reached house A[i]?"
        result[0] = 0;
        result[1] = A[0];
        for (int i = 1; i < A.length; i++) {
            result[i + 1] = Math.max(result[i - 1] + A[i], result[i]); //take this house along with max 2 houses before OR skip it?
        }
        return result[A.length];
    }
}

public class Solution {
    /**
     * @param nums: an array
     * @return: the number of longest increasing subsequence
     */
    public int findNumberOfLIS(int[] nums) {
        if (nums.length == 0) return 0;
        int max = 1; //length of LIS
        int[] dp = new int[nums.length];
        int[] ways = new int[nums.length];
        dp[0] = ways[0] = 1; //LIS for one element
        for (int i = 1; i < nums.length; i++) { //pulled from 76. LIS
            int longest = 0; //default
            int numWays = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] <= nums[j]) { //strictly less than nums[i]
                    continue;
                }
                if (dp[j] == longest) {
                    numWays += ways[j];
                } else if (dp[j] > longest) { //found a new LIS
                    numWays = ways[j];
                    longest = dp[j];
                }
            }
            dp[i] = longest + 1;
            ways[i] = Math.max(1, numWays); //at least one way to get to this LIS
            max = Math.max(max, longest + 1);
        }
        int result = 0;
        for (int sbq = 0; sbq < dp.length; sbq++) {
            if (dp[sbq] == max) { //found a set of LIS's
                result += ways[sbq];
            }
        }
        return result;

    }
}

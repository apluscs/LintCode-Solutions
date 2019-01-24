public class Solution {
    /**
     * @param nums: An integer array
     * @return: The length of LIS (longest increasing subsequence)
     */
    public int longestIncreasingSubsequence(int[] nums) {
        if (nums.length == 0) return 0;
        int result = 0;
        int[] dp = new int[nums.length];
        dp[0] = 1; //LIS for one element
        for (int i = 1; i < nums.length; i++) {
            int longest = 1; //default
            for (int j = 0; j < i; j++) {
                if (nums[i] <= nums[j]) { //must find an element to the left that is strictly less than nums[i]
                    continue;
                }
                longest = Math.max(longest, dp[j] + 1);
            }
            dp[i] = longest;
            result = Math.max(result, longest);
        }
        return result;
    }
}

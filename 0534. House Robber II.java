public class Solution {
    /**
     * @param nums: An array of non-negative integers.
     * @return: The maximum amount of money you can rob tonight
     */
    public int houseRobber2(int[] nums) {
        int total = nums.length;
        if (total == 0) return 0;
        if (total == 1) return nums[0];
        int[] result = new int[total];
        result[0] = 0;
        result[1] = nums[0];
        for (int i = 2; i < total; i++) { //if you take the first house, you can't take the last house; result is one spot ahead of nums
            result[i] = Math.max(nums[i - 1] + result[i - 2], result[i - 1]);
        }
        int case1 = result[total - 1];

        result[0] = 0;
        result[1] = nums[1];
        for (int i = 2; i < total; i++) { //if you skip the first house, result extends to traversing the last house; nums and result are aligned in terms of last house visited
            result[i] = Math.max(nums[i] + result[i - 2], result[i - 1]);
        }
        return Math.max(case1, result[total - 1]);
    }
}

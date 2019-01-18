public class Solution {
    /**
     * @param nums: an integer array and all positive numbers, no duplicates
     * @param target: An integer
     * @return: An integer
     */
    public int backPackVI(int[] nums, int target) {
        int[] able = new int[target + 1];
        able[0] = 1;
        for (int t = 1; t <= target; t++) { //current target
            for (int n: nums) {
                int diff = t - n;
                if (diff >= 0) {
                    able[t] += able[diff]; //number of ways to get to "t" if n is last coin used
                }
            }
        }
        return able[target];
    }
}

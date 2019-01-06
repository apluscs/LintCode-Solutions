public class Solution {
    /**
     * @param nums: An array of integers
     * @return: An integer
     */
    public int maxProduct(int[] nums) {
        int result = nums[0], currMin = result, currMax = result;
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            int min = 0, max = 0;
            if (num >= 0) {
                max = Math.max(num * currMax, num); //ask: want to start a new subarray or continue the old one?
                min = Math.min(num * currMin, num);
            } else {
                max = Math.max(num * currMin, num); //currMin is actually useful when we consider the prospect of multiplying two negative numbers
                min = Math.min(num * currMax, num);
            }

            currMax = max;
            currMin = min;
            result = Math.max(currMax, result);
        }
        return result;
    }
}

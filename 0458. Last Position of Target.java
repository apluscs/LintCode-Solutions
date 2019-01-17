public class Solution {
    /**
     * @param nums: An integer array sorted in ascending order
     * @param target: An integer
     * @return: An integer
     */
    public int lastPosition(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) { //include "or equal to" to make final needed change
            int mid = (low + high) / 2;
            if (nums[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        int count = 0;
        if (low < 0 || low >= nums.length || nums[low] != target) { //one bad solution
            count++;
        }
        if (high < 0 || high >= nums.length || nums[high] != target) { //possibly another bad solution
            count++;
        }
        if (count == 2) return -1;
        return high;
    }
}

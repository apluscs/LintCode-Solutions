public class Solution {
    /**
     * @param target: the target
     * @param array: an array
     * @return: the closest value
     */
    public int closestTargetValue(int target, int[] array) {
        Arrays.sort(array);
        int low = 0;
        int high = array.length - 1;
        int diff = Integer.MAX_VALUE;
        int result = -1;
        while (low < high) {
            int sum = array[low] + array[high];
            if (sum - target <= 0 && target - sum < diff) {
                diff = target - sum;
                result = sum;
            }
            if (sum > target) {
                high--;
            } else {
                low++;
            }
        }
        return result;
    }
}

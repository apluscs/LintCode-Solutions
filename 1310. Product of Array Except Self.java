public class Solution {
    /**
     * @param nums: an array of integers
     * @return: the product of all the elements of nums except nums[i].
     */
    public int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length]; //product of everything to the left
        int[] right = left.clone(); //product of everything to the right
        int prod = 1;
        left[0] = right[right.length - 1] = 1;
        for (int i = 1; i < left.length; i++) {
            prod *= nums[i - 1];
            left[i] = prod;
        }
        prod = 1;
        for (int i = right.length - 2; i >= 0; i--) {
            prod *= nums[i + 1];
            right[i] = prod;
        }

        for (int i = 0; i < nums.length; i++) { //overwrites nums
            nums[i] = left[i] * right[i];
        }
        return nums;
    }
}

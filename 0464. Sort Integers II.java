public class Solution {
    /**
     * @param A: an integer array
     * @return: nothing
     */
    public void sortIntegers2(int[] A) {
        partition(A, 0, A.length - 1);
    }

    public void partition(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int pivot = nums[end]; //uses last value in range
        int pos = start;
        for (int i = start; i < end; i++) {
            if (nums[i] < pivot) {
                swap(nums, i, pos++);
            }
        }
        swap(nums, end, pos);
        partition(nums, start, pos - 1);
        partition(nums, pos + 1, end);
    }

    public void swap(int[] nums, int a, int b) {
        int temp = nums[b];
        nums[b] = nums[a];
        nums[a] = temp;
    }
}

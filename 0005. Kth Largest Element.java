public class Solution {
    /**
     * @param n: An integer
     * @param nums: An array
     * @return: the Kth largest element
     */
    public int kthLargestElement(int n, int[] nums) {
        if (nums == null || nums.length == 0 || n < 1 || n > nums.length) {
            return -1;
        }
        quickSelect(nums, 0, nums.length - 1, n - 1); //nth largest element means index n-1 must be good
        return nums[n - 1];

    }

    public void quickSelect(int[] nums, int start, int end, int k) {
        if (start >= end) return;
        int pivot = nums[end]; //uses last value in range
        int pos = start;
        for (int i = start; i < end; i++) {
            if (nums[i] > pivot) {
                swap(nums, i, pos++);
            }
        }
        swap(nums, end, pos);
        if (k < pos) { //stops when element at k is placed correctly
            quickSelect(nums, start, pos - 1, k);
        } else if (k > pos) { //range of quickSelect converges to k-1
            quickSelect(nums, pos + 1, end, k);
        }

    }
    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}

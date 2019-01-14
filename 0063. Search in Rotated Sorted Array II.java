public class Solution {
    /**
     * @param A: an integer rotated sorted array
     * @param target: an integer to be searched
     * @return: an integer
     */
    public boolean search(int[] A, int target) {
        if (A.length == 0) return false;
        int min = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] < A[i - 1]) {
                min = i;
                break;
            }
        }
        if (A[min] == target) return true;
        int low, high;
        if (A[0] < target && min != 0) { //must be in first part or not at all
            low = 0;
            high = min - 1;
        } else {
            low = min;
            high = A.length - 1;
        } //now binary search acccording to set range
        while (low <= high) {
            int mid = (low + high) / 2;
            if (A[mid] == target) {
                return true;
            } else if (A[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }
}

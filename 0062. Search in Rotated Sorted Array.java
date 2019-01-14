public class Solution {
    /**
     * @param A: an integer rotated sorted array
     * @param target: an integer to be searched
     * @return: an integer
     */
    public int search(int[] A, int target) {
        if (A.length == 0) return -1;
        int min = 0; //index of lowest number
        for (int i = 1; i < A.length; i++) {
            if (A[i] < A[i - 1]) {
                min = i;
                break;
            }
        }
        if (A[min] == target) return min;
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
                return mid;
            } else if (A[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}

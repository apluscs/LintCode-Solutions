public class Solution {
    /**
     * @param A: an integer sorted array
     * @param target: an integer to be inserted
     * @return: a list of length 2, [index1, index2]
     */
    public int[] searchRange(int[] A, int target) {
        int[] result = new int[2];
        int low = 0;
        int high = A.length;
        int loca = -1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (A[mid] == target) {
                loca = mid;
                break;
            } else if (target < A[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        if (loca == -1) { //target was not found
            result[0] = result[1] = -1;
            return result;
        }
        while (loca > 0 && A[loca - 1] == target) { //finds starting instance of target
            loca--;
        }
        result[0] = loca;
        while (loca < A.length - 1 && A[loca + 1] == target) { //last instance of target
            loca++;
        }
        result[1] = loca;
        return result;
    }
}

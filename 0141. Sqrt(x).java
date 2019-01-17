public class Solution {
    /**
     * @param x: An integer
     * @return: The sqrt of x
     */
    public int sqrt(int x) {
        if (x < 1) return 0;
        int low = 0;
        int high = x;
        while (low <= high) {
            int mid = (low + high) / 2;
            long sqr = (long) mid * mid;
            if (sqr <= x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high;
    }
}

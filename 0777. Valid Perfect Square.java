public class Solution {
    /**
     * @param num: a positive integer
     * @return: if num is a perfect square else False
     */
    public boolean isPerfectSquare(int x) {
        if (x < 0) return false;
        int low = 0;
        int high = x; //this code is pulled from 141. Sqrt(x)
        while (low <= high) {
            int mid = (low + high) / 2;
            long sqr = (long) mid * mid;
            if (sqr <= x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        if (low * low == x || high * high == x) {
            return true;
        }
        return false;
    }
}

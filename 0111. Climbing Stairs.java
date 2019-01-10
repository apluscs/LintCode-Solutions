public class Solution {
    /**
     * @param n: An integer
     * @return: An integer
     */
    public int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 0) return 0;
        int prev = 2, dubPrev = 1; //#ways to get to preceding step, #ways to get to two steps before
        for (int i = 3; i <= n; i++) {
            int next = prev + dubPrev;
            dubPrev = prev;
            prev = next;
        }
        return prev;
    }
}

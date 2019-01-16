/**
 * public class GitRepo {
 *     public static boolean isBadVersion(int k);
 * }
 * you can use GitRepo.isBadVersion(k) to judge whether 
 * the kth code version is bad or not.
 */
public class Solution {
    /**
     * @param n: An integer
     * @return: An integer which is the first bad version.
     */
    public int findFirstBadVersion(int n) {
        int low = 1;
        int high = n;
        int firstBad = Integer.MAX_VALUE, lastGood = Integer.MIN_VALUE;
        while (low <= high) {
            int mid = (high - low) / 2 + low; //in case n=2147483647 
            if (SVNRepo.isBadVersion(mid)) {
                firstBad = Math.min(mid, firstBad);
                high = mid - 1;
            } else { //found false
                lastGood = Math.max(mid, lastGood);
                low = mid + 1;
            }
            if (lastGood == firstBad - 1) {
                return firstBad;
            }
        }
        return 1; //what if result is 1?
    }
}

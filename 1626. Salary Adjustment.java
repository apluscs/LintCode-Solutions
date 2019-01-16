public class Solution {
    /**
     * @param a: the list of salary
     * @param target: the target of the sum
     * @return: the cap it should be
     */
    public int getCap(int[] sals, int target) {
        if (sals.length == 0) return 0;
        int low = 0;
        int high = target / sals.length + 1; //high is average salary across all workers; 
        while (low < high) {
            int mid = (low + high) / 2;
            if (reachTarget(mid, sals, target)) {
                high = mid;
            } else { //need higher cap to reach target
                low = mid + 1;
            }
        }
        return low;
    }

    private boolean reachTarget(int cap, int[] sals, int target) {
        int sum = 0;
        for (int sal: sals) {
            sum += Math.max(cap, sal);
        }
        return sum >= target;
    }
}

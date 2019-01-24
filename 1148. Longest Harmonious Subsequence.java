public class Solution {
    /**
     * @param nums: a list of integers
     * @return: return a integer
     */
    public int findLHS(int[] nums) {
        if (nums.length < 2) return 0;
        HashMap < Integer, Integer > frq = new HashMap < > ();
        for (int n: nums) {
            frq.put(n, frq.getOrDefault(n, 0) + 1);
        }
        int result = 0; //will remain 0 if none exist
        for (Map.Entry < Integer, Integer > e: frq.entrySet()) {
            int lower = e.getKey();
            int sum = 0;
            if (frq.get(lower + 1) != null) {
                sum = e.getValue() + frq.get(lower + 1);
            }
            result = Math.max(result, sum);
        }
        return result;
    }
}

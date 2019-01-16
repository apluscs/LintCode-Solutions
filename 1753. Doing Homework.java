public class Solution {
    /**
     * @param cost: the cost
     * @param val: the val
     * @return: the all cost
     */
    public long doingHomework(int[] cost, int[] val) {
        long result = 0;
        long[] sumCosts = new long[cost.length];  //sumCosts[i] = all costs before and including this one
        sumCosts[0] = cost[0];  
        for (int i = 1; i < cost.length; i++) {
            sumCosts[i] = sumCosts[i - 1] + cost[i];
        }
        for (int worker: val) {
            long next = search(sumCosts, (long) worker);
            result += next;
        }
        return result;
    }

    public long search(long[] costs, long limit) {
        int low = 0;
        int high = costs.length - 1;
        if (limit >= costs[high]) {
            return costs[high];
        }
        int greatestCan = Integer.MIN_VALUE;
        int leastCant = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = (high + low) / 2;
            if (limit < costs[mid]) { //can't handle this much work
                leastCant = Math.min(leastCant, mid);
                high = mid - 1;
            } else { //might be able to handle more!
                greatestCan = Math.max(greatestCan, mid);
                low = mid + 1;
            }
            if (greatestCan == leastCant - 1) { //never true if desired index is at the very beginning or very end
                return costs[greatestCan];
            }
        }
        return 0; //what if they can't complete any tasks?
    }
}

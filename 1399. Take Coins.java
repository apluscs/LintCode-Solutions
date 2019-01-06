public class Solution {
    /**
     * @param list: The coins
     * @param k: The k
     * @return: The answer
     */
    public int takeCoins(int[] list, int k) {
        int result = 0, sum = 0;
        for (int i = 0; i < k; i++) { //start with all on left end
            sum += list[i];
        }
        result = sum;
        int left = k - 1;
        for (int right = list.length - 1; right >= list.length - k; right--) {
            sum += list[right]; //for every coin you take from the right end, you must give up one from the right edge of the left end
            sum -= list[left--];
            result = Math.max(sum, result);
        }
        return result;
    }
}

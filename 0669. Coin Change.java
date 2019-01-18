public class Solution {
    /**
     * @param coins: a list of integer
     * @param amount: a total amount of money amount
     * @return: the fewest number of coins that you need to make up
     */
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        int[] minCoins = new int[amount + 1]; //min number of coins needed to make i coins
        for (int c: coins)
            if (c <= amount) minCoins[c] = 1; //a starting coin
        for (int t = 1; t <= amount; t++) {
            int min = Integer.MAX_VALUE;
            boolean found = false;
            if (minCoins[t] == 1) continue;
            for (int c: coins) {
                int diff = t - c;
                if (diff >= 0 && minCoins[diff] > 0) {
                    found = true; //found a way to reach value "t"
                    min = Math.min(min, minCoins[diff]);
                }
            }
            if (found) minCoins[t] = min + 1; //adds this coin
            else minCoins[t] = 0; //unable to reach value "t"
        }
        if (minCoins[amount] == 0) return -1;
        return minCoins[amount];
    }
}

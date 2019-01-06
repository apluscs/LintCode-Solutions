public class Solution {
    /**
     * @param n: An integer
     * @return: A boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int n) {
        if (n == 0) return false;
        if (n < 3) return true;
        boolean[] winners = new boolean[n + 1];
        winners[1] = winners[2] = true;
        for (int i = 3; i <= n; i++) {
            winners[i] = !winners[i - 1] || !winners[i - 2]; //if you can get player 2 in a losing position, you will win
        }
        return winners[n];
    }
}

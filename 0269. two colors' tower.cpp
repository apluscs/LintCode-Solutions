class Solution {
  public:
    /**
     * @param red: the number of red stones
     * @param green: the number of green stones
     * @return: return the ans mod 1e9 + 7
     */
    void print(vector < long > & nums) {
      for (auto num: nums) cout << num << " ";
      cout << endl;
    }
  int twoColorsTower(int red, int green) {
    vector < long > prev(red + 1);
    prev[0] = 1; // 1 way to build 0 floors using 0 reds
    int mod = 1e9 + 7;
    for (int i = 1; true; ++i) {
      vector < long > dp(red + 1);
      // dp[j] in the i'th iteration = #ways we can build layers [1, i] using exactly j reds
      bool found = false;
      for (int j = 0; j <= red; ++j) {
        int k = i * (i + 1) / 2 - j; // total - #red = #green needed
        if (i <= j) dp[j] = prev[j - i]; // try using red for this layer, must complete the rest with j-i reds
        if (k <= green) dp[j] += prev[j]; // only if #reds + #greens >= total can we use the same number of reds as we did one level below (and use greens to fill in the rest)
        found = found || dp[j];
        dp[j] %= mod;
      }
      if (!found) break; // can only be false at this point if nothing was possible
      prev = dp;
      // print(dp);
    }
    return accumulate(prev.begin(), prev.end(), 0 L) % mod; // iterate over all #reds 
  }
};

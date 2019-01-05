public class Solution {
    /**
     * @param n an integer
     * @return a list of Map.Entry<sum, probability>
     */
    public List<Map.Entry<Integer, Double>> dicesSum(int n) {
      List<Map.Entry<Integer, Double>> result = new ArrayList<>();
      double[] curr = new double[n * 6 + 1];
      curr[1] = curr[2] = curr[3] = curr[4] = curr[5] = curr[6] = 1.0 / 6;
      double[] next = new double[n * 6 + 1];
      int die = 2;
      while (die <= n) {
        for (int s = die; s <= die * 6; s++) { // sums that can be obtained by #die die
          double prob = 0;
          int min = die - 1; // min value with one less die
          int max = (die - 1) * 6; // max value with one less die
          for (int d = Math.max(1, s - 6); d < s; d++) { // so that starting value is positive
            if (d >= min && d <= max) {
              prob += curr[d] / 6.0; // prob of [rolling 6 diff values with one less die] * prob of
                                     // [rolling the needed value with this newly added dice]
            }
          }
          next[s] = prob;
        }
        curr = next.clone();
        die++;
      }
      for (int s = n; s <= n * 6; s++) {
        result.add(new AbstractMap.SimpleEntry<>(s, curr[s]));
      }
      return result;
    }
  }

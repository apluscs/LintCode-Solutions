public class Solution {
  /**
   * @param a: the array a
   * @return: return the maximum value
   */
  public int getAnswer(int[] a) {
    int result = 0;
    int minOdd = Integer.MAX_VALUE;
    boolean foundMin = false; // need this if there are no odd numbers preceding the value being
                              // examined
    for (int n : a) {
      if (n % 2 == 1) {
        foundMin = true;
        minOdd = Math.min(minOdd, n);
      } else if (foundMin)
        result = Math.max(result, n - minOdd);
    }
    return result;
  }
}

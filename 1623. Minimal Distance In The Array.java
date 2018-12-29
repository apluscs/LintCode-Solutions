public class Solution {
  /**
   * @param a: array a
   * @param b: the query array
   * @return: Output an array of length `b.length` to represent the answer
   */
  public int[] minimalDistance(int[] a, int[] b) {
    int[] result = new int[b.length];
    Arrays.sort(a);
    for (int i = 0; i < b.length; i++) {
      int start = 0;
      int end = a.length - 1;
      int target = b[i];
      while (start + 1 < end) { // so that start and end don't end up at the same value; the closest
                                // they will be is adjacent
        int mid = (start + end) / 2;
        if (a[mid] == target) {
          start = mid;
          break; // not mid + 1 as to include the possibility of a[mid] being an answer; otherwise,
                 // we would have skipped over that possibility completely by not including it in
                 // start or end
        }
        if (a[mid] < target) {
          start = mid;

        } else {
          end = mid;
        }
      }
      int diff = Math.abs(a[start] - target);
      int eiff = Math.abs(a[end] - target);
      if (diff < eiff) {
        result[i] = a[start];
      } else if (eiff < diff) {
        result[i] = a[end];
      } else {  //take the lesser value
        result[i] = Math.min(a[start], a[end]);
      }
    }
    return result;
  }
}

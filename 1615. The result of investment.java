public class Solution {
  /**
   * @param funds: The investment each time
   * @param a: The initial funds of A
   * @param b: The initial funds of B
   * @param c: The initial funds of C
   * @return: The final funds
   */
  public int[] getAns(int[] funds, int a, int b, int c) {
    int[] result = new int[3];
    result[0] = a;
    result[1] = b;
    result[2] = c;
    for (int f = 0; f < funds.length; f++) {
      int min = 0; // index of poorest company
      min = (result[1] < result[0]) ? 1 : 0;
      min = (result[2] < result[min]) ? 2 : min;
      result[min] += funds[f];
    }
    return result;
  }
}

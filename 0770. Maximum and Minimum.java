public class Solution {
  /**
   * @param matrix: an input matrix
   * @return: nums[0]: the maximum,nums[1]: the minimum
   */
  public int[] maxAndMin(int[][] matrix) {
    if (matrix.length == 0)
      return new int[0];
    int[] result = new int[] {matrix[0][0], matrix[0][0]};
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        result[0] = matrix[i][j] > result[0] ? matrix[i][j] : result[0];    //updates max and min in one pass
        result[1] = matrix[i][j] < result[1] ? matrix[i][j] : result[1];
      }
    }
    return result;
  }
}

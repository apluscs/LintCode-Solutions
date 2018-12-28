

public class Solution {
  /**
   * @param matrix: the given matrix
   * @return: True if and only if the matrix is Toeplitz
   */
  public boolean isToeplitzMatrix(int[][] matrix) {
    int M = matrix.length;
    if (M < 2)
      return true;
    int N = matrix[0].length;
    for (int c = 0; c < N; c++) {
      int start = matrix[0][c];
      int col = c; // initial column
      for (int r = 0; r < M && col < N; r++) {
        if (matrix[r][col++] != start) {
          return false;
        }
      }
    }
    for (int r = 1; r < M; r++) { // already checked the diag originating from [0,0]
      int start = matrix[r][0];
      int row = r; // initial row
      for (int c = 0; c < N && row < M; c++) {
        if (matrix[row++][c] != start) {
          return false;
        }
      }
    }
    return true;
  }
}

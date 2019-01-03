public class Solution {
  /**
   * @param board: the board
   * @return: whether the Sudoku is valid
   */
  public boolean isValidSudoku(char[][] board) {
    for (int i = 0; i < 9; i++) {
      boolean[] digits = new boolean[9]; // one per row, making sure the same number doesn't appear
                                         // twice
      for (int j = 0; j < 9; j++) {
        char curr = board[i][j];
        if (curr == '.')
          continue;
        if (digits[curr - '1']) {
          return false;
        }
        digits[curr - '1'] = true;
      }
    }

    for (int i = 0; i < 9; i++) {
      boolean[] digits = new boolean[9]; // ensures uniqueness throughtout the column
      for (int j = 0; j < 9; j++) {
        char curr = board[j][i];
        if (curr == '.')
          continue;
        if (digits[curr - '1']) {
          return false;
        }
        digits[curr - '1'] = true;
      }
    }

    for (int r = 0; r < 3; r++) {
      for (int c = 0; c < 3; c++) {
        if (!checkSquare(r * 3, c * 3, board)) { // marks top left corner of each square
          return false;
        }
      }
    }
    return true;
  }

  public boolean checkSquare(int row, int col, char[][] board) {
    boolean[] digits = new boolean[10];
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        char curr = board[i + row][j + col];
        if (curr == '.')
          continue;
        if (digits[curr - '1']) {
          return false;
        }
        digits[curr - '1'] = true;
      }
    }
    return true;
  }
}

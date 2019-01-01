public class Solution {
  /**
   * @param map: the map
   * @return: can you reach the endpoint
   */

  public boolean reachEndpoint(int[][] map) {
    int m = map.length;
    if (m == 0)
      return false;
    int n = map[0].length;
    Queue<Integer> toVisit = new LinkedList<>();
    toVisit.offer(0);


    while (!toVisit.isEmpty()) {
      int id = toVisit.poll(); // FIFO
      int col = id % n;
      int row = id / n;
      if (map[row][col] == 9)
        return true;
      map[row][col] = -1; // mark as visited
      if (row > 0 && map[row - 1][col] > 0) { // checks if neighbor is unvisited and if not an
                                              // obstacle
        toVisit.offer(n * (row - 1) + col);
      }
      if (row < m - 1 && map[row + 1][col] > 0) {
        toVisit.offer(n * (row + 1) + col);
      }
      if (col > 0 && map[row][col - 1] > 0) {
        toVisit.offer(n * row + col - 1);
      }
      if (col < n - 1 && map[row][col + 1] > 0) {
        toVisit.offer(n * row + col + 1);
      }
    }
    return false;
  }
}

public class Solution {
  /**
   * @param Stock: Stock information
   * @return: return id
   */
  public String highestGrowth(List<List<String>> Stock) {
    String maxInd = "";
    double maxRate = 0;
    if (Stock.size() == 0)
      return maxInd;
    for (List<String> stock : Stock) {
      String id = stock.get(0);
      double start = Double.parseDouble(stock.get(1));
      double end = Double.parseDouble(stock.get(2));
      double rate = end / start;
      if (rate > maxRate) {
        maxInd = id;
        maxRate = rate;
      }
    }
    return maxInd;
  }
}

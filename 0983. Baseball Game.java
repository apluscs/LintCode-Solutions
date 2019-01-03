public class Solution {
  /**
   * @param ops: the list of operations
   * @return: the sum of the points you could get in all the rounds
   */
  public int calPoints(String[] ops) {
    Stack<Integer> points = new Stack<>();
    int result = 0;
    for (String op : ops) {
      char c = op.charAt(0);
      if (c == 'D') {
        int last = points.peek();
        points.push(last + last);
        result += last + last;
      } else if (c == 'C') {
        result -= points.pop();
      } else if (c == '+') {
        int last = points.pop(); // need to pop this to access second to last in stack
        int secToLast = points.peek();
        points.push(last);
        points.push(last + secToLast); // adds last two
        result += points.peek();
      } else {
        int point = Integer.parseInt(op);
        result += point;
        points.push(point);
      }
    }
    return result;
  }
}

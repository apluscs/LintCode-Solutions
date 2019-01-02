public class Solution {
  /**
   * @param s: A string
   * @return: whether the string is a valid parentheses
   */
  public boolean isValidParentheses(String s) {
    Stack<Character> open = new Stack<>();
    Stack<Character> close = new Stack<>();
    for (char c : s.toCharArray()) {
      if (c == '(' || c == '[' || c == '{') {   //opening bracket found
        open.push(c);
      } else {
        close.push(c);
        if (open.empty()) {
          return false;
        }
        char lastOpen = open.peek();
        if (lastOpen == '(' && c == ')' || lastOpen == '[' && c == ']'
            || lastOpen == '{' && c == '}') { // check if most recent opening bracket is this closing bracket's partner
          open.pop();
          close.pop();
        } else {
          return false;
        }
      }
    }
    if (open.empty() && close.empty()) { // all opening brackets found their closing partner
      return true;
    }
    return false;
  }
}

public class Solution {
    /*
     * @param stk: an integer stack
     * @return: void
     */
    public void stackSorting(Stack < Integer > input) {
        Stack < Integer > holder = new Stack < > (); //reverse order, smallest on top
        while (!input.empty()) {
            int top = input.pop();
            while (!holder.empty() && holder.peek() < top) { //numbers smaller than top need to be moved out of the way
                input.push(holder.pop());
            }
            holder.push(top);
        }
        while (!holder.empty()) {
            input.push(holder.pop());
        }

    }
}

public class SetOfStacks {

  Stack[] stacks;
  int cap;
  int ind = 0;  // marks next to be added
  
  public SetOfStacks(int capacity) {
    stacks = new Stack[capacity];
    cap = capacity; // max index
    for (int i = 0; i < cap; i++) {
      stacks[i] = new Stack<Integer>(); // need to define type of stack
    }
  }

  public void push(int v) {
    stacks[ind++].push(v); // fills bottom of every stack before "jumping" to another row
    ind %= cap;
  }

   public int pop() {
    ind--;
    if (ind < 0)
      ind += cap;
    return (int) stacks[ind].pop();
  }
}

/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
  /**
   * @param root the root of binary tree
   * @return a lists of linked list
   */
  public List<ListNode> binaryTreeToLists(TreeNode root) {
    List<ListNode> result = new ArrayList<>();
    if (root == null)
      return result;
    Queue<TreeNode> que = new LinkedList<TreeNode>(); // what is left to process
    que.add(root);
    while (!que.isEmpty()) {
      ListNode level = new ListNode(-1); // all the nodes of a certain depth
      ListNode addThis = level;
      int size = que.size(); // starting size; venturing beyond this will reach into the next level
                             // of the tree
      for (int i = 0; i < size; i++) {
        TreeNode curr = que.poll();
        addThis.next = new ListNode(curr.val);
        addThis = addThis.next;
        if (curr.left != null) {
          que.add(curr.left);
        }
        if (curr.right != null) {
          que.add(curr.right);
        }
      }
      result.add(level.next);
    }
    return result;
  }
}

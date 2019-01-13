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
 */


public class Solution {
    /*
     * @param root: The root of the binary search tree.
     * @param node: insert this node into the binary search tree
     * @return: The root of the new binary search tree.
     */
    public TreeNode recur(TreeNode curr, TreeNode target) {
        if (curr == null) {
            curr = new TreeNode(target.val);
        } else if (target.val < curr.val) {
            curr.left = recur(curr.left, target); //must set
        } else { //target.val>curr.val
            curr.right = recur(curr.right, target);
        }
        return curr;
    }
    
    public TreeNode insertNode(TreeNode root, TreeNode target) {
        if (root == null) return target;
        TreeNode curr = root, prev = root, result = root;
        while (curr != null) {
            prev = curr;
            if (target.val < curr.val) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        } //at end, prev points to parent of new node
        if (target.val < prev.val) {
            prev.left = target;
        } else {
            prev.right = target;
        }

        return result;
    }
}

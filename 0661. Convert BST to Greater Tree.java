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
    /**
     * @param root: the root of binary tree
     * @return: the new root
     */

    public int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        recur(root);
        return root;
    }

    public void recur(TreeNode curr) {
        if (curr == null) {
            return;
        }
        recur(curr.right);
        sum += curr.val;
        curr.val = sum;
        recur(curr.left);

    }
    
    public TreeNode noRecurConvertBST(TreeNode root) {
        if (root == null) return root;
        Stack < TreeNode > toVisit = new Stack < > ();
        int sum = 0;
        toVisit.push(root);
        TreeNode curr = root.right;
        while (curr != null || !toVisit.isEmpty()) {
            while (curr != null) {  //before anything, add all nodes right toVisit
                toVisit.push(curr);
                curr = curr.right;
            }
            curr = toVisit.pop();
            sum += curr.val;
            curr.val = sum;
            curr = curr.left;
        }
        return root;
    }
}

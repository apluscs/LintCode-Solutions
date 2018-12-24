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
     * @param root: the root of the binary tree
     * @return: the number of nodes
     */
    public int getAns(TreeNode root) {
        if(root == null){
            return 0;
        }
        return 1 + getAns(root.right) + getAns(root.left);
    }
}

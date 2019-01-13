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
     * @param root: the given BST
     * @param target: the given target
     * @return: the value in the BST that is closest to the target
     */
    public int closestValue(TreeNode root, double target) {
        TreeNode curr = root;
        double diff = (double) Integer.MAX_VALUE;
        int result = root.val; //tracks last visited value
        while (curr != null) {
            double temp = Math.abs(curr.val - target);
            if (temp < diff) {
                diff = temp;
                result = curr.val;
            }
            if (curr.val > target) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
        return result;
    }
}

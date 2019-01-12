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
     * @param root: The root of binary tree.
     * @return: The maximum amount of money you can rob tonight
     */
    public int houseRobber3(TreeNode root) {
        int[] result = dfs(root);
        return Math.max(result[0], result[1]);
    }

    public int[] dfs(TreeNode curr) {
        if (curr == null) {
            return new int[2];
        }
        int[] left = dfs(curr.left);
        int[] right = dfs(curr.right);
        int[] result = new int[2];
        result[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]); //skipping curr node and taking max of whatever is in row below
        result[1] = left[0] + right[0] + curr.val; //if curr is taken, you must skip those in the level below
        return result;
    }
}

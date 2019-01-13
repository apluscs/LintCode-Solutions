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
     * @param root: param root: The root of the binary search tree
     * @param k1: An integer
     * @param k2: An integer
     * @return: return: Return all keys that k1<=key<=k2 in ascending order
     */
    public List < Integer > searchRange(TreeNode root, int k1, int k2) {
        List < Integer > result = new ArrayList < > ();
        dfs(result, root, k1, k2);
        return result;
    }

    public void dfs(List < Integer > result, TreeNode curr, int k1, int k2) {
        if (curr == null) return;
        if (curr.val >= k1 && curr.val <= k2) {
            result.add(curr.val);
        }
        dfs(result, curr.left, k1, k2);
        dfs(result, curr.right, k1, k2);
    }
}

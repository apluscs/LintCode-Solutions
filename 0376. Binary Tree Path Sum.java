**
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
     * @param root: the root of binary tree
     * @param target: An integer
     * @return: all valid paths
     */
     public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(root.val);
        helper(root, result, path, target);
        return result;
    }
    
    public void helper(TreeNode root, List<List<Integer>> result, List<Integer> path, int target){
        if(root.left == null && root.right == null){
            if(sum(path) == target){
                result.add(new ArrayList<>(path));  //must be a clone!
            return;
            } 
        }
        if(root.left != null){
            path.add(root.left.val);
            helper(root.left, result, path, target);
            path.remove(path.size() - 1);
        }
        if(root.right != null){
            path.add(root.right.val);
            helper(root.right, result, path, target);
            path.remove(path.size() - 1);
        }
    }
    
    public int sum(List<Integer> path){
        int result = 0;
        for(int n : path) result += n;
        return result;
    }
}

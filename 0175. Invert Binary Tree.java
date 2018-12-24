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
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    public void invertBinaryTree(TreeNode root) {
        if(root == null) return;
        TreeNode temp = root.left;  //swapping left for right
        root.left = root.right;
        root.right = temp;
        invertBinaryTree(root.left);    
        invertBinaryTree(root.right);
    }
    
    public void noRecursion(TreeNode root) {
        Stack<TreeNode> toVisit = new Stack<>();
        toVisit.push(root);
        while(toVisit.isEmpty() != true){
            TreeNode curr = toVisit.pop();
            TreeNode temp = curr.left;
            curr.left = curr.right;
            curr.right = temp;
            if(curr.left != null){
                toVisit.push(curr.left);
            }
            if(curr.right != null){
                toVisit.push(curr.right);
            }
        }
    }
}

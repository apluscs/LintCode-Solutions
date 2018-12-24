
public class Solution {
    /**
     * @param root: A Tree
     * @return: Preorder in ArrayList which contains node values.
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;

        Stack<TreeNode> nodes = new Stack<>();  //LIFO
        nodes.push(root);
        while(!nodes.isEmpty()){
            TreeNode curr = nodes.pop();
            result.add(curr.val);
            if(curr.right != null){ //must push right on first so that left is accessed first
                nodes.push(curr.right);
            }
            if(curr.left != null){
                nodes.push(curr.left);
            }
        }
        return result;
    }
}

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

public class Solution { //with recursion
    /**
     * @param root: A Tree
     * @return: Preorder in ArrayList which contains node values.
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        helper(root, result);
        return result;
    }
    
    public void helper(TreeNode curr, List<Integer> result){
        result.add(curr.val);
        if(curr.left != null) helper(curr.left, result); //left before right
        if(curr.right != null) helper(curr.right, result);
    }
}

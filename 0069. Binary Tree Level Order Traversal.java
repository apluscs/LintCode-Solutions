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
     * @param root: A Tree
     * @return: Level order a list of lists of integer
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result=new ArrayList<>();
        if(root==null) return result;
        Queue<TreeNode> toVisit = new LinkedList<>();
        toVisit.add(root);
        while(!toVisit.isEmpty()){
            int size=toVisit.size();// starting size; venturing beyond this will reach into the next level
                             // of the tree
            List<Integer> depth=new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode curr=toVisit.poll();
                depth.add(curr.val);
                if(curr.left!=null){
                    toVisit.add(curr.left);
                }
                if(curr.right!=null){
                    toVisit.add(curr.right);
                }
            }
            result.add(depth);
        }
        return result;
    }
}

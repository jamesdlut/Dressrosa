/*
Binary Tree Postorder Traversal
Given a binary tree, return the postorder traversal of its nodes' values.
For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [3,2,1].
*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    // recursion
    public List<Integer> postorderTraversal1(TreeNode root) {
        List<Integer> rst = new ArrayList<Integer>();
        if (root == null) {
            return rst;
        }
        
        dfs(root, rst);
        return rst;
    }
    
    public void dfs(TreeNode root, List<Integer> rst) {
        if (root == null) {
            return;
        }
        
        dfs(root.left, rst);
        dfs(root.right, rst);
        rst.add(root.val);
    }
}

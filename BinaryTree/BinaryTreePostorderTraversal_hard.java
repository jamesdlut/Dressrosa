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
/*
从左到右的后序与从右到左的前序的逆序是一样的, 用另外一个栈进行翻转即可
123 -> 132 -> 231
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
    // iteration
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> rst = new ArrayList<Integer>();
        if (root == null) {
            return rst;
        }
        
        Stack<TreeNode> s = new Stack<TreeNode>();
        Stack<Integer> out = new Stack<Integer>();
        s.push(root);
        while (!s.isEmpty()) {
            TreeNode cur = s.pop();
            out.push(cur.val);
            if (cur.left != null) {
                s.push(cur.left);
            }
            if (cur.right != null) {
                s.push(cur.right);
            }
        }
        
        while (!out.isEmpty()) {
            rst.add(out.pop());
        }
        return rst;
    }
}

/*
226 Invert Binary Tree
Invert a binary tree.
     4
   /   \
  2     7
 / \   / \
1   3 6   9
to
     4
   /   \
  7     2
 / \   / \
9   6 3   1
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
     public TreeNode invertTree1(TreeNode root) {
        if (root == null) {
            return null;
        }
        
        TreeNode tmp = root.right;
        root.right = invertTree1(root.left);
        root.left = invertTree1(tmp);
        return root;
    }
    
    public TreeNode invertTree2(TreeNode root) {
        if (root == null) {
            return null;
        }
        Stack<TreeNode> s = new Stack<TreeNode>();
        s.push(root);
        while (!s.isEmpty()) {
            TreeNode cur = s.pop();
            TreeNode tmp = cur.left;
            cur.left = cur.right;
            cur.right = tmp;
            if (cur.left != null) {
                s.push(cur.left);
            }
            if (cur.right != null) {
                s.push(cur.right);
            }
        }
        return root;
    }
}

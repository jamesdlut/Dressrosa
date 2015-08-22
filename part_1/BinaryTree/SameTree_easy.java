/*
Same Tree
Given two binary trees, write a function to check if they are equal or not.
Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
*/
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isSameTree1(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        } else if (p.val == q.val) {
            if (isSameTree(p.left, q.left) && isSameTree(p.right, q.right)) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
    
    public boolean isSameTree2(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        Stack<TreeNode> s1 = new Stack<TreeNode>();
        Stack<TreeNode> s2 = new Stack<TreeNode>();
        TreeNode cur1 = p;
        TreeNode cur2 = q;
        while (true) {
            while (cur1 != null && cur2 != null) {
                s1.push(cur1);
                s2.push(cur2);
                cur1 = cur1.left;
                cur2 = cur2.left;
            }
            if (cur1 != null || cur2 != null) {
                return false;
            }
            if (s1.isEmpty() && s2.isEmpty()) {
                break;
            }
            cur1 = s1.pop();
            cur2 = s2.pop();
            if (cur1.val != cur2.val) {
                return false;
            }
            cur1 = cur1.right;
            cur2 = cur2.right;
        }
        return true;
    }
}

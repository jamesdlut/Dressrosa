/*
Convert Sorted Array to Binary Search Tree
Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
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
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null) {
            return null;
        }
        
        return buildTree(nums, 0, nums.length - 1);
    }
    
    private TreeNode buildTree(int[] num,  int start, int end) {
        if (start > end) {
            return null;
        }
        
        TreeNode node = new TreeNode(num[(start + end) / 2]);
        node.left = buildTree(num, start, (start + end) / 2 - 1);
        node.right = buildTree(num, (start + end) / 2 + 1, end);
        return node;
    } 
}

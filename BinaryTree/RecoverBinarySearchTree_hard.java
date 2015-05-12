/*
Recover Binary Search Tree
Two elements of a binary search tree (BST) are swapped by mistake.
Recover the tree without changing its structure.
Note:
A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
*/
/*
          8 (4)
         / \
        3  10
       / \   \
      1   6  14
          /\  /
         4 7 13
        (8)
Find the place which the order is wrong.
inorder
For example: 1 3 4 6 7 8 10 13 14 
Wrong order: 1 3 8 6 7 4 10 13 14      
FIND:            ___
Then we find:        ___
8, 6是错误的序列, 但是, 7, 4也是错误的序列。
因为8, 6前面的序列是正确的, 所以8, 6一定是后面的序列交换来的。 
而后面的是比较大的数字, 也就是说8一定是被交换过来的。而7, 4中也应该是小的数字4是前面交换过来的。
*/
/*
inOrder(3)
 inOrder(1)
  pre = 1
 pre = 1 < 3
 pre = 3
 inOrder(6)
  inOrder(8)
   pre = 3 < 8
   pre = 8
  pre = 8 > 6
  first = 8
  second = 6
  pre = 6
  inOrder(7)
   pre = 6 < 7
   pre = 7
pre = 7 > 4
second = 4
inOrder(10)
 pre = 7 < 10
 pre = 10
 inOrder(14)
  inOrder(13)
   pre = 10 < 13
   pre = 13
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
    public void recoverTree(TreeNode root) {
        inOrder(root);
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }
    
    TreeNode pre = null;
    TreeNode first = null;
    TreeNode second = null;
    
    public void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        
        inOrder(root.left);
        if (pre != null && pre.val > root.val) {
            if (first == null) {
                first = pre;
                second = root;
            } else {
                second = root;
            }
        }
        pre = root;
        inOrder(root.right);
    }
}

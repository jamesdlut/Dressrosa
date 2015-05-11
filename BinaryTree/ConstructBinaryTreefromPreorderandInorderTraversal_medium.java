/*
Construct Binary Tree from Preorder and Inorder Traversal
Given preorder and inorder traversal of a tree, construct the binary tree.
Note:
You may assume that duplicates do not exist in the tree.
*/
/*
1. Find the root node from the preorder.(it is the first node.)
2. Try to find the position of the root in the inorder. Then we can get the number of nodes in the left tree.
3. 递归调用，构造左子树和右子树。
*/

/*
Validate Binary Search Tree 
Given a binary tree, determine if it is a valid binary search tree (BST).
Assume a BST is defined as follows:
The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
*/
/*
notice ReturnType (int min, int max, boolean isBST)
dfs(5)
left = dfs(3)
 left = dfs(2)
  left = dfs(1)
   left(null): return ret = new ReturnType(Integer.MAX_VALUE, Integer.MIN_VALUE, true);
   right(null): return ret = new ReturnType(Integer.MAX_VALUE, Integer.MIN_VALUE, true);
   from the return, we can know:
   left.isBST = true, right.isBST = true;
   left.min = Integer.MAX_VALUE, right.min = Integer.MAX_VALUE;
   left.max = Integer.MIN_VALUE, right.max = Integer.MIN_VALUE;
  continue 
  return new ReturnType(Math.min(1, Integer.MAX_VALUE), Math.max(1, Integer.MIN_VALUE), true);
 continue
 left(1): return new ReturnType(Math.min(1, Integer.MAX_VALUE), Math.max(1, Integer.MIN_VALUE), true);
 right(null): return new ReturnType(Integer.MAX_VALUE, Integer.MIN_VALUE, true);
 left.min = 1, right.min = Integer.MAX_VALUE
 left.max = 1 < 2, right.max = Integer.MIN_VALUE 
 root.right == null
 return new ReturnType(Math.min(2, 1), Math.max(2, Integer.MIN_VALUE), true);
...
right = dfs(8)
*/

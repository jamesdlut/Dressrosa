/*
Convert Sorted List to Binary Search Tree
Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
*/
/*
method 1
每次遍历当前list, 找到中间的节点, 建立root, 分别使用递归建立左树以及右树, 并将左右树挂在root之下,
建立root次数为N, 每次遍历最多N次, so the worst case is N^2
method 2
*/

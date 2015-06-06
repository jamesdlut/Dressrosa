/*
Count Complete Tree Nodes
Given a complete binary tree, count the number of nodes.
Definition of a complete binary tree from Wikipedia:
In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
*/
/*
满二叉树(Full Binary Tree):
除最后一层无任何子节点外, 每一层上的所有结点都有两个子结点(最后一层上的无子结点的结点为叶子结点)
若深度为h,
第h层的结点数 = 2^(h - 1)
总结点数 = 2^h - 1 
完全二叉树(Complete Binary Tree):
若设二叉树的深度为h, 除第 h 层外, 其它各层(1 ~ h - 1) 的结点数都达到最大个数, 第 h 层所有的结点都连续集中在最左边
总结点数 [2^(h - 1), 2^h - 1)
e.g. 一棵完全二叉树有770个结点, 则它的叶子结点是259个
*/

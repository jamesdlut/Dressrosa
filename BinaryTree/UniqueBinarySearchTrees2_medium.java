/*
Unique Binary Search Trees II
Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.
For example,
Given n = 3, your program should return all 5 unique BST's shown below.
   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
*/
/*
使用递归来做。
1. 先定义递归的参数为左边界、右边界，即1到n.
2. 考虑从left, 到right 这n个数字中选取一个作为根，余下的使用递归来构造左右子树。 
3. 当无解时，应该返回一个null树，这样构造树的时候，我们会比较方便，不会出现左边解为空，或是右边解为空的情况。
4. 如果说左子树有n种组合，右子树有m种组合，那最终的组合数就是n*m. 把这所有的组合组装起来即可
求出左右子树的所有的可能,
将左右子树的所有的可能性全部组装起来,
先创建根节点,
将组合出来的树加到结果集合中,
null也是一种解，也需要把它加上去。这样在组装左右子树的时候，不会出现左边没有解的情况，或是右边没有解的情况
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
    public List<TreeNode> generateTrees(int n) {
        return dfs(1, n);
    }
    
    public List<TreeNode> dfs(int left, int right) {
        List<TreeNode> ret = new ArrayList<TreeNode>();
        if (left > right) {
            ret.add(null);
            return ret;
        }
        for (int i = left; i <= right; i++) {
            List<TreeNode> lTree = dfs(left, i - 1);
            List<TreeNode> rTree = dfs(i + 1, right);
            for (TreeNode nodeL : lTree) {
                for (TreeNode nodeR : rTree) {
                    TreeNode root = new TreeNode(i);
                    root.left = nodeL;
                    root.right = nodeR;
                    ret.add(root);
                }
            }
        }
        return ret;
    }
}

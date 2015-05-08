/*
Template 1 Traverse
*/
public class Solution {
  public void traverse(TreeNode root) {
    if (root == null) {
      return
    }
    traverse(root.left);
    traverse(root.right);
  }
}
/*
Template 2 Divide & Conquer
*/
public class Solution {
  public ResultType traversal(TreeNode root) {
    // null or leaf
    if (root == null) {
      // do something and return
    }
    
    // Divide
    ResultType left = traversal(root.left);
    ResultType right = traversal(root.right);
    // Conquer
    ResultType result = Merge from left and right
    return result;
  }
}

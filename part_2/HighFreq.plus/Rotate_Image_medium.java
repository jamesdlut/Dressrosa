/*
48 Rotate Image
You are given an n x n 2D matrix representing an image.
Rotate the image by 90 degrees (clockwise).
Follow up:
Could you do this in-place?
*/
public class Solution {
    // SOL 1 naive solution
    public void rotate1(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }
        
        int m = matrix.length;
        
        int[][] rst = new int[m][m];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                rst[j][m - 1 - i] = matrix[i][j];
            }
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = rst[i][j];
            }
        }
    }
    // SOL 2 in-place
    public void rotate2(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        } 
        
        int n = matrix.length;
        int top = 0, bottom = n - 1, left = 0, right = n - 1;
        
        while (n > 1) {
            for (int i = 0; i < n - 1; i++) {
                int tmp = matrix[top][left + i];
                matrix[top][left + i] = matrix[bottom - i][left];
                matrix[bottom - i][left] = matrix[bottom][right - i];
                matrix[bottom][right - i] = matrix[top + i][right];
                matrix[top + i][right] = tmp;
            }
            top++;
            right--;
            left++;
            bottom--;
            
            n = n - 2;
        }
        return;
    }
}

/*
Search a 2D Matrix
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
For example,
Consider the following matrix:
[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
Given target = 3, return true.
*/
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        if (matrix[0] == null || matrix[0].length == 0) {
            return false;
        }
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        // find the row index, the last number <= target
        int start = 0;
        int end = rows - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (matrix[mid][0] == target) {
                return true;
            } else if (matrix[mid][0] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        //should notice the order of if and else if
        if (matrix[end][0] <= target) {
            rows = end;
        } else if (matrix[start][0] <= target) {
            rows = start;
        } else {
            return false;
        }
        
        // find the column index, the number equal to target
        start = 0; 
        end = cols - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (matrix[rows][mid] == target) {
                return true;
            } else if (matrix[rows][mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (matrix[rows][start] == target) {
            return true;
        } else if (matrix[rows][end] == target) {
            return true;
        } else {
            return false;
        }
    }
}

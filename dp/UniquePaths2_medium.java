/*
Unique Paths II
Follow up for "Unique Paths":
Now consider if some obstacles are added to the grids. How many unique paths would there be?
An obstacle and empty space is marked as 1 and 0 respectively in the grid.
For example,
There is one obstacle in the middle of a 3x3 grid as illustrated below.
[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
The total number of unique paths is 2.
Note: m and n will be at most 100.
*/
/*
e.g.
[
  [0, 1, 0, 1]
  [0, 0, 0, 0]
  [0, 0, 0, 0]
]
00 1 01 break
otherwise: 00 1 01 0 02 1 03 0 goes worng
*/
public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            return 0;
        }
        
        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;
        int[][] sum = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            if (obstacleGrid[i][0] == 1) {
                break; // bug: sum[i][0] = 0;  
            } else {
                sum[i][0] = 1;
            }
        }
        for (int i = 0; i < cols; i++) {
            if (obstacleGrid[0][i] == 1) {
                break;
            } else {
                sum[0][i] = 1;
            }
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (obstacleGrid[i][j] == 1) {
                    sum[i][j] = 0;
                } else {
                    sum[i][j] = sum[i - 1][j] + sum[i][j - 1];
                }
            }
        }
        return sum[rows - 1][cols - 1];
    }
}

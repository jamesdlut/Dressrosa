/*
by yimingumass
Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
For example, given the following triangle
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
Note:
Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
*/
/*
SOL 1: REC
sum[i][j] = sum[i + 1][j] + sum[i + 1][j + 1];
*/
public int minimumTotal1(List<List<Integer>> triangle) {
     int rows = triangle.size();
     int[][] sum = new int[rows][rows];
     for (int i = 0; i < rows; i++) {
          for (int j = 0; j < rows; j++) {
               sum[i][j] = Integer.MAX_VALUE;
          }
     }
     return dfs(triangle, 0, 0, sum);
}
public int dfs(List<List<Integer>> triangle, int row, int col, int[][] sum) {
     if (sum[row][col] != Integer.MAX_VALUE) {
          return sum[row][col];
     }
     
     if (row == triangle.size() - 1) {
          sum[row][col] = triangle.get(row).get(col); // bottom-up
     } else {
          int left = dfs(triangle, row + 1, col, sum);
          int right = dfs(triangle, row + 1, col + 1, sum);
          sum[row][col] = triangle.get(row).get(col) + Math.min(left, right);
     }
     return sum[row][col];
}
/*
SOL 2: DP
*/
public int minimumTotal1(List<List<Integer>> triangle) {
     if (triangle == null || triangle.size() == 0) {
          return 0;
     }
     
     int rows = triangle.size();
     int[][] sum = new int[rows][rows];
     
     for (int i = rows - 1; i >= 0; i++) {
          for (int j = 0; j <= i; j++) {
               if (i == rows - 1) {
                    sum[i][j] = triangle.get(i).get(j);
               } else {
                    sum[i][j] = triangle.get(i).get(j) + Math.min(sum[i + 1][j], sum[i + 1][j + 1]);
               }
          }
          return sum[0][0];
     }
}

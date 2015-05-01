/*
by yiming
200. Number of Islands
Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
Example 1:
11110
11010
11000
00000
Answer: 1
Example 2:
11000
11000
00100
00011
*/
/*
time O(n^2) space O(n^2)
11110
11010
11000
00000

i 0
j 0 (0, 0)1

(0, 0)1 dfs not visited (1, 0)1 (0, 1)1

(1, 0)1 dfs (2, 0)1 (1, 1)1
(0, 1)1 dfs (0, 2)1

(2, 0)1 dfs (3, 0)1 (2, 1)0
(1, 1)1 dfs (1, 2)1 
(0, 2)1 dfs (0, 3)0

(3, 0)1 dfs (3, 1)1 (4, 0)0
(1, 2)1 dfs (1, 3)0 (2, 2)0

(3, 1)1 dfs (3, 2)0 (4, 1)0
*/
public class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        boolean[][] visited = new boolean[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    dfs(grid, i, j, visited);
                    count++;
                } 
            }
        }
        return count;
    }
    
    private void dfs(char[][] grid, int i, int j, boolean[][] visited) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return;
        } else if (visited[i][j] || grid[i][j] != '1') { // here limit the bound of land
            return;
        }
        
        visited[i][j] = true;
        dfs(grid, i - 1, j, visited);
        dfs(grid, i + 1, j, visited);
        dfs(grid, i, j - 1, visited);
        dfs(grid, i, j + 1, visited);
    } 
}

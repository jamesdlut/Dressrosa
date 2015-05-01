/*
by yimingumass
Minimum Adjustment Cost
Given an integer array, adjust each integers so that the difference of every adjcent integers are not greater than a given number target.
If the array before adjustment is A, the array after adjustment is B, you should minimize the sum of |A[i]-B[i]|
Note
You can assume each number in the array is a positive integer and not greater than 100 Example
Given [1,4,2,3] and target=1, one of the solutions is [2,3,2,3], the adjustment cost is 2 and it's minimal. Return 2.
*/
/*
D[i][v]: 把index = i的值修改为v，所需要的最小花费
当前index为v时，我们把上一个index从1-100全部过一次，取其中的最小值（判断一下前一个跟当前的是不是abs <= target）
time O(n*A*T)
*/
public class Solution {
/**
* @param A: An integer array. 
* @param target: An integer. 
*/
     public int MinAdjustmentCost(ArrayList<Integer> A, int target) { 
         if (A == null || A.size() == 0) {
              return 0;
         }
         
         int[][] D = new int[A.size()][101];
         for (int i = 0; i < A.size(); i++) {
              for (int j  = 1; j <= 100; j++) {
                   D[i][j] = Integer.MAX_VALUE;
                   if (i == 0) {
                        D[i][j] = Math.abs(j - A.get(i));
                   } else {
                        for (int k = 1; k <= 100; k++) {
                             if (Math.abs(j - k) > target) {
                                  continue;
                             }
                             int dif = Math.abs(j - A.get(i)) + D[i - 1][k];
                             D[i][j] = Math.min(D[i][j], dif);
                        }
                   }
              }
         }
         int ret = Integer.MAX_VALUE;
         for (int i = 1; i <= 100; i++) {
              ret = Math.min(ret, D[A.size() - 1][i]);
         }
         return ret;
     } 
}

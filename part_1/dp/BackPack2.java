/*
by yimingumass
Backpack II
Given n items with size A[i] and value V[i], and a backpack with size m. What's the maximum value can you put into the backpack?
Note
You cannot divide item into small pieces and the total size of items you choose should smaller or equal to m.
Example
Given 4 items with size [2, 3, 5, 7] and value [1, 5, 2, 4], and a backpack with size 10. The maximum value is 9.
*/
// time O(VN)
// space O(VN)
public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A & V: Given n items with size A[i] and value V[i]
     * @return: The maximum value
     */
    public int backPackII(int m, int[] A, int V[]) {
        int[][] nums = new int[A.length + 1][m + 1];

        for (int i = 0; i <= m; i++) {
            nums[0][i] = Integer.MIN_VALUE
        }
        
        for (int i = 0; i < A.length; i++) {
            nums[i][0] = 0;
        }
        
        for (int i = 1; i < A.length; i++) {
            for (int j = 1; j <= m; j++) {
                nums[i][j] = nums[i - 1][j];
                if (j >= A[i]) {
                    nums[i][j] = Math.max(nums[i][j], nums[i - 1][j - A[i]] + v[i]);
                }
            }
        }
        
        int store = Integer.MIN_VALUE;
        for (int i = m; i > 0; i--) {
            store = Math.max(nums[A.length][i], store);
        }
        return store;
    }
}

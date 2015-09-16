/*
K Sum
Given n distinct positive integers, integer k (k <= n) and a number target.
Find k numbers where sum is target. Calculate how many solutions there are?
*/
/*
D[i][j][t]前i个数中，挑出j个数，组成和为t有多少方案
D[0][0][0]表示在一个空集中找出0个数，target为0，则有1个解，就是什么也不挑
（1）我们可以把当前A[i - 1]这个值包括进来，所以需要加上D[i - 1][j - 1][t - A[i - 1]]（前提是t - A[i - 1]要大于0）
（2）我们可以不选择A[i - 1]这个值，这种情况就是D[i - 1][j][t]，也就是说直接在前i-1个值里选择一些值加到target.
*/
public class Solution {
/**
* @param A: an integer array.
* @param k: a positive integer (k <= length(A)) * @param target: a integer
* @return an integer
*/
    public int kSum(int A[], int k, int target) {
        if (target < 0) {
            return 0;
        }
        
        int[][][] D = new int[A.length + 1][k + 1][target + 1];
        
        for (int i = 0; i <= A.length; i++) {
            for (int j = 0; j <= k; j++) {
                for (int m = 0; m <= target; m++) {
                    // 找0个数，目标为0，则一定是有1个解
                    if (j == 0 && t == 0) {
                        D[i][j][t] = 1;
                    } else if (!(i == 0 || j == 0 || t == 0)) {
                        D[i][j][m] = D[i - 1][j][m];
                        if (m >= A[i - 1]) {
                            D[i][j][m] += D[i - 1]D[j - 1][m - A[i - 1]]; 
                        }
                    }
                } 
            }
        }
        return D[A.length][k][target];
    
    }
}

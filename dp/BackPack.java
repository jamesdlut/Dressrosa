/*
by yimingumass
Back Pack
Given n items with size A[i], an integer m denotes the size of a backpack. How full you can fill this backpack?
Note
You can not divide any item into small pieces.
Example
If we have 4 items with size [2, 3, 5, 7], the backpack size is 11, we can select 2, 3 and 5, so that the max size we can fill this backpack is 10. If the backpack size is 12. we can select [2, 3, 7] so that we can fulfill the backpack.
You function should return the max size we can fill in the given backpack.
*/
/*
这个问题不能保证速度比搜索来的快
最坏情况：items的大小 1, 2, 4, 8, 16 … 对2的幂次数据，搜索和dp做速度都是一样，没有优化
time O(N*target)
1 2 3
-> 1 2 ［3］ 4 5 6 可以组成的和这么几种情况 用搜索 3 是由本身的3组成还是由 1 2 组成，重复运算dp来做可以优化
1 2 4
-> 1 2 3 4 5 6 7 三个数组成的和最坏的情况 此情况根本没有重复运算，所以dp没有任何优化
*/
/*
f[i][j] “前i”个数,取出一些能否凑成j, here j is the target number
A = [2, 3, 5, 7] m = 11
i = 0 j = 0 can[1][0] = can[0][0] = true 0 < A[0] j = 1 can[1][1] = can[0][1] = false 1 < A[0] j = 2 can[1][2] = can[0][2] = false 2 = A[0], can[0][2 - 2] = true can[1][2] 
*/
public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     */
    public int backPack(int m, int[] A) {
        boolean[][] can = new boolean[A.length + 1][m + 1];
        for (int i = 0; i <= A.length; i++) {
            for (int j = 0; j <= m; j++) {
               can[i][j] = false; 
            }
        }
        can[0][0] = true;
        for(int i = 0; i < A.length; i++) {
            for (int j = 0; j <= m; j++) {
                can[i + 1][j] = can[i][j];
                if (j >= A[i] && can[i][j - A[i]]) {
                    can[i + 1][j] = true;
                }
            }
        }
        for (int i = m; i > 0; i--) {
            if (can[A.length][i]) {
                return i;
            }
        }
        return 0;
    }
}

/*
by yiming
Median of Two Sorted Arrays
There are two sorted arrays A and B of size m and n respectively. Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
*/
/*
1. 我们借用findKthNumber的思想。先实现findKthNumber，如果是偶数个，则把中间2个加起来平均，奇数就用中间的
2. 为了达到LOG级的复杂度
每次在A，B取前k/2个元素
1). A的元素不够k/2. 则我们可以丢弃B前k/2.
举个栗子：
A: 6 7 8
B: 1 2 3 4 5
k = 8
2). A[mid] < B[mid] (mid是k/2 -1索引处的元素)，这种情况下，我们可以丢弃A前k/2。
举个栗子：
A: 1 2
B: 4 5 6 7 8
k = 4，我们就可以首先排除1，2.
*/
/*
drop the left side of B.
drop the left side of A.
drop the left side of B.
drop the left side of A.
当2者相等，有2种情况：
1. 当k为偶数，则kth存在于任何一个结尾处，其实也是可以丢弃一半的。
2. 当k为奇数，则kth不存在于A,B的left side。也是可以丢弃任意一半。
A: 1 3 4 6 8
B: 1 2 3 6 7 
k = 8 mid = 8 / 2 - 1 = 3
k = 9 mid = 9 / 2 - 1 = 3
*/
public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
        if (A == null || B == null) {
            return 0;
        }
        
        int len = A.length + B.length;
        if (len % 2 == 0) {
            return (double)(dfs(A, B, 0, 0, len / 2) + dfs(A, B, 0, 0, len / 2 + 1)) / 2.0;
        } else {
            return dfs(A, B, 0, 0, len / 2 + 1);
        }
    }
    
    public double dfs(int A[], int B[], int aStart, int bStart, int k) {
        if (aStart >= A.length) {
            return B[bStart + k - 1];
        } else if (bStart >= B.length) {
            return A[aStart + k - 1];
        }
        
        if (k == 1) {
            return Math.min(A[aStart], B[bStart]);
        }
        
        int mid = k / 2 - 1;
        
        if (aStart + mid >= A.length) {
            return dfs(A, B, aStart, bStart + k / 2, k - k / 2);
        } else if (bStart + mid >= B.length) {
            return dfs(A, B, aStart + k / 2, bStart, k - k / 2);
        } else if (A[aStart + mid] > B[bStart + mid]) {
            return dfs(A, B, aStart, bStart + k / 2, k - k / 2);
        } else {
            return dfs(A, B, aStart + k / 2, bStart, k - k / 2);
        }
    }
}

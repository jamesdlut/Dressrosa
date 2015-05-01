/*
by yiming
Merge Sorted Array
Given two sorted integer arrays A and B, merge B into A as one sorted array.
Note:
You may assume that A has enough space (size that is greater or equal to m + n) to hold additional elements from B. The number of elements initialized in A and B are m and n respectively.
*/
public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        int cur = m + n - 1;
        int pA = m - 1; // 指向A的尾部
        int pB = n - 1; // 指向B的尾部
        
        while (cur >= 0) {
            if (pA < 0 || pB < 0) {
                break;
            }
            // 从尾部往前比较
            if (A[pA] > B[pB]) {
                A[cur--] = A[pA--];
            } else {
                A[cur--] = B[pB--];
            }
        }
        
        // copy the left over elements in B to A.
        while (pB >= 0) {
            A[cur--] = B[pB--];
        }
    }
}

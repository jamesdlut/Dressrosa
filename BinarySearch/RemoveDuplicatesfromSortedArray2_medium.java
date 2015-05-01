/*
Remove Duplicates from Sorted Array II
Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?
For example,
Given sorted array A = [1,1,1,2,2,3],
Your function should return length = 5, and A is now [1,1,2,2,3].
*/
public class Solution {
    public int removeDuplicates(int[] A) {
        if (A == null) {
            return 0;
        }
        if (A.length <= 1) {
            return A.length;
        }
        
        // 拷贝2次后就不再拷贝
        boolean canCopy = true;
        int len = 1;
        for (int i = 1; i < A.length; i++) {
            if (A[i] == A[i - 1]) {
                if (!canCopy) {
                    continue;
                } 
                canCopy = false;
            } else {
                canCopy = true;
            }
            A[len] = A[i];
            len++;
        }
        return len;
    }
    
    /*
    public static void main(String[] strs) {
        int[] A = {1, 1, 1, 2, 2, 3};
        removeDuplicates(A);
        
        for (int i : A) {
            System.out.print(i + " ");
        }
    }
    */
}

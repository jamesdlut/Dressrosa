/*
by yiming 
Jump Game
Given an array of non-negative integers, you are initially positioned at the first index of the array. Each element in the array represents your maximum jump length at that position. Determine if you are able to reach the last index. For example: A = [2,3,1,1,4], return true. A = [3,2,1,0,4], return false.
*/
/*
time O(n^2) space O(n) ?
*/
public class Solution {
    public boolean canJump(int[] A) {
        if (A == null || A.length == 0) {
            return false;
        }
        
        int size = A.length;
        boolean[] jump = new boolean[size];
        jump[0] = true;
        for (int i = 1; i < size; i++) {
            for (int x = 1; x <= i; x++) {
                if (jump[i - x] && A[i - x] >= x) {
                    jump[i] = true;
                    break;
                }
            }
        }
        return jump[size - 1]; 
    }
}

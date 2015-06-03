/*
by eamon
Single Number
Given an array of integers, every element appears twice except for one. Find that single one.
Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
*/
public class Solution {
    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        int cur = 0;
        for (int i = 0; i < nums.length; i++) {
            cur ^= nums[i];
        }
        return cur;
        /*
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            int cnt = 0;
            for (int j = 0; j < nums.length; j++) {
                if (cur == nums[j]) {
                    cnt++;
                } 
            }
            if (cnt == 1) {
                return cur;
            }
        }
        return -1;
        */
    }
}

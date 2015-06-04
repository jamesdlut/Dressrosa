/*
Majority Element
Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
You may assume that the array is non-empty and the majority element always exist in the array.
*/
/*
两个数不一样就抵消掉
*/
public class Solution {
    public int majorityElement(int[] nums) {
        int val = 0;
        int cnt = 0;
        for (int i : nums) {
            if (cnt == 0) {
                val = i;
                cnt++;
            } else if (val == i) {
                cnt++;
            } else {
                cnt--;
            }
        }
        return val;
    }
}

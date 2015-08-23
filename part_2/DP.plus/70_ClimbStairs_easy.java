/*
Climbing Stairs
You are climbing a stair case. It takes n steps to reach to the top.
Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
*/
// SOL 1 first we can think about using DFS recursive method. But may cause time limited error.
public class Solution {
    public int climbStairs(int n) {
        if (n <= 1) {
            return n;
        }
        
        if (n == 2) {
            return 2;
        }
        
        return climbStairs(n - 1) + climbStairs(n - 2);
    }
}
// SOL 2

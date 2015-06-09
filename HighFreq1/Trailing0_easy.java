/*
Factorial Trailing Zeroes
Given an integer n, return the number of trailing zeroes in n!.
Note: Your solution should be in logarithmic time complexity.
*/
/*
idea
1. The ZERO comes from 10.
2. The 10 comes from 2 x 5
3. And we need to account for all the products of 5 and 2. likes 4×5 = 20 ...
4. So, if we take all the numbers with 5 as a factor, we'll have way more than enough even numbers to pair with them to get factors of 10
Example One
How many multiples of 5 are between 1 and 23? 
There is 5, 10, 15, and 20, for four multiples of 5. Paired with 2's from the even factors, this makes for four factors of 10, so: 23! has 4 zeros.
Example Two
How many multiples of 5 are there in the numbers from 1 to 100?
because 100 ÷ 5 = 20, so, there are twenty multiples of 5 between 1 and 100.
but wait, actually 25 is 5×5, so each multiple of 25 has an extra factor of 5, e.g. 25 × 4 = 100，which introduces extra of zero.
So, we need know how many multiples of 25 are between 1 and 100? Since 100 ÷ 25 = 4, there are four multiples of 25 between 1 and 100.
Finally, we get 20 + 4 = 24 trailing zeroes in 100!
The above example tell us, we need care about 5, 5×5, 5×5×5, 5×5×5×5 ....
Example Three
By given number 4617.
5^1 : 4617 ÷ 5 = 923.4, so we get 923 factors of 5
5^2 : 4617 ÷ 25 = 184.68, so we get 184 additional factors of 5
5^3 : 4617 ÷ 125 = 36.936, so we get 36 additional factors of 5
5^4 : 4617 ÷ 625 = 7.3872, so we get 7 additional factors of 5
5^5 : 4617 ÷ 3125 = 1.47744, so we get 1 more factor of 5
5^6 : 4617 ÷ 15625 = 0.295488, which is less than 1, so stop here.
Then 4617! has 923 + 184 + 36 + 7 + 1 = 1151 trailing zeroes.
*/
/*
O(log_5(N)) (base 5!) is faster than any polynomial.
Just need to count how many times 5 appears in n! during multiplication in different forms: 5, 25, 125, 625, ...
*/
public class Solution {
    public int trailingZeroes(int n) {
        int cnt = 0;
        while (n > 0) {
            n = n / 5;
            cnt += n;
        }
        return cnt;
    }
}

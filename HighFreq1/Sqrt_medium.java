/*
Sqrt(x)
Implement int sqrt(int x).
Compute and return the square root of x.
*/
/*
二分法 binary search
其实这里有一个非常trick地地方:
就是当循环终止的时候, l一定是偏小, r一定是偏大(实际的值是介于l和r之间的)
比如以下的例子, 90开根号是9.48按照开方向下取整的原则, 我们应该返回L.
以下展示了在循环过程中, L, R两个变量的变化过程
1. System.out.println(sqrt(90));
L R
1 45
1 23
1 12
6 12
9 12
9 10
9
2. System.out.println(sqrt(20));
1 10
1 5
3 5
4 5
4
3. System.out.println(sqrt(3));
1 2
*/
public class Solution {
    public int mySqrt(int x) {
        if (x == 1 || x == 0) {
            return x;
        }
        
        int left = 1;
        int right = x;
        
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            int quo = x / mid;
            
            if (quo == mid) {
                return quo;
            } else if (quo < mid) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return left;
    }
}

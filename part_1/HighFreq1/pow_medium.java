/*
Pow(x, n) 
Implement pow(x, n).
*/
/*
使用二分法
正数的时候, 先求n/2的pow, 再两者相乘即可
如果n是负数, 所有计算完成后, 执行x = 1 / x就行
当n = -2147483648必须要特别处理, 因为对这个数取反会得到相同的数(已经越界), 所以当n为负时, 先加个1再说
note: int 32 bits (-2147483648, 2147483647) (-2^31, 2^31)
注意n % 2如果为1, 记得再乘以x
*/
public class Solution {
    public double myPow(double x, int n) {
        if (x == 0) {
            return 0;
        }
        
        if (n == 0) {
            return 1;
        }
        
        if (n < 0) {
            double ret = x * myPow(x, -(n + 1));
            return (double)1 / ret;
        }
        
        double ret = myPow(x, n / 2);
        ret = ret * ret;
        if (n % 2 != 0) {
            ret = ret * x;
        }
        return ret;
    }
}

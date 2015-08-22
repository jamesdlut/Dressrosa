/*
Fast Power
Calculate the a^n % b where a, b and n are all 32bit integers.
Example
For 2^31 % 3 = 2
For 100^1000 % 1000 = 0
Challenge
O(logn)
*/
/*
实际上这题应该是suppose n > 0的,
利用取模运算的乘法法则 (a * b) % p = (a % p * b % p) % p
将 a^n % b 分解
*/
public class FastPowSol {
	public static int fastPower1(int a, int b, int n) {
		long ret = pow(a, b, n);
		return (int) ret;
	}
	
	public static long pow(int a, int b, int n) {
		if (a == 0) {
			return 0;
		}
		
		if (n == 0) {
			return 1 % b;
		}
		
		if (n == 1) {
			return a % b;
		}
		
		long ret = 0;
		ret = pow(a, b, n / 2);
		ret *= ret;
		ret %= b;
		
		if (n % 2 == 1) {
			ret *= pow(a, b, 1);
		}
		ret = ret % b;
		return ret;
	}
	
	public static void main(String[] args) {
		System.out.print(fastPower1(2, 3, 31));
	}
}

/*
O(1) Check Power of 2
Using O(1) time to check whether an integer n is a power of 2.
Example
For n=4, return true;
For n=5, return false;
Challenge
O(1) time
*/
/*
bit manipulation
1的个数只能有1个才是power of 2
注意Integer.MIN_VALUE, 这个只有一个1, 但是是false
*/
public class CheckPowSol {
	public static boolean checkPowerOf21(int n) {
		if (n <= 0) {
			return false;
		}

		if ((n & (n - 1)) == 0) {
			return true;
		} else return false;
	}
	
	public static boolean checkPowerOf22(int n) {
		int cnt = 0;
		for (int i = 0; i < 31; i++) {
			if (((n >> i) & 1) == 1) {
				cnt++;
			} 
		}
		if (cnt == 1) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		System.out.print(checkPowerOf21(Integer.MIN_VALUE));
	}
}

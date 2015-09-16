/*
Valid Palindrome
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.
Note:
Have you consider that the string might be empty? This is a good question to ask during an interview.
For the purpose of this problem, we define empty string as valid palindrome.
*/
/*
O(n) runtime, O(1) space
*/
public class isPalindromeSol {
	// SOL 1 Iterator
	public static boolean isPalindrome1(String s) {
		if (s == null) {
			return false;
		}
		int len = s.length();
		int left = 0;
		int right = len - 1;
		String sNew = s.toLowerCase();
		while (left < right) {
			while (left < right && !isNumChar(sNew.charAt(left))) {
				left++;
			}
			while (left < right && !isNumChar(sNew.charAt(right))) {
				right--;
			}
			if (sNew.charAt(left) != sNew.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}
	
	public static boolean isNumChar(char c) {
		if (c <= '9' && c >= '0' || c <= 'z' && c >= 'a' || c <= 'Z' && c >= 'A') {
			return true;
		}
		return false;
	}
	
	public static boolean isPalindrome2(String s) {
		if (s == null) {
			return false;
		}
		int len = s.length();
		boolean ret = true;
		int left = 0;
		int right = len - 1;
		String sNew = s.toLowerCase();
		while (left < right) {
			if (!Character.isLetterOrDigit(sNew.charAt(left))) {
				left++;
			} else if (!Character.isLetterOrDigit(sNew.charAt(right))) {
				right--;
			} else if (sNew.charAt(left) != sNew.charAt(right)) {
				return false;
			} else {
				left++;
				right--;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		String s = "A man, a plan, a canal: Panama";
		System.out.print(isPalindrome2(s));
	}
}

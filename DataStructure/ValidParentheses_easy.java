/*
by yiming
Valid Parentheses
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
*/
/*
使用stack来解决的简单题目. 所有的字符依次入栈
1. 遇到成对的括号弹栈, 弹栈不成对返回false.
2. 栈为空只能压入左括号
3. 扫描完成时, 栈应该为空, 否则返回FALSE.
*/
public class isValidSol {
	public static boolean isValid1(String s) {
		if (s == null || s.length() == 0) {
			return true;
		}
		
		Stack<Character> stack1 = new Stack<Character>();
		int len = s.length();
		for (int i = 0; i < len; i++) {
			char c = s.charAt(i);
			if (stack1.isEmpty()) {
				if (c == ')' || c == ']' || c == '}') {
					return false;
				}
				stack1.push(c);
				continue;
			}
			
			if (c == ')' && stack1.peek() == '('
					|| c == ']' && stack1.peek() == '['
					|| c == '}' && stack1.peek() == '{') {
				stack1.pop();
			} else if (c == '(' || c == '[' || c == '{') {
				stack1.push(c);
			} else {
				return false;
			}
		}
		return stack1.isEmpty();
	}
	
	public static boolean isValid2(String s) {
		if (s == null) {
			return false;
		}
		
		int len = s.length();
		Stack<Character> stack2 = new Stack<Character>();
		for (int i = 0; i < len; i++) {
			char c = s.charAt(i);
			switch(c) {
			case '(':
			case '[':
			case '{':
				stack2.push(c);
				break;
			case ')':
				if (!stack2.isEmpty() && stack2.peek() == '(') {
					stack2.pop();
				} else {
					return false;
				}
				break;
			case ']':
				if (!stack2.isEmpty() && stack2.peek() == '[') {
					stack2.pop();
				} else {
					return false;
				}
				break;
			case '}':
				if (!stack2.isEmpty() && stack2.peek() == '{') {
					stack2.pop();
				} else {
					return false;
				}
				break;
			}
		}
		return stack2.isEmpty();
	}
	/*
	if there are other pairs, like (a, 1) (b, 2) (c, 3)
	*/
	/*
	keySet() includes '(' '[' '{' this section must be put into stack first, following the order of normal sentence
	value() includes ')' ']' '}' then this section later
	*/
	public static boolean isValid3(String s) {
		if (s == null || s.length() % 2 == 1) {
			return false;
		}
		
		HashMap<Character, Character> map = new HashMap<Character, Character>();
		map.put('(', ')');
		map.put('[', ']');
		map.put('{', '}');
		/*
		 * map.put('a', '1');
		 * map.put('b', '2');
		 */
		Stack<Character> stack3 = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (map.containsKey(c)) {
				stack3.push(c);
			} else if (map.containsValue(c)) {
				if (!stack3.isEmpty() && map.get(stack3.peek()) == c) {
					stack3.pop();
				} else {
					return false;
				}
			}
		}
		return stack3.isEmpty();
	}
	
	public static void main(String[] args) {
		String test = "([)]";
		System.out.print(isValid1(test) + "\n");
		System.out.print(isValid2(test) + "\n");
		System.out.print(isValid3(test) + "\n");
	}
}

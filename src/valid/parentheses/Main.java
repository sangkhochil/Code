package valid.parentheses;

import java.util.Stack;

public class Main {

	public static void main(String[] args) {
//		new ValidParentheses().solution(")");
//		new ValidParentheses().solution("(");
		new ValidParentheses().solution(")(){}");		
		new ValidParentheses().solution("()");
		new ValidParentheses().solution("()[]{}");
		new ValidParentheses().solution("(]");
		new ValidParentheses().solution("([)]");
		new ValidParentheses().solution("{[]}");
		new ValidParentheses().solution("({()[][()");
	}
}

class ValidParentheses {
	void solution(String str) {
		System.out.println(str);

		Stack<Character> stack = new Stack<>();
		char[] ch = str.toCharArray();
		for (Character c : ch) {
			if (c == '[' || c == '{' || c == '(') {
				stack.push(c);
			} else {
				if(stack.isEmpty()) {
					System.out.println("Invalid parenthesis..");
					return;
				}
				char tmp = stack.pop();
				if ( c == ']' && tmp == '[') {
					continue;
				} else if ( c == '}' && tmp == '{') {
					continue;
				} else if ( c == ')' && tmp == '(') {
					continue;
				} else {
					System.out.println("Invalid parenthesis..");
					return;
				}
			}

		}
		if (stack.isEmpty())
			System.out.println("Valid parethesis");
		else
			System.out.println("Invalid parenthesis..");
	}
}

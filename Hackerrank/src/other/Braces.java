package other;

import java.util.Scanner;
import java.util.Stack;

public class Braces {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String str = in.next();
		Stack<Character> stack = new Stack<Character>();
		boolean flag = true;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '}') {
				if (!stack.isEmpty() && stack.peek() == '{')
					stack.pop();
				else {
					flag = false;
					break;
				}
			} else if (str.charAt(i) == ')') {
				if (!stack.isEmpty() && stack.peek() == '(')
					stack.pop();
				else {
					flag = false;
					break;
				}
			} else if (str.charAt(i) == ']') {
				if (!stack.isEmpty() && stack.peek() == '[')
					stack.pop();
				else {
					flag = false;
					break;
				}
			} else
				stack.push(str.charAt(i));
		}
		if (!stack.isEmpty())
			flag = false;
		if (flag)
			System.out.println("YES");
		else
			System.out.println("NO");
		in.close();
	}
}

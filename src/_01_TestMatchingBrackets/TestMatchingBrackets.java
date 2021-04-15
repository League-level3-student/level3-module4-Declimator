package _01_TestMatchingBrackets;

import java.util.Stack;

public class TestMatchingBrackets {
	/*
	 * Use a Stack to complete the method for checking if every opening bracket has
	 * a matching closing bracket
	 */
	public static boolean doBracketsMatch(String b) {
		Stack<String> s = new Stack<String>();
		for (int i = b.length()-1; i >=0; i--) {
			s.add(Character.toString(b.charAt(i)));
		}
		int n = 0;
		while (!s.isEmpty()) {
			if (s.pop().equals("{")) {
				n++;
			} else {
				n--;
			}
			if (n < 0) {

				return false;
			}
		}
		if (n == 0) {

			return true;
		} else {

			return false;
		}
	}
}
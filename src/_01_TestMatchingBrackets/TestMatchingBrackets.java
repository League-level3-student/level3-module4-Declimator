package _01_TestMatchingBrackets;

import java.util.Stack;

public class TestMatchingBrackets {
    /*
     * Use a Stack to complete the method for checking if every opening bracket
     * has a matching closing bracket
     */
    public static boolean doBracketsMatch(String b) {
    	Stack<String> s = new Stack<String>();
    	for(int i = 0; i < b.length(); i++) {
    		s.add(b.charAt(i) + "");
    	}
    	int n = 0;
    	while(!s.isEmpty()) {

    		if(s.peek() == "{") {
    			s.pop();
    			n++;
    		}
    		else {
    			s.pop();
    			n--;
    		}
    		if(n < 0) {
    			return false;
    		}
    	}
        return n==0;
    }
}
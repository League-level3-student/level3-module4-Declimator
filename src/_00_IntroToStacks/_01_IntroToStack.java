package _00_IntroToStacks;

import java.util.Random;
import java.util.Stack;

import javax.swing.JOptionPane;

public class _01_IntroToStack {
	public static void main(String[] args) {
		// 1. Create a Stack of Doubles
		// Don't forget to import the Stack class
		Stack<Double> s = new Stack<Double>();
		// 2. Use a loop to push 100 random doubles between 0 and 100 to the Stack.
		for (int i = 0; i < 100; i++) {
			s.push(new Random().nextDouble()*100);
		}
		// 3. Ask the user to enter in two numbers between 0 and 100, inclusive.
		int min = Integer.parseInt(JOptionPane.showInputDialog("Enter two numbers between 0 and 100"));
		while(min < 0 || min > 100){
			min = Integer.parseInt(JOptionPane.showInputDialog("Please enter a number between the bounds"));
		}
		int max = Integer.parseInt(JOptionPane.showInputDialog("Enter two numbers between 0 and 100"));
		while(max < 0 || max > 100){
			max = Integer.parseInt(JOptionPane.showInputDialog("Please enter a number between the bounds"));
		}
		if(max < min) {
			int x = min;
			min = max;
			max = x;
		}
		// 4. Pop all the elements off of the Stack. Every time a double is popped that
		// is
		// between the two numbers entered by the user, print it to the screen.
		System.out.println("Popping elements off stack...\nElements between " + min + " and " + max + ":");
		while (!s.isEmpty()) {
			if (s.peek() > min && s.peek() < max)
				System.out.println(s.pop());
			else
				s.pop();
		}

		// EXAMPLE:
		// NUM 1: 65
		// NUM 2: 75

		// Popping elements off stack...
		// Elements between 65 and 75:
		// 66.66876846
		// 74.51651681
		// 70.05110654
		// 69.21350456
		// 71.54506465
		// 66.47984807
		// 74.12121224
	}
}

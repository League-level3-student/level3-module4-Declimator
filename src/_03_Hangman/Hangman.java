package _03_Hangman;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Hangman {
	JFrame frame;
	JPanel panel;
	JLabel label;

	public static void main(String[] args) {
		Hangman h = new Hangman();
		h.setup();
	}
	public void setup() {
		frame = new JFrame();
		panel = new JPanel();
		label = new JLabel();
		frame.add(panel);
		panel.add(label);
		label.setText("");
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		hman();
	}
	public void hman() {
		Stack<String> s = new Stack<String>();
		int length = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of words to guess (1-100)"));
		while (length < 1 || length > 100) {
			length = Integer.parseInt(JOptionPane.showInputDialog("Please enter a number within the bounds (1-100)"));
		}
		for (int i = 0; i < length; i++) {
			s.push(Utilities.readRandomLineFromFile("dictionary.txt"));
		}
		// delete
		for (int i = 0; i < length; i++) {
			System.out.println(s.get(i));
		}
		//
		int counter = 0;
		String word;
		String vword;
		String state;
		boolean correct = false;
		int guesses = 10;
		while (!s.isEmpty() && guesses > 0) {
			word = s.pop();
			vword = "";
			label.setText("");
			for (int i = 0; i < word.length(); i++) {
				vword = vword + "_";
				label.setText(label.getText() + vword.charAt(i) + " ");
			}
			while (!vword.equalsIgnoreCase(word) && guesses > 0) {
				frame.pack();
				String guess = JOptionPane.showInputDialog("Guess a letter or word (" + guesses + " guesses remaining)");
				for (int i = 0; i < word.length() - guess.length() + 1; i++) {
					if (word.substring(i, i + guess.length()).equalsIgnoreCase(guess)) {
						vword = vword.substring(0, i) + guess + vword.substring(i + guess.length(), vword.length());
					correct = true;
					}
				}
				if(correct == false) {
					guesses-=1;
				}
				label.setText("");
				for (int i = 0; i < word.length(); i++) {
					label.setText(label.getText() + vword.charAt(i) + " ");
				}
				correct = false;
			}
			counter++;
		}
		if(guesses == 0) {
			state = "lost";
		} else {
			state = "won";
		}
		int repeat = JOptionPane.showConfirmDialog(null, "You " + state + ". Play again?");
		if(repeat == 1) {
			label.setText("Game Over. Words Guessed: " + counter);
			frame.pack();
		} else {
			label.setText("");
			hman();
		}
	}
}

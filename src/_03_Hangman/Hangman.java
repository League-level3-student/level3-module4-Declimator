package _03_Hangman;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Hangman implements KeyListener {
	JFrame frame;
	JPanel panel;
	JLabel label;

	public static void main(String[] args) {
		Hangman h = new Hangman();
		h.hman();
	}

	public void hman() {
		frame = new JFrame();
		panel = new JPanel();
		label = new JLabel();
		frame.add(panel);
		panel.add(label);
		label.setText("");
		panel.addKeyListener(this);
		frame.setVisible(true);
		frame.pack();
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
		String word;
		while (!s.isEmpty()) {
			word = s.pop();
			for (int i = 0; i < word.length(); i++) {
				label.setText(label.getText() + "_ ");
			}
			frame.pack();
		}
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}
}

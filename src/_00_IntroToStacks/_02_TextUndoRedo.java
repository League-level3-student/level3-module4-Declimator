package _00_IntroToStacks;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class _02_TextUndoRedo implements KeyListener {
	/*
	 * Create a JFrame with a JPanel and a JLabel.
	 * 
	 * Every time a key is pressed, add that character to the JLabel. It should look
	 * like a basic text editor.
	 * 
	 * Make it so that every time the BACKSPACE key is pressed, the last character
	 * is erased from the JLabel.
	 * 
	 * Save that deleted character onto a Stack of Characters.
	 * 
	 * Choose a key to be the Undo key. Make it so that when that key is pressed,
	 * the top Character is popped off the Stack and added back to the JLabel.
	 */
	JFrame frame;
	JPanel panel;
	JLabel label;
	Stack<String> del;

	public static void main(String[] args) {
		_02_TextUndoRedo m = new _02_TextUndoRedo();
		m.method();
	}

	public void method() {
		del = new Stack<String>();
		frame = new JFrame();
		panel = new JPanel();
		label = new JLabel();
		frame.setVisible(true);
		label.setText("");
		panel.add(label);
		frame.add(panel);
		frame.addKeyListener(this);
		frame.setSize(600, 100);

	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
			if (label.getText().length() > 0) {
				del.add(label.getText().charAt(label.getText().length() - 1) + "");
				label.setText(label.getText().substring(0, label.getText().length() - 1));
			}
		}
		else if (arg0.getKeyCode() == KeyEvent.VK_CONTROL) {
			if(!del.isEmpty())
			label.setText(label.getText() + del.pop());
		} else
			label.setText(label.getText() + arg0.getKeyChar());

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

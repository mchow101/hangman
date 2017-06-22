//Hanmgman with JFrame

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class Hangman extends JPanel implements KeyListener, Runnable {
	Thread t;
	JFrame frame = new JFrame("Hangman");
	boolean game = false;
	int line = -1;
	int[][] hangman = {
			{175, 250, 150, 150},
			{250, 400, 250, 600},
			{250, 475, 200, 425},
			{250, 475, 300, 425},
			{250, 600, 200, 650},
			{250, 600, 300, 650}
	};
	public Hangman() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 800);
		frame.setVisible(true);
		frame.add(this);
		frame.repaint();
		t = new Thread(this);
		t.start();
	}

	public void run() {
		while(true) {
			//do all math or checking stuff here
			frame.repaint();
		}
	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();//ASCII value for the key that was pressed	
		if(key==32 && game==false) {
			game=true;
		}
	}

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();//ASCII value for the key that was pressed		
		if(key==32 && game==false) {
			game=true;
		}
	}

	public void keyTyped(KeyEvent e) {
		int key = e.getKeyCode();//ASCII value for the key that was pressed		
		if(key==32 && game==false) {
			game=true;
		}
	}
	
	public void drawALine(boolean b) {
		game = true;
		line++;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 800, 800);
		g.setColor(Color.WHITE);
		g.setFont(new Font("Times New Roman", Font.PLAIN, 50));
		g.drawString("Welcome to Hangman!", 150, 75);
		g.drawLine(100, 700, 100, 150);
		g.drawLine(50, 700, 150, 700);
		g.drawLine(100, 150, 250, 150);
		g.drawLine(250, 150, 250, 250);
		if(game == true) {
			if(line < 6) {
				for(int i = 0; i <= line; i++) {
					if(i != 0)
						g.drawLine(hangman[i][0], hangman[i][1], hangman[i][2], hangman[i][3]);
					else
						g.drawOval(hangman[i][0], hangman[i][1], hangman[i][2], hangman[i][3]);
				}
			}
			else {
				game = false;
				line = -1;
			}
		}
		else {
			g.drawString("Here are the rules:", 400, 400);
		}
	}
}

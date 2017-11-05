import java.awt.*;
import java.io.*;

import javax.swing.*;
import java.util.Scanner;

@SuppressWarnings("serial")
public class Hangman extends JPanel implements Runnable {
	Thread t;
	JFrame frame = new JFrame("Hangman");
	int line = -1;
	int[][] hangman = {
			{175, 250, 150, 150},
			{250, 400, 250, 600},
			{250, 475, 200, 425},
			{250, 475, 300, 425},
			{250, 600, 200, 650},
			{250, 600, 300, 650}
	};
	boolean gameOn = true;
	String str = "";
	public static Word w = new Word();
	
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
		while(gameOn) {
			frame.repaint();
		}
	}
	
	public void drawALine(boolean b) {
		if(b == true) 
			line++;
	}
	
	public String chooseWord() {
		File file = new File("D:/MyPrograms/Eclipse Workspace/Hangman/src/wordList.txt");
		StringBuffer stringBuffer = new StringBuffer();
		String line = "";
		try {
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			int count = 0;
			int choice = (int)(Math.random()*100) + 1;
			while (count <= choice) {
				count++;
				line = bufferedReader.readLine();
			}
			stringBuffer.append(line);
			fileReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return stringBuffer.toString();
	}
	
	public void createWord(String s) {
		w.setWord(s);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 800, 800);
		g.setColor(Color.WHITE);
		g.setFont(new Font("Times New Roman", Font.PLAIN, 50));
		String txt = "Welcome to Hangman!";
		g.drawLine(100, 700, 100, 150);
		g.drawLine(50, 700, 150, 700);
		g.drawLine(100, 150, 250, 150);
		g.drawLine(250, 150, 250, 250);
		if(gameOn == true) {
			g.setFont(new Font("Times New Roman", Font.PLAIN, 70));
			if(line < 6) {
				for(int i = 0; i <= line; i++) {
					if(i != 0)
						g.drawLine(hangman[i][0], hangman[i][1], hangman[i][2], hangman[i][3]);
					else
						g.drawOval(hangman[i][0], hangman[i][1], hangman[i][2], hangman[i][3]);
				}
			}
			
			if(w.win()) {
				txt = "You win!";
				line = -1;
			}
			if (line >= 6) {
				txt = "You lose!";
				line = -1;
			}
			g.drawString(txt, 150, 75);
			g.drawString(w.print(), 450, 400);
			frame.repaint();
		}
	}

	public static void main(String[]args) {
		Hangman man = new Hangman();
		man.createWord(man.chooseWord());
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		boolean b = true;
		while(b) {
			man.drawALine(w.check(scan.nextLine()));
		}
	}
}

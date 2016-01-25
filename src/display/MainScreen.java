package display;

import java.awt.Color;

import javax.swing.JFrame;

import game.Main;
import game.Settings;


@SuppressWarnings("serial")
public class MainScreen extends JFrame {
	/**
	 * 
	 * @param title
	 *            Title displayed at the top of the window
	 * @param width
	 * @param height
	 */
	public MainScreen(String title, int width, int height) {
		this.setTitle(title);
		this.setSize(width, height);
	}

	public void wakeUp() {
		this.setBackground(Color.black);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.addMouseListener(Main.mouse);
		this.addMouseMotionListener(Main.mouse);
		this.add(Main.msc);
		setSize(this.getWidth()+ 5, this.getHeight()+ 29);
	}
}

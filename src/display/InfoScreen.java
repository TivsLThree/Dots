package display;

import java.awt.Color;

import javax.swing.JFrame;

import game.Main;
import game.Settings;


@SuppressWarnings("serial")
public class InfoScreen extends JFrame {
	/**
	 * 
	 * @param title
	 *            Title displayed at the top of the window
	 * @param width
	 * @param height
	 */
	public InfoScreen(String title, int width, int height) {
		this.setTitle(title);
		this.setSize(width, height);
	}

	public void wakeUp() {
		this.setLocation(Settings.width,0);
		
		this.setBackground(Color.black);
		this.setVisible(true);
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		this.add(Main.isc);
	}
}
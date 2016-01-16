package display;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;
import static game.Main.*;
import entities.Drawable;
import game.Settings;

public class MainScreenCanvas extends JPanel {
	@Override
	public void paintComponent(Graphics graphics) {
		Graphics2D g = (Graphics2D) graphics;
		this.setBackground(Color.black);
		g.setColor(getBackground());
		g.fillRect(0, 0, Settings.width, Settings.height);
		for (Drawable d : obMan.drawables)
			d.draw(g);
		g.dispose();

	}
}

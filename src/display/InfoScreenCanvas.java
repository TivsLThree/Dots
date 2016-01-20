package display;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import game.Main;
import game.Settings;

@SuppressWarnings("serial")
public class InfoScreenCanvas extends JPanel {
	@Override
	public void paintComponent(Graphics graphics) {
		Graphics2D g = (Graphics2D) graphics;
		this.setBackground(new Color(30, 30, 30));
		g.setColor(getBackground());
		g.fillRect(0, 0, Settings.width, Settings.height);

		if (Main.selectedDot != null) {
			g.setColor(Main.selectedDot.getTeam().getColor());
			g.fillRect(0, 0, Settings.width, Settings.height);
			g.setColor(new Color(200, 200, 200));
			g.drawString(Main.selectedDot.uniqueID, 10, 10);
		} else if(Main.selectedDot == null) {
			Main.infoScreen.setVisible(false);
		}
		g.dispose();

	}
}
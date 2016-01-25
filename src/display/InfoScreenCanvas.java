package display;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.HashMap;
import java.util.Map;

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

		if (Main.selectedEntity != null) {
			g.setColor(Main.selectedEntity.team.getColor());
			g.fillRect(0, 0, Settings.width, Settings.height);
			g.setColor(new Color(200, 200, 200));
			int i = 1;
			for (Map.Entry<String, Object> e : Main.selectedEntity.statsForNerds.entrySet()) {
				g.drawString(e.getKey() + e.getValue(), 0, i * 10);
				i++;
			}
		} else if (Main.selectedEntity == null) {
			Main.infoScreen.setVisible(false);
		}
		g.dispose();

	}
}
package display;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Iterator;

import javax.swing.JPanel;
import static game.Main.*;
import entities.Drawable;
import game.Main;
import game.Settings;

public class MainScreenCanvas extends JPanel {
	@Override
	public void paintComponent(Graphics graphics) {
		Graphics2D g = (Graphics2D) graphics;
		this.setBackground(new Color(22, 47, 29));
		g.setColor(getBackground());
		g.fillRect(0, 0, Settings.width, Settings.height);
		Iterator<Drawable> drawables = obMan.drawables.iterator();
		while (drawables.hasNext()) {
			Drawable d = drawables.next();
			d.draw(g);
			if(d.markOfDeath){
				drawables.remove();
			}
		}

		g.dispose();

	}
}

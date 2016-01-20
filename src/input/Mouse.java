package input;

import java.awt.event.MouseEvent;

import javax.swing.SwingUtilities;
import javax.swing.event.MouseInputAdapter;

import entities.Dot;
import game.Main;
import game.Settings;
import world.World;

public class Mouse extends MouseInputAdapter {
	public boolean isPressed = false;
	public int[] pos = { 0, 0 };

	@Override
	public void mouseDragged(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {

		isPressed = true;
		e = SwingUtilities.convertMouseEvent(Main.screen, e, Main.msc);
		pos[0] = e.getX();
		pos[1] = e.getY();
		Main.selectedDot = selectDot();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		isPressed = false;

	}

	private Dot selectDot() {
		int[] pos = Main.mouse.pos;

		if (!isOutOfThisWorld(pos)) {

			if (!isEdge(pos)) {

				pos = convertToMapSize(pos);

				for (Dot e : Main.teams) {
					int[] ePos = e.pos;
			
					if (ePos[0] == pos[0] && ePos[1] == pos[1]) {
						Main.infoScreen.setVisible(true);
						return e;
					}
				}
			}
		}
		return null;
	}

	private static boolean isEdge(int[] i) {
		i = convertToMapSize(i);
		return (i[0] == 0 || i[1] == 0 || i[0] == World.worldMap.length - 1 || i[1] == World.worldMap[0].length - 1);
	}

	private static int[] convertToMapSize(int[] i) {
		int[] cPos = Main.mouse.pos.clone();
		cPos[0] -= Settings.scaleFactor[0];
		cPos[1] -= Settings.scaleFactor[1];
		cPos[0] = i[0] / Settings.scaleFactor[0];
		cPos[1] = i[1] / Settings.scaleFactor[1];
		return cPos;
	}

	private static boolean isOutOfThisWorld(int[] i) {
		return i[0] > Settings.width || i[1] > Settings.height;
	}
}

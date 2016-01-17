package world;

import java.awt.Color;
import java.awt.Graphics2D;

import entities.Drawable;
import static game.Settings.*;

public class World extends Drawable {

	public static int[][] worldMap = new int[worldSize[0]][worldSize[1]];

	public World() {
		super();
		genWorld();
	}

	public void genWorld() {
		// TODO: RNG Map || Map Editor(Text File Saving/Loading).
		// Could use cave generator from previous game.
		for (int i = 0; i < worldMap.length; i++) {
			for (int k = 0; k < worldMap[0].length; k++) {
				worldMap[i][k] = 0;
				worldMap[i][k] = (i == 0 || k == 0 || i == worldMap.length - 1 || k == worldMap[0].length - 1) ? -1
						: worldMap[i][k];

				worldMap[i][k] = ((i != 0 && k != 0 && i != worldMap.length - 1 && k != worldMap[0].length - 1)
						&& Math.random() > 0.99) ? -1 : worldMap[i][k];

			}
		}
	}

	@Override
	public void draw(Graphics2D g) {

		for (int i = 0; i < worldMap.length; i++) {
			for (int k = 0; k < worldMap[0].length; k++) {

				if (worldMap[i][k] == 1) {
					g.setColor(new Color(30, 30, 30));

				} else if (worldMap[i][k] == -1) {
					g.setColor(new Color(100 + (int) (Math.random() * 100), 50 + (int) (Math.random() * 10),
							50 + (int) (Math.random() * 10)));
				} else {
					g.setColor(new Color(32,57,39));
				}
				g.fillRect(i * scaleFactor[0], k * scaleFactor[1], scaleFactor[0] - 1, scaleFactor[1] - 1);

			}
		}
	}

	@Override
	protected void markForDeath() {
		// TODO Auto-generated method stub
		
	}

}

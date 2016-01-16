package world;

import java.awt.Color;
import java.awt.Graphics2D;

import entities.Drawable;
import static game.Settings.*;

public class World extends Drawable {
	
	int[][] worldMap = new int[worldSize[0]][worldSize[1]];

	public World() {
		super();
		genWorld();
	}

	public void genWorld() {
		//TODO: RNG Map || Map Editor(Text File Saving/Loading).
		//Could use cave generator from previous game.
		for (int i = 0; i < worldMap.length; i++) {
			for (int k = 0; k < worldMap[0].length; k++) {
				worldMap[i][k] = (i == 0 || k == 0 || i == worldMap.length-1 || k == worldMap[0].length-1) ? 1: 0;
				
			}
		}
	}

	@Override
	public void draw(Graphics2D g) {

		for (int i = 0; i < worldMap.length; i++) {
			for (int k = 0; k < worldMap[0].length; k++) {
				g.setColor(Color.darkGray);
				if (worldMap[i][k] == 1) {
					g.setColor(new Color(30, 30, 30));
				}
				g.fillRect(i * scaleFactor[0], k * scaleFactor[1], scaleFactor[0] - 1, scaleFactor[1] - 1);

			}
		}
	}
}
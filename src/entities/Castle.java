package entities;

import java.awt.Color;
import java.awt.Graphics2D;

import game.Main;
import game.Settings;

public class Castle extends Entity {
	int spawned = 0;
	double damagedPercent = 0;

	public Castle(Team t, int[] spawnPoint) {
		super("Castle");
		pos = spawnPoint;
		team = t;
	}

	@Override
	public void tick() {
		int numberOfKin = 0;
		for (Dot d : Main.teams) {
			numberOfKin += (d.team == team) ? 1 : 0;
		}
		if (numberOfKin <= 1) {
			Main.teams.add(new Dot(this.team, this.pos.clone()));
			spawned++;
		}
		updateStatForNerds();
	}

	@Override
	public void draw(Graphics2D g) {
		g.setColor(new Color(150, 150, 150, 255));
		g.fillRect((pos[0] * size[0]) - (size[1] / 2), (pos[1] * size[1]) - (size[1] / 2), size[1] * 2, size[1] * 2);
	}

	@Override
	protected void markForDeath() {

	}

	@Override
	public void updateStatForNerds() {
		statsForNerds.put("Spawned:", spawned);
		statsForNerds.put("Damaged Percent:", damagedPercent);
		statsForNerds.put("UUID:", uniqueID);
	}

}

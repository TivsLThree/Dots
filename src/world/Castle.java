package world;

import java.awt.Color;
import java.awt.Graphics2D;

import entities.Dot;
import entities.Entity;
import entities.Team;
import game.Main;
import game.Settings;

public class Castle extends Entity {
	public int[] pos = { 24, 24 };
	public Team team;

	public Castle(Team t, int[] spawnPoint) {
		super();
		pos = spawnPoint;
		team = t;
	}

	@Override
	public void tick() {
		int numberOfKin = 0;
		for (Dot d : Main.teams) {
			numberOfKin += (d.getTeam() == team) ? 1 : 0;
		}
		if (numberOfKin <= 3000) {
			Main.teams.add(new Dot(team,this.pos.clone()));
		}
	}

	@Override
	public void draw(Graphics2D g) {
		g.setColor(new Color(150,150,150,255));
		g.fillRect(pos[0] * Settings.scaleFactor[0], pos[1] * Settings.scaleFactor[1], Settings.scaleFactor[0],
				Settings.scaleFactor[1]);
	}

	@Override
	protected void markForDeath() {

	}
}

package entities;

import java.awt.Color;
import java.awt.Graphics2D;

import game.Settings;

import static game.Settings.*;

public class Dot extends Entity {
	private Team team;

	public Dot(Team t) {
		team = t;

	}
	public Team getTeam(){
		return team;
	}
	@Override
	public void tick() {
		switch (Direction.getRandom()) {
		case DOWN:
			if (pos[1] < Settings.worldSize[1] - 2) {
				pos[1] += 1;
			}
			break;
		case LEFT:
			if (pos[0] > 1) {
				pos[0] -= 1;
			}
			break;
		case RIGHT:
			if (pos[0] < Settings.worldSize[0] - 2) {
				pos[0] += 1;
			}
			break;

		case UP:
			if (pos[1] > 1) {
				pos[1] -= 1;
			}
			break;
		default:
			break;
		}
	}

	@Override
	public void draw(Graphics2D g) {
		g.setColor(team.getColor());

		g.fillRect(pos[0] * size[0], pos[1] * size[1], size[0] - 1, size[1] - 1);
	}

}

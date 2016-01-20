package entities;

import java.awt.Color;
import java.awt.Graphics2D;


import game.Settings;
import world.World;



public class Dot extends Entity {
	private Team team;
	/**
	 * Basically health, once damagedPercent reaches 1, the dot is terminated.
	 */
	private double damagedPercent = 0;
	/**
	 * Basically attack points, deals this much attack percent to opponent's
	 * damagedPercent.
	 */
	@SuppressWarnings("unused")
	private double attackPercentStrength = .25d;

	public Dot(Team t) {
		team = t;

	}

	public Team getTeam() {
		return team;
	}

	private void move() {
		switch (Direction.getRandom()) {
		case DOWN:
			if (pos[1] < Settings.worldSize[1] - 2 && isBlockInPosition(Direction.DOWN, pos)) {
				pos[1] += 1;
			}
			break;
		case LEFT:
			if (pos[0] > 1 && isBlockInPosition(Direction.LEFT, pos)) {
				pos[0] -= 1;
			}
			break;
		case RIGHT:
			if (pos[0] < Settings.worldSize[0] - 2 && isBlockInPosition(Direction.RIGHT, pos)) {
				pos[0] += 1;
			}
			break;

		case UP:
			if (pos[1] > 1 && isBlockInPosition(Direction.UP, pos)) {
				pos[1] -= 1;
			}
			break;
		default:
			break;
		}
	}

	/**
	 * Always call last in the tick method
	 */
	@Override
	public void markForDeath() {
		if (damagedPercent >= 1) {	
			markOfDeath = true;
		}

	}

	@Override
	public void tick() {
		move();
		if(isInLava(pos))
			takeDamage(1);
		markForDeath();
	}

	@Override
	public void draw(Graphics2D g) {
		g.setColor(new Color(team.getColor().getRed(), team.getColor().getGreen(), team.getColor().getBlue(),
				(int) ((1d - Math.min(1d, damagedPercent)) * 255)));

		g.fillRect(pos[0] * size[0], pos[1] * size[1], size[0] - 1, size[1] - 1);
	}

	private boolean isBlockInPosition(Direction d, int[] pos) {
		switch (d) {
		case DOWN:
			return World.worldMap[pos[0]][pos[1] + 1] != 1;

		case LEFT:
			return World.worldMap[pos[0] - 1][pos[1]] != 1;
		case RIGHT:
			return World.worldMap[pos[0] + 1][pos[1]] != 1;
		case UP:
			return World.worldMap[pos[0]][pos[1] - 1] != 1;
		default:
			break;
		}
		return false;
	}

	private boolean isInLava(int[] pos) {
		return World.worldMap[pos[0]][pos[1]] == -1;
	}

	@Override
	protected void takeDamage(double d) {
		damagedPercent += d;
	}

}

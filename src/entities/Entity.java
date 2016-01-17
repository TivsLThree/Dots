package entities;

import java.util.UUID;

import game.Main;
import game.Settings;

public abstract class Entity extends Drawable {
	public boolean markOfDeath = false;
	String uniqueID = UUID.randomUUID().toString();
	public int[] pos = { 60, 40 };
	public int[] size = { Settings.scaleFactor[0], Settings.scaleFactor[1] };

	public Entity() {
		Main.obMan.loadIntoEntities(this);

	}
	protected abstract boolean markForDeath();
	public abstract void tick();

	public void kill() {
		Main.obMan.removeFromEntities(this);
	}
}

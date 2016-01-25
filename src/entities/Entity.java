package entities;

import java.util.HashMap;
import java.util.UUID;

import game.Main;
import game.Settings;

public abstract class Entity extends Drawable {
	public Team team;
	public HashMap<String, Object> statsForNerds = new HashMap<>();
	public final String TYPE;
	public String uniqueID = UUID.randomUUID().toString();
	public int[] pos = { 60, 40 };
	public int[] size = { Settings.scaleFactor[0], Settings.scaleFactor[1] };

	public Entity(String TYPE) {
		this.TYPE = TYPE;
		Main.obMan.loadIntoEntities(this);
		updateStatForNerds();
		
	}
	public abstract void updateStatForNerds();
	public abstract void tick();
	// protected abstract void takeDamage(double d);

}

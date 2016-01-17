package entities;

import java.util.ArrayList;

public class ObjectManager {
	public volatile ArrayList<Drawable> drawables = new ArrayList<>();
	public volatile ArrayList<Entity> entities = new ArrayList<>();
	public void loadIntoDrawables(Drawable e) {
		drawables.add(e);
	}
	public void loadIntoEntities(Entity e) {
		entities.add(e);
	}

}

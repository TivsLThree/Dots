package entities;

import java.util.ArrayList;

public class ObjectManager {
	public ArrayList<Drawable> drawables = new ArrayList<>();
	public ArrayList<Entity> entities = new ArrayList<>();

	public void loadIntoDrawables(Drawable e) {
		drawables.add(e);
	}

	public void removeFromDrawables(Drawable e) {
		drawables.remove(e);
	}

	public void removeFromDrawables(int i) {
		drawables.remove(i);
	}

	public void loadIntoEntities(Entity e) {
		entities.add(e);
	}

	public void removeFromEntities(Entity e) {
		entities.remove(e);
	}

	public void removeFromEntities(int i) {
		entities.remove(i);
	}
}

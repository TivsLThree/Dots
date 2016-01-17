package entities;

import java.awt.Graphics2D;
import static game.Main.*;

public abstract class Drawable {
	public boolean markOfDeath = false;
	public Drawable() {
		obMan.loadIntoDrawables(this);
	}

	public abstract void draw(Graphics2D g);

	protected abstract void markForDeath();
}

package logic;

import java.util.Iterator;

import entities.Dot;
import entities.Entity;
import game.Main;
import game.Settings;
import world.World;

public class GameUpdater {

	public GameUpdater() {

	}

	public void tick() {
		// System.out.println(Main.obMan.drawables.size() + ":"+
		// Main.obMan.entities.size() + ":");
		Main.obMan.entities.trimToSize();
		Iterator<Entity> ei = Main.obMan.entities.listIterator();
		while (ei.hasNext()) {
			Entity e = ei.next();

			e.tick();
			if (e.markOfDeath) {
				ei.remove();

			}
		}
	

	}

	
}

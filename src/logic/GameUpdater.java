package logic;

import java.util.ArrayList;
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
		ArrayList<Entity> clone = (ArrayList<Entity>) Main.obMan.entities.clone();
		for (Entity e: clone) {
			

			e.tick();
			if (e.markOfDeath) {
				Main.obMan.entities.remove(e);
				Main.teams.remove(e);
			}
		}
		
	}

	
}

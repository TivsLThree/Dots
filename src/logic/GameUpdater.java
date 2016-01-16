package logic;

import java.util.Iterator;

import entities.Entity;
import game.Main;

public class GameUpdater {

	public GameUpdater() {

	}

	public void tick() {
		
		Main.obMan.entities.trimToSize();
		Iterator<Entity> ei= Main.obMan.entities.listIterator();
		while( ei.hasNext()) {
			Entity e = ei.next();
		//	System.out.println(e.pos[0]);
			e.tick();
			System.out.println(Thread.currentThread());
		
		}
	}
}

package logic;

import java.util.ArrayList;
import java.util.Iterator;

import entities.Entity;
import game.Main;

public class GameUpdater {

	public GameUpdater() {

	}

	public void tick() {
		
		Main.obMan.entities.trimToSize();
		Iterator<Entity> ei= Main.obMan.entities.listIterator();
		ArrayList<Entity> markedForDeath= new ArrayList<>();
		while( ei.hasNext()) {
			Entity e = ei.next();
		//	System.out.println(e.pos[0]);
			e.tick();
			if(e.markOfDeath){
				markedForDeath.add(e);
			}
		//	System.out.println(Thread.currentThread());	
		}
		for(Entity e: markedForDeath){
			Main.obMan.removeFromEntities(e);
			Main.obMan.removeFromDrawables(e);
		}
	}
}

package game;

import java.util.ArrayList;

import display.MainScreen;
import display.MainScreenCanvas;
import entities.ObjectManager;
import entities.Team;
import entities.Dot;
import logic.GameUpdater;
import threads.ThreadManager;
import world.World;

public class Main {
	public static MainScreen screen;
	public static MainScreenCanvas msc;
	public volatile static ObjectManager obMan;
	public static World map;
	public static ThreadManager threadOverseer;
	public static GameUpdater updater;
	public static ArrayList<Dot> teams;

	public static void main(String[] args) {
		initAll();
		wakeUp();

	}

	private static void initAll() {
		// THESE NEED TO BE INITIALIZED FIRST;
		obMan = new ObjectManager();
		msc = new MainScreenCanvas();
		updater = new GameUpdater();
		map = new World();// World should always be the first Drawable
							// initialized . TODO: Priority rendering.
		// This would be used to have certain objects always render above
		// others. And wouldn't be dependent on initialization order.
		// The order for these <i>shouldn't</i> matter.

		threadOverseer = new ThreadManager();

		screen = new MainScreen(Settings.name, Settings.width, Settings.height);

		teams = new ArrayList<Dot>();
		for (int i = 0; i < 2000; i++) {
			teams.add(new Dot(Team.TwelveVoltBolt));
			teams.add(new Dot(Team.Pink));
			
		}
		//
	}

	private static void wakeUp() {
		screen.wakeUp();
		threadOverseer.wakeUp();

	}

}

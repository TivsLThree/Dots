package game;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import display.InfoScreen;
import display.InfoScreenCanvas;
import display.MainScreen;
import display.MainScreenCanvas;
import entities.ObjectManager;
import entities.Team;
import input.Mouse;
import entities.Castle;
import entities.Dot;
import entities.Entity;
import logic.GameUpdater;
import threads.ThreadManager;
import world.FileReader;
import world.World;

public class Main {
	public static Entity selectedEntity;
	public static MainScreen screen;
	public static MainScreenCanvas msc;
	public static InfoScreen infoScreen;
	public static InfoScreenCanvas isc;
	public volatile static ObjectManager obMan;
	public static World map;
	public static Mouse mouse;
	public static ThreadManager threadOverseer;
	public static GameUpdater updater;
	public static ArrayList<Dot> teams;
	public static ArrayList<Castle> castles;
	public static FileReader fileReader = new FileReader();

	public static void main(String[] args) {
		initAll();
		wakeUp();

	}

	private static void initAll() {
		// THESE NEED TO BE INITIALIZED FIRST;

		obMan = new ObjectManager();
		msc = new MainScreenCanvas();
		isc = new InfoScreenCanvas();
		updater = new GameUpdater();
		// World should always be the first Drawable
		// initialized . TODO: Priority rendering.
		// This would be used to have certain objects always render above
		// others. And wouldn't be dependent on initialization order.
		// The order for these <i>shouldn't</i> matter.
		map = new World();
		try {
			int[][] newMap = fileReader.loadWorld();
			if (newMap != null) {
				World.worldMap = newMap;
			} else {
				map.genWorld();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mouse = new Mouse();
		threadOverseer = new ThreadManager();

		screen = new MainScreen(Settings.name, Settings.width, Settings.height);
		infoScreen = new InfoScreen("Dots: Stronghold -> Inspector", 200, Settings.height);
		genCastles();
		genTeams();
		//
	}

	private static void wakeUp() {
		screen.wakeUp();
		infoScreen.wakeUp();
		threadOverseer.wakeUp();

	}

	public static void genTeams() {
		teams = new ArrayList<Dot>();
		teams.clear();

		for (Team t : Team.values()) {
			for (Castle c : castles) {
				if (c.team == t) {
					for (int i = 0; i < 1; i++) {
						teams.add(new Dot(t, c.pos.clone()));
					}
				}
			}
		}

		selectedEntity = teams.get(0);
	}

	private static void genCastles() {
		castles = new ArrayList<>();
		for (Team t : Team.values()) {
			castles.add(new Castle(t, randomPosition()));
		}
	}

	private static int[] randomPosition() {

		int[] pos = new int[] { (int) (Math.random() * World.worldMap.length),
				(int) (Math.random() * World.worldMap[0].length) };
		if (World.worldMap[pos[0]][pos[1]] != 0) {
			pos = randomPosition();
		}
		return pos;
	}
}

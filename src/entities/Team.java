package entities;

import java.awt.Color;
import java.util.HashMap;

public enum Team {
	TwelveVoltBolt(1557, new Color(112,17,27, 255)),
	Pink(233, new Color(255,22,193, 255)), 
	SPAM(180,new Color(1, 1, 1, 255)),
	ExplodingBacon(1902, new Color(1, 1, 1, 255)), 
	Mars(1523, new Color(1, 1, 1, 255));
	private HashMap<Team, Integer> numberMap = new HashMap<>();
	private HashMap<Team, Color> colorMap = new HashMap<>();

	Team(int i, Color c) {
		numberMap.put(this, i);
		colorMap.put(this, c);
	}

	public int getNumber() {
		return numberMap.get(this);
	}

	public Color getColor() {
		return colorMap.get(this);
	}
}

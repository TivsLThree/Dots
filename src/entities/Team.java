package entities;

import java.awt.Color;
import java.util.HashMap;

public enum Team {
	TwelveVoltBolt(1557, new Color(170,17,27, 255)),
	Pink(233, new Color(255,22,193, 255)), 
	SPAM(180,new Color(55,60,177, 255)),
	ExplodingBacon(1902, new Color(240,77,35, 255)), 
	Mars(1523, new Color(102, 0, 0, 255));
	private final int number;
	private final Color color;
	Team(int i, Color c) {
		number = i;
		color = c;
	}

	public int getNumber() {
		return number;
	}

	public Color getColor() {
		return color;
	}
}

package entities;

import java.util.Random;

public enum Direction {
	UP, DOWN, LEFT, RIGHT;
	private static final Direction[] VALUES = values();
	private static final int SIZE = VALUES.length;
	private static final Random RANDOM = new Random();
	public static Direction getRandom(){
		
		return VALUES[RANDOM.nextInt(SIZE)];
	}
}

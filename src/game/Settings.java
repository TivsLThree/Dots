package game;

public class Settings {
	// Global variables;
	// TODO: Save and load settings into a text file. 
	public static int width = 1200;
	public static int height = 800;
	public static String name = "Dots: Stronghold";
	public static int[] worldSize = { 120,80};
	//VVV Not a setting, rather a global variable TODO: VariableMap Class
	public static  int[] scaleFactor = { // FORMATTING
			(Settings.width) / Settings.worldSize[0], // FORMATTING
			(Settings.height) / Settings.worldSize[1] // FORMATTING
	};
}

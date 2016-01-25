package world;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import game.Settings;

public class FileReader {
	private boolean borkened = true;
	public int[][] loadWorld() throws IOException {
		if(borkened)
			return null;
		String fileName = (JOptionPane.showInputDialog("Map Name?"));
		if (fileName == null || fileName.equals("")) {
			return null;
		}
		String filePath = "src/maps/" + fileName + ".dmf";
		List<String> lines = Files.readAllLines(Paths.get(filePath));
		int[][] worldData = new int[Settings.worldSize[0] + 1][Settings.worldSize[0]];
		int x = 0;
		int y = 0;
		for (String s : lines) {
			for (String s2 : s.split(",")) {
				if (!s2.isEmpty()) {
					 System.out.println(x + ":" + y);
					worldData[x][y] = (Integer.parseInt(s2));
					//Still broken; don't use. Meh.
					// System.out.print(s2);
					y++;
				}

			}
			// System.out.print("\n");
			x++;
			y = 0;
		}
		return worldData;
	}
}

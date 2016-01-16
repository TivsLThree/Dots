package entities;

import java.awt.Color;
import java.awt.Graphics2D;

import game.Settings;

import static game.Settings.*;

public class TestDot extends Entity{
public TestDot(){
	
}
	@Override
	public void tick() {		
		if(pos[0] < Settings.worldSize[0]-1){
			pos[0]+=1;
		}
	}

	@Override
	public void draw(Graphics2D g) {
	g.setColor(Color.BLUE);

		g.fillRect(pos[0] * size[0], pos[1] * size[1], size[0], size[1]);
	}

}

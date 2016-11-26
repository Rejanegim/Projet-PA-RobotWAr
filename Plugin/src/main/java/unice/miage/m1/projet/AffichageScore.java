package unice.miage.m1.projet;

import java.awt.Graphics;

public class AffichageScore implements IPluginGraphique  {

	int x = 900;
	

	
	public void paint(Graphics g, IRobot robot) {
		// TODO Auto-generated method stub
			int vie = robot.getVie();
			g.setColor(robot.getCouleur());
			int y= 100;
			g.drawString("Life : " +vie , x, y);
			g.fillRect(x,y+5,vie, 15);
			g.drawRect(x,y+5, vie, 15);
			
		
	}

	

}
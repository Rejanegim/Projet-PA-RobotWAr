package unice.miage.m1.projet;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class AffichageArme implements IPluginGraphique {

	
	
	public void paint(Graphics g, IRobot robot) {
		// TODO Auto-generated method stub
		Color c = robot.getCouleur();
		g.setColor(c);
	    float capEnRadian=robot.getCap()*(float)(Math.PI/180);
	    Point p =robot.getPosition() ;    
        g.drawLine(Math.round(p.x+10),
                   Math.round(p.y+10),
                   Math.round(p.x+20*(float)Math.cos(capEnRadian)+10),
                   Math.round(p.y+20*(float)Math.sin(capEnRadian)+10)
                   );
		
	}

}

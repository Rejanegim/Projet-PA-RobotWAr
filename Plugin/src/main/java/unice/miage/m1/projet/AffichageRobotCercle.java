package unice.miage.m1.projet;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class AffichageRobotCercle implements IPluginGraphique {

	public AffichageRobotCercle(){
		
	}
	
	public void paint(Graphics g, IRobot r) {
		// TODO Auto-generated method stub
		Color c = r.getCouleur();
		Point p = r.getPosition();
		g.setColor(c);
		g.fillOval(p.x, p.y, 20, 20);
		
	}

}

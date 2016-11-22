package unice.miage.m1.projet;

import java.awt.Graphics;
import java.awt.Point;

public interface IRobot {
	
	public static final int xMax = 500; // abscisse maximun de la fenetre
	public static final int yMax = 500; // ordonnee maximun de la fenetre
	
	public Point getPosition();
	
	public void setPosition(Point position) ;

	public void paint(Graphics g);
	
	
	

}

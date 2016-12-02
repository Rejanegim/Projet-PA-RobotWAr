package unice.miage.m1.projet;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public interface IRobot {
	
	
	public static final int xMax = 650; // abscisse maximun de la fenetre
	public static final int yMax = 600; // ordonnee maximun de la fenetre
	
	public Point getPosition();
	
	public void setPosition(Point position) ;

	public void paint(Graphics g);
	
	public Color getCouleur() ;
	
	public float getCap() ;

	public void setCap(float cap) ;
	  
	public void tourner(float deltaC);
	
	public void deplacement();
	
	public void attaque();
	
	public int getVie() ;


	

}

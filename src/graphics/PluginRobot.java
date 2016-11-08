package m1.miage.projet.pa;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

import java.lang.Math;


public class PluginRobot extends JPanel implements IPluginGraphique {
	
	float  randomr =(float) (Math.random()); // opacite de la couleur rouge
	float  randomv =(float) (Math.random()); // opacite de la couleur vert
	float  randomb =(float) (Math.random()); // opacite de la couleur bleu
	int randomx= (int) (Math.random() * xMax) ;
	int randomy= (int) (Math.random() * yMax ) ;


	public static final int xMax = 500; // abscisse maximun de la fenetre
	public static final int yMax = 500; // ordonnee maximun de la fenetre
	// l'origine (i.e. (0,0)) represente le coin superieur gauche de la fenetre
	// instance variables
	private float x; // abcisse du centre du carre
	private float y; // ordonnee du centre du carre

	public PluginRobot() {
		this.x = x;
		this.y = y;
	}

	
	public void setX(float x) {
		this.x = x;
	}

	public void setY(float y) {
		this.y = y;
	}
	
	
	
	@Override
	public void paint(Graphics g) {
		System.out.println(randomr +" " +randomb +" " +randomv);
		Color c = new Color(randomr,randomv,randomb);
		g.setColor(c);
		System.out.println(randomx   +" " +randomy); // affiche les coordonnés
		g.drawRect(randomx, randomy, 10, 10);
		g.fillRect(randomx, randomy, 10, 10);
		
	}



}

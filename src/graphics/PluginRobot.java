package m1.miage.projet.pa;

import java.awt.Color;
import java.awt.Graphics;
import java.lang.Math;



public class PluginRobot  implements IPluginGraphique {
	
	
	private static final long serialVersionUID = 1L;
	
	
	float  randomr =(float) (Math.random()); // opacite de la couleur rouge
	float  randomv =(float) (Math.random()); // opacite de la couleur vert
	float  randomb =(float) (Math.random()); // opacite de la couleur bleu
	int x= (int) (Math.random() * xMax) ;
	int y= (int) (Math.random() * yMax ) ;


	public static final int xMax = 500; // abscisse maximun de la fenetre
	public static final int yMax = 500; // ordonnee maximun de la fenetre
	
	public PluginRobot() {
		super();
		this.randomr = randomr;
		this.randomv = randomv;
		this.randomb = randomb;
		this.x = x;
		this.y =y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public void paint(Graphics g) {
		Color c = new Color(randomr,randomv,randomb);
		g.setColor(c);
		g.drawRect(x, y, 10, 10);
		g.fillRect(x, y, 10, 10);
		
	}



}


package unice.miage.m1.projet;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.io.Serializable;

public class AffichageRobotCercle implements IPluginGraphique, Serializable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2979470404036378632L;

	/**
	 * Constructeur de la classe
	 */
	public AffichageRobotCercle() {

	}

	/**
	 * // * Methode permettant de dessiner les robots ronds
	 */
	public void paint(Graphics g, IRobot r) {
		// TODO Auto-generated method stub
		// Affichage du Robot sous forme de cercle
		Color c = r.getCouleur();
		Point p = r.getPosition();
		g.setColor(c);
		g.fillOval(p.x, p.y, 20, 20);
		// Affichage de son arme
		float capEnRadian = r.getCap() * (float) (Math.PI / 180);
		g.drawLine(Math.round(p.x + 10), Math.round(p.y + 10),
				Math.round(p.x + 20 * (float) Math.cos(capEnRadian) + 10),
				Math.round(p.y + 20 * (float) Math.sin(capEnRadian) + 10));

		// Affichage de la barre de vie

		g.drawRect((int) (p.getX() - 20 / 2), (int) (p.getY() + 20 / 2 + 20), (int) 20, 5);
		double barWidth = 18;
		double barToFill = (barWidth / 100) * r.getVie();
		;
		g.fillRect((int) (p.getX() - 20 / 2 + 1), (int) (p.getY() + 20 / 2 + 1 + 20), (int) barToFill, 3);
		//Niveau de vie en nombre
		String life =  Integer.toString(r.getVie()) ;
		g.drawString(life,(int) (p.getX() - 20 / 2), (int) (p.getY() + 20 / 2 + 20));

	}

}

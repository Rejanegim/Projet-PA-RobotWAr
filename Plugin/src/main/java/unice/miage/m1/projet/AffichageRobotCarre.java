package unice.miage.m1.projet;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class AffichageRobotCarre implements IPluginGraphique {

	/**
	 * Constructeur de la classe
	 */
	public AffichageRobotCarre() {

	}

	/**
	 * Methode permettant de dessiner les robots carrés
	 */
	public void paint(Graphics g, IRobot r) {
		// Affichage du robot
		Color c = r.getCouleur();
		Point p = r.getPosition();
		g.setColor(c);
		g.fillRect(p.x, p.y, 20, 20);
		// Affichage de l'arme
		float capEnRadian = r.getCap() * (float) (Math.PI / 180);
		g.drawLine(Math.round(p.x + 10), Math.round(p.y + 10),
				Math.round(p.x + 20 * (float) Math.cos(capEnRadian) + 10),
				Math.round(p.y + 20 * (float) Math.sin(capEnRadian) + 10));
		// Affichage de la barre de vie
		g.drawRect((int) (p.getX() - 20 / 2), (int) (p.getY() + 20 / 2 + 20), (int) 20, 5);
		double barWidth = 20;
		double barToFill = (barWidth / 100) * r.getVie();
		;
		g.fillRect((int) (p.getX() - 20 / 2 + 1), (int) (p.getY() + 20 / 2 + 1 + 20), (int) barToFill, 3);
	}

}

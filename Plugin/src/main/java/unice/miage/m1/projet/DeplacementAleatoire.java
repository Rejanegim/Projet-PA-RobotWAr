package unice.miage.m1.projet;

import java.awt.Point;

public class DeplacementAleatoire implements IPluginDeplacement {
	/**
	 * Constructeur de la classe
	 */
	public DeplacementAleatoire() {

	}

	/**
	 * Méthode permettant de vérifier si un robot est au bord de la zone
	 * joueable.
	 */
	public boolean auBord(IRobot robot) {
		return (robot.getPosition().getX() + 20 > robot.xMax - 50 || robot.getPosition().getX() - 20 < 50
				|| robot.getPosition().getY() + 20 > robot.yMax - 50 || robot.getPosition().getY() - 20 < 50);
	}

	/**
	 * Méthode permettant le déplacement aléatoire d'un robot.
	 */
	public Point deplacement(IRobot r, int vitesse) {
		r.setCap((float) (Math.random() * 360));
		float capEnRadian = r.getCap() * (float) (Math.PI / 180);
		Point p = r.getPosition();
		if (this.auBord(r)) {
			r.tourner(180);
			float capEnRadian2 = r.getCap() * (float) (Math.PI / 180);
			p.x = (int) (p.x + vitesse * (float) Math.cos(capEnRadian2));
			p.y = (int) (p.y + vitesse * (float) Math.sin(capEnRadian2));
		}
		p.x = (int) (p.x + vitesse * (float) Math.cos(capEnRadian));
		p.y = (int) (p.y + vitesse * (float) Math.sin(capEnRadian));
		return p;
	}

}

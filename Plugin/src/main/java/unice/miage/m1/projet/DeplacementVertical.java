package unice.miage.m1.projet;

import java.awt.Point;

public class DeplacementVertical implements IPluginDeplacement {

	// le cap doit être soit 90 soit -90 pour un déplacement vertical

	/**
	 * Constructeur de la classe
	 */
	public DeplacementVertical() {

	}

	/**
	 * Méthode permettant de vérifier si un robot est au bord de la zone
	 * joueable.
	 */
	public boolean auBord(IRobot robot) {
		return (robot.getPosition().getX() + 20 > robot.xMax - 50 || robot.getPosition().getX() - 20 < 50
				|| robot.getPosition().getY() - 20 > robot.yMax - 50 || robot.getPosition().getY() + 20 < 50);
	}

	/**
	 * Méthode permettant le déplacement vertical d'un robot.
	 * 
	 */
	public Point deplacement(IRobot r, int vitesse) {
		int angle = 90;
		r.setCap(angle);
		Point p = r.getPosition();
		float capEnRadian = r.getCap() * (float) (Math.PI / 180);
		if (this.auBord(r)) {
			r.tourner(180);
			float capEnRadian2 = r.getCap() * (float) (Math.PI / 180);
			p.y += 70 * (float) Math.sin(capEnRadian2);
		}
		p.y += vitesse * (float) Math.sin(capEnRadian);
		return p;
	}

}

package unice.miage.m1.projet;

import java.awt.Point;

public class DeplacementHorizontal implements IPluginDeplacement {

	// le cap doit être soit 0 soit 180 pour un déplacement horizontal
	/**
	 * Constructeur de la classe
	 */
	public DeplacementHorizontal() {

	}

	/**
	 * Méthode déterminant si le Robot est au bord de la zone joueable.
	 * 
	 */
	public boolean auBord(IRobot robot) {
		return (robot.getPosition().getX() > robot.xMax - 30 || robot.getPosition().getX() < 30
				|| robot.getPosition().getY() > robot.yMax - 30 || robot.getPosition().getY() < 30);
	}

	/**
	 * Méthode assurant le déplacement horizontal d'un robot.
	 * 
	 */
	public Point deplacement(IRobot r, int vitesse) {
		if (this.auBord(r)) {
			r.tourner(180);
		}
		float capEnRadian = r.getCap() * (float) (Math.PI / 180);
		Point p = r.getPosition();
		p.x += vitesse * (float) Math.cos(capEnRadian);
		return p;
	}
}

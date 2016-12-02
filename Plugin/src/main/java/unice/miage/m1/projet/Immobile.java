package unice.miage.m1.projet;

import java.awt.Point;

public class Immobile implements IPluginDeplacement {

	/**
	 * Constructeur de la classe
	 */
	public Immobile() {

	}

	/**
	 * Méthode conservant la position initiale du robot
	 */
	public Point deplacement(IRobot r, int v) {
		// TODO Auto-generated method stub
		r.setCap((float) (Math.random() * 360));
		Point p = r.getPosition();
		return p;
	}

}

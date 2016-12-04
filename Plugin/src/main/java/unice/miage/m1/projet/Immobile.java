package unice.miage.m1.projet;

import java.awt.Point;
import java.io.Serializable;

public class Immobile implements IPluginDeplacement, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2688022272662973109L;

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

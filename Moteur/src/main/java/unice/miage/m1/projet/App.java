package unice.miage.m1.projet;

import java.awt.Graphics;

/**
 * RobotWar !
 *
 */
public class App {
	public static void main(String[] args) {
		Moteur RobotWar = new Moteur();
		RobotWar.sauvegarde();
		Graphics g = RobotWar.getFenetre().getGraphics();
		RobotWar.gestionDesTours(g);

	}
}

package unice.miage.m1.projet;

import java.awt.Point;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import unice.miage.m1.projet.Fenetre;
import unice.miage.m1.projet.PluginRobot;

public class DeplacementVertical implements IPluginDeplacement {

	private ArrayList<PluginRobot> listRobots;

	private FenetreF fenetre;

	public DeplacementVertical(int nbRobots) {

		fenetre = new FenetreF();

		listRobots = new ArrayList();

		// Création des robots :
		for (int i = 0; i < nbRobots; i++) {
			PluginRobot r1 = new PluginRobot();

			listRobots.add(r1);
		}

		fenetre.setListeRobots(listRobots);

		gestionDesTours();

	}

	private void gestionDesTours() {
		System.out.println("TOURS");
		// 10 tours de jeu :
		for (int i = 1; i <= 10; i++) {

			for (PluginRobot robot : listRobots) {
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				int x = robot.getX();
				int y = robot.getY();

				robot.setY(y + 10);

				System.out.println("mouvement");

				fenetre.repaint();
			}

		}

	}

	public static void main(String[] args) {
		DeplacementVertical mo = new DeplacementVertical(2);

	}

	
	public Point deplacement(Robot robot) {
		// TODO Auto-generated method stub
		return null;
	}

}

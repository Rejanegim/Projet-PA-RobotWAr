package m1.miage.projet.pa;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Moteur {

	/** Liste des robots */
	private ArrayList<Robot> listRobots;

	/** Fenetre du jeu */
	private Fenetre fenetre;

	public Moteur(int nbRobots) {

		fenetre = new Fenetre("TEST");

		listRobots = new ArrayList();

		// Création des robots :
		for (int i = 0; i < nbRobots; i++) {
			// Création d'un robot
			Robot r1 = new Robot();

			// Ajout du robot à la liste
			listRobots.add(r1);
		}

		fenetre.setListeRobots(listRobots);

		// Lancement du jeu
		gestionDesTours();

	}

	private void gestionDesTours() {
		// 10 tours de jeu :
		for (int i = 1; i <= 10; i++) {

			// On parcourt la liste des robots
			for (Robot robot : listRobots) {

				// Timer entre chaque tour d'un robot
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				// On demande au robot de se déplacer
				robot.deplacement();

				// On demande au robot d'attaquer
				robot.attaque();

				fenetre.repaint();
			}

		}

	}

	public static void main(String[] args) {
		Moteur moteur = new Moteur(4);
	}
}

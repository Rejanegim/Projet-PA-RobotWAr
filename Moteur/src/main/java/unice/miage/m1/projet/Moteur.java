package unice.miage.m1.projet;

import java.awt.Graphics;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Moteur {

	/** Liste des robots */
	private ArrayList<IRobot> listRobots;

	/** Fenetre du jeu */
	private FenetreF fenetre;

	
	public Moteur(int nbRobots, List<Class> l) {

		fenetre = new FenetreF();

		listRobots = new ArrayList();

		// Création des robots :
		for (int i = 0; i < nbRobots; i++) {
			// Création d'un robot
//			Robot r1 = new Robot();
			// r1.setPluginDeplacement(pluginDeplacement);
			for (int j = 0; j < l.size(); j++) {
				if (l.get(j).getName().equals("unice.miage.m1.projet.DeplacementHorizontal")) {
                      //get contstuctor
					
					//invoke
//					IPluginDeplacement truc = null;
//					r1.setPluginDeplacement(truc);
				}
			}
			// Ajout du robot à la liste
//			listRobots.add(r1);
		}

		fenetre.setListeRobots(listRobots);

		// Lancement du jeu

	}

	private void gestionDesTours() {
		while (true) {

			// On parcourt la liste des robots
			for (IRobot robot : listRobots) {

				// Timer entre chaque tour d'un robot
				try {
					TimeUnit.MILLISECONDS.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				// On demande au robot de se dessiner
			//	robot.paint(g)

				// On demande au robot de se déplacer
				robot.deplacement();

				// On demande au robot d'attaquer
				robot.attaque();
				
				fenetre.repaint();
			}

		}

	}

	public static void main(String[] args) throws ClassNotFoundException {
		File f = new File("/home/deptinfo/Documents/workspacePA/Projet-PA-RobotWAr/Plugin/target/classes");
		Repository rep = new Repository(f);
		List l = rep.load();
		Moteur moteur = new Moteur(4, l);
		moteur.gestionDesTours();
	}
}

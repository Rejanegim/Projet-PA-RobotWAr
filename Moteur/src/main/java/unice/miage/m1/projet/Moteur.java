package unice.miage.m1.projet;

import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class Moteur {

	/** Liste des robots */
	private ArrayList<IRobot> listRobots;

	/** Fenetre du jeu */
	private FenetreF fenetre;

	public Moteur(int nbRobots, List<Class> l) throws ClassNotFoundException, InstantiationException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		fenetre = new FenetreF();

		listRobots = new ArrayList();

		// Création des robots :
		for (int i = 0; i < nbRobots; i++) {
			// Création d'un robot
			Robot r1 = new Robot();
			for (int j = 0; j < l.size(); j++) {
				if (l.get(j).getName().equals("unice.miage.m1.projet.DeplacementHorizontal")) {
					Class<?> classe = l.get(j);
					Constructor[] c = classe.getConstructors();
					Constructor cons = c[0]; // on va dans un 1er temps supposé
												// qu'il n'y qu'un seul
												// constructeur
					// get contstuctor
					Object o = cons.newInstance();
					// invoke
					IPluginDeplacement truc = (IPluginDeplacement) o;
					r1.setPluginDeplacement(truc);
				}

				if (l.get(j).getName().equals("unice.miage.m1.projet.AffichageRobot")) {
					Class<?> cl = l.get(j);
					Constructor[] c2 = cl.getConstructors();
					Constructor cons2 = c2[0]; // on va dans un 1er
												// temps supposé qu'il
												// n'y qu'un seul
												// constructeur
					// get contstuctor
					
					Object o2 = cons2.newInstance();
					// invoke
					IPluginGraphique truc2 = (IPluginGraphique) o2;
					r1.setPluginGraphique(truc2);
				}
				// Ajout du robot à la liste
				listRobots.add(r1);
			
			}

			fenetre.setListeRobots(listRobots);
		}

		// Lancement du jeu

	}
	
	private void gestionDesTours(Graphics g) {
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

				robot.paint(g);

				// On demande au robot de se déplacer
				robot.deplacement();

				// On demande au robot d'attaquer
				robot.attaque();

				fenetre.repaint();
			}

		}

	}
	

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		File f = new File("/home/deptinfo/Documents/workspacePA/Projet-PA-RobotWAr/Plugin/target/classes");
		Repository rep = new Repository(f);
		List l = rep.load();
		Moteur moteur = new Moteur(3, l);
		Graphics g = moteur.fenetre.getGraphics();
		moteur.gestionDesTours(g);
		
	}
}

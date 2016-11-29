package unice.miage.m1.projet;


import java.awt.Graphics;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import javax.swing.JMenuBar;


public class Moteur {

	/** Liste des robots */
	private ArrayList<IRobot> listRobots;

	/** Fenetre du jeu */
	private FenetreF fenetre;
	
	private JMenuBar menuBar;

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
				if (l.get(j).getName().equals("unice.miage.m1.projet.AffichageArme")) {
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
			Robot r2 = new Robot();
			for (int j = 0; j < l.size(); j++) {
				if (l.get(j).getName().equals("unice.miage.m1.projet.PluginDeplacementAleatoire")) {
					Class<?> classe = l.get(j);
					Constructor[] c = classe.getConstructors();
					Constructor cons = c[0]; // on va dans un 1er temps supposé
												// qu'il n'y qu'un seul
												// constructeur
					// get contstuctor
					Object o = cons.newInstance();
					// invoke
					IPluginDeplacement truc = (IPluginDeplacement) o;
					r2.setPluginDeplacement(truc);
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
					r2.setPluginGraphique(truc2);
				}
				if (l.get(j).getName().equals("unice.miage.m1.projet.AffichageScore")) {
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
					r2.setPluginGraphique(truc2);
				}
				if (l.get(j).getName().equals("unice.miage.m1.projet.AffichageArme")) {
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
					r2.setPluginGraphique(truc2);
				}
				// Ajout du robot à la liste
				listRobots.add(r2);

			}

			fenetre.setListeRobots(listRobots);

		}

		// Lancement du jeu

	}

	public Moteur(){ //List<Class> l) {
		super();
		this.fenetre = new FenetreF();
		
	}
	
	
	private void gestionDesTours(Graphics g)  {
		while (true) {
			this.listRobots = fenetre.getListRobots();
//			Iterator<IRobot> li=(Iterator<IRobot>) listRobots;
//			
//			while(li.hasNext()){
//				Robot robot = (Robot) li.next();
////				 Timer entre chaque tour d'un robot
//				try {
//					TimeUnit.MILLISECONDS.sleep(60);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//				}
//				robot.paint(g);
//				robot.deplacement();
//				robot.attaque();
//				fenetre.repaint();
//			}
			
			
			// On parcourt la liste des robots
				
			for (IRobot robot : listRobots) {
//				// Timer entre chaque tour d'un robot
				try {
					TimeUnit.MILLISECONDS.sleep(60);

			} catch (InterruptedException e) {
				e.printStackTrace();
				}
				
				// On demande au robot de se dessiner
				robot.paint(g);
//				// On demande au robot de se déplacer
				robot.deplacement();	
//				// On demande au robot d'attaquer
				robot.attaque();				
				fenetre.repaint();
			}
		}

	}
	


	public static void main(String[] args) throws ClassNotFoundException, InstantiationException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
//		File fichier = new File("");
//		String chemin = fichier.getAbsolutePath();
//		chemin = chemin.replaceAll("Moteur", "Plugin" + File.separator + "target" + File.separator + "classes");
//		File f = new File(chemin);
//		Repository rep = new Repository(f);
//		List l = rep.load();
		Moteur moteur = new Moteur();
		moteur.fenetre.setVisible(true);
		Graphics g = moteur.fenetre.getGraphics();
		moteur.gestionDesTours(g);

	}
}

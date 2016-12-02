package unice.miage.m1.projet;

import java.awt.Graphics;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;


public class Moteur implements Serializable {

	/** Liste des robots */
	private ArrayList<IRobot> listRobots;

	/** Fenetre du jeu */
	private FenetreF fenetre;
	

	/**
	 * Constructeur de la classe Moteur.
	 * Permet le lancement du jeu
	 */
	
	public Moteur() { 
		super();
		this.fenetre = new FenetreF();
		this.listRobots = fenetre.getListRobots();
	}

	/**
	 * Méthode de gestion des tours.
	 * 
	 */
	// Lancement du jeu
	private void gestionDesTours(Graphics g) {
		while (true) {
			
				this.listRobots = fenetre.getListRobots();
				// On parcourt la liste des robots
				synchronized (listRobots) {
				for (IRobot robot : listRobots) {
					// On demande au robot de se dessiner
					robot.paint(g);
					// // On demande au robot de se déplacer
					robot.deplacement();
					// // On demande au robot d'attaquer
					robot.attaque();
					// On demande à la fenetre de se repeindre 
					fenetre.repaint();
					}
				}
					try {
						TimeUnit.MILLISECONDS.sleep(100);

					} catch (InterruptedException e) {
						e.printStackTrace();
					}
	
		}

	}

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Moteur moteur = new Moteur();
		moteur.fenetre.setVisible(true);
		Graphics g = moteur.fenetre.getGraphics();
		moteur.gestionDesTours(g);
	}
}

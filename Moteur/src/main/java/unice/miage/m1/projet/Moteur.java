package unice.miage.m1.projet;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;

public class Moteur implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6909256856543733142L;

	/** Liste des robots */
	private ArrayList<IRobot> listRobots;

	/** Fenetre du jeu */
	private FenetreF fenetre;

	/** Bouton de sauvegarde */
	private JButton buttonsave;

	/** Bouton pour reprendre une partie */
	private JButton buttonload;

	public void sauvegarde() {
		buttonsave.addActionListener(new ActionListener() {

			// Definit l'action du bouton
			public void actionPerformed(ActionEvent arg0) {
				Sauvegarde save = new Sauvegarde(Moteur.this);
				save.save();
			}
		});

		buttonload.addActionListener(new ActionListener() {

			// Definit l'action du bouton
			public void actionPerformed(ActionEvent arg0) {
				Sauvegarde load = new Sauvegarde(Moteur.this);
				load.load();
			}
		});
	}

	/**
	 * Constructeur de la classe Moteur. Permet le lancement du jeu
	 */

	public Moteur() {
		super();
		this.fenetre = new FenetreF();
		this.listRobots = fenetre.getListRobots();
		buttonsave = fenetre.getBouton1();
		buttonload = fenetre.getBouton4();
	}

	public ArrayList<IRobot> getListRobots() {
		return listRobots;
	}

	public void setListRobots(ArrayList<IRobot> listeRobots) {
		this.listRobots = listeRobots;
	}

	public FenetreF getFenetre() {
		return fenetre;
	}

	public void setFenetre(FenetreF fenetre) {
		this.fenetre = fenetre;
	}

	/**
	 * Méthode de gestion des tours.
	 * 
	 */
	// Lancement du jeu
	public void gestionDesTours(Graphics g) {
		while (true) {

			this.listRobots = fenetre.getListRobots();
			// On parcourt la liste des robots
			synchronized (listRobots) {
				for (IRobot robot : listRobots) {
					// Si un robot a une vie inférieure ou égale à 0, il est
					// mort
					// et on ne le dessine plus.
					if (robot.getVie() > 0) {
						// On demande au robot de se dessiner
						robot.paint(g);
						// // On demande au robot de se déplacer
						robot.deplacement();
						// // On demande au robot d'attaquer
						robot.attaque(listRobots);
						// On demande à la fenetre de se repeindre
						fenetre.repaint();
					}
				}
			}
			try {
				TimeUnit.MILLISECONDS.sleep(500);

			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

	}

	// public static void main(String[] args) throws ClassNotFoundException,
	// InstantiationException,
	// IllegalAccessException, IllegalArgumentException,
	// InvocationTargetException {
	// Moteur moteur = new Moteur();
	// moteur.sauvegarde();
	// moteur.fenetre.setVisible(true);
	// Graphics g = moteur.fenetre.getGraphics();
	// moteur.gestionDesTours(g);
	// }
}
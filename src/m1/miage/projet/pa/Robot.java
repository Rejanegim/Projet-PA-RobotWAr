package m1.miage.projet.pa;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Robot {
	private int vie;
	private Color couleur;
	private int ptMouvement;
	private Point position;

	/** plugin deplacement */
	private IPluginDeplacement pluginDeplacement;

	public Robot() {
		// Nombre de points de vie d'un robot
		vie = 10;

		ptMouvement = 50;

		// Couleur aléatoire du robot
		float randomr = (float) (Math.random()); // opacite de la couleur rouge
		float randomv = (float) (Math.random()); // opacite de la couleur vert
		float randomb = (float) (Math.random()); // opacite de la couleur bleu

		couleur = new Color(randomr, randomv, randomb);

		// Position aléatoire du robot
		int x = (int) (Math.random() * 500);
		int y = (int) (Math.random() * 500);
		position = new Point(x, y);

		// Récupération du plugin permettant de déplacer le robot
		pluginDeplacement = new PluginDeplacementAleatoire();
	}

	public int getVie() {
		return vie;
	}

	public void setVie(int vie) {
		this.vie = vie;
	}

	public Color getCouleur() {
		return couleur;
	}

	public void setCouleur(Color couleur) {
		this.couleur = couleur;
	}

	public int getPtMouvement() {
		return ptMouvement;
	}

	public void setPtMouvement(int ptMouvement) {
		this.ptMouvement = ptMouvement;
	}

	public Point getPosition() {
		return position;
	}

	public void setPosition(Point position) {
		this.position = position;
	}

	public IPluginDeplacement getPluginDeplacement() {
		return pluginDeplacement;
	}

	public void setPluginDeplacement(IPluginDeplacement pluginDeplacement) {
		this.pluginDeplacement = pluginDeplacement;
	}

	public void paint(Graphics g) {
		g.setColor(couleur);
		g.drawRect(position.x, position.y, 10, 10);
		g.fillRect(position.x, position.y, 10, 10);

	}

	public void deplacement() {
		position = pluginDeplacement.deplacement(this);
	}

	public void attaque() {

	}
}

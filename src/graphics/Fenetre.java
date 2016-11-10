package graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JFrame;

public class Fenetre extends JFrame {

	private ArrayList<PluginRobot> listRobots;

	public Fenetre(String titre) {
		super(titre);
		setSize(500, 500);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE); // permet de couper le
													// programme quand on ferme
													// la fenetre.
		setVisible(true);
	}

	public void setListeRobots(ArrayList<PluginRobot> listRobots) {
		this.listRobots = listRobots;
	}

	@Override
	public void paint(Graphics g) {
		for (PluginRobot robot : listRobots) {

			robot.paint(g);
		}
	}

	public static void main(String[] args) {
		Fenetre maFenetre = new Fenetre("RobotWar - Jeu");
	}

}

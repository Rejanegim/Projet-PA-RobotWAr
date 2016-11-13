package m1.miage.projet.pa;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JFrame;

public class Fenetre extends JFrame {

	private ArrayList<Robot> listRobots;

	public Fenetre(String titre) {
		super(titre);
		setSize(500, 500);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE); // permet de couper le
													// programme quand on ferme
													// la fenetre.
		setVisible(true);
	}

	public void setListeRobots(ArrayList<Robot> listRobots) {
		this.listRobots = listRobots;
	}

	@Override
	public void paint(Graphics g) {
		Color bg =new Color(255,255,255) ;
		g.setColor(bg);
		g.drawRect(0 , 0 , 510 , 510) ;
		g.fillRect(0, 0, 510, 510);
		
		for (Robot robot : listRobots) {

			robot.paint(g);
		}
	}

	public static void main(String[] args) {
		Fenetre maFenetre = new Fenetre("RobotWar - Jeu");
	}

}

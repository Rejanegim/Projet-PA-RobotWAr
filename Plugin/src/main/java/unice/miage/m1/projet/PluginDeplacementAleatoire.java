package unice.miage.m1.projet;

import java.awt.Point;
import java.util.concurrent.TimeUnit;

public class PluginDeplacementAleatoire implements IPluginDeplacement {

	private float cap;
	// private ArrayList<PluginRobot> listRobots;
	// private FenetreF fenetre;

	IRobot robot;

	public PluginDeplacementAleatoire() {

		// fenetre = new FenetreF();
		//
		// listRobots = new ArrayList();
		//
		// // Création des robots :
		// for (int i = 0; i < nbRobots; i++) {
		// PluginRobot r1 = new PluginRobot();
		//
		// listRobots.add(r1);
		// }
		//
		// fenetre.setListeRobots(listRobots);
		// avancer(10);

	}

	public boolean auBord(IRobot robot) {
		return (robot.getPosition().getX() > robot.xMax - 5 || robot.getPosition().getX() < 5
				|| robot.getPosition().getY() > robot.yMax - 5 || robot.getPosition().getY() < 5);
	}

	public float getCap() {
		return cap;
	}

	public void setCap(float cap) {
		this.cap = cap;
	}

	public void tourner(float deltaC) {
		this.cap = this.getCap() + deltaC;
	}

	public void avancer(float longueur) {
		int tours = (int) Double.POSITIVE_INFINITY;
		for (int i = 1; i <= tours; i++) {
			// for (PluginRobot robot : listRobots) {
			int x = (int) robot.getPosition().getX();
			int y = (int) robot.getPosition().getY();
			if (this.auBord(robot)) {
				this.tourner(180);
			}
			try {
				TimeUnit.MILLISECONDS.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.setCap((float) (Math.random() * 360));
			float capEnRadian = this.cap * (float) (Math.PI / 180); // conversion
																	// degre2radian
			Point point =new Point(((int) (robot.getPosition().getX() + longueur * (float) Math.cos(capEnRadian))),
					(int) (robot.getPosition().getY() + longueur * (float) Math.sin(capEnRadian)));
			
			robot.setPosition(point);

			
			System.out.println("mouvement");
			//
			// fenetre.repaint();
			// }
			//
		}
	}

//	public static void main(String[] args) {
//		PluginDeplacementAleatoire random = new PluginDeplacementAleatoire();
//	}

//	public void deplacementaleatoire(IRobot robot) {
//		// TODO Auto-generated method stub
//		this.avancer(10);
////		Point p = robot.getPosition();
////		// TODO : calculer nouvelle position
////		robot.setPosition(p);
//
//	}

	public Point deplacement(IRobot r) {
		Point p = r.getPosition();
		p.x +=2;
		return p;
	}

}

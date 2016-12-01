package unice.miage.m1.projet;

import java.awt.Point;
import java.util.concurrent.TimeUnit;

public class DeplacementAleatoire implements IPluginDeplacement {

	// private ArrayList<PluginRobot> listRobots;
	// private FenetreF fenetre;
	int vitesse;
	IRobot robot;

	public DeplacementAleatoire() {
		this.vitesse = 10;

	}

	public boolean auBord(IRobot robot) {
		return (robot.getPosition().getX()+20 > robot.xMax - 50 || robot.getPosition().getX()-20 < 50
				|| robot.getPosition().getY()+20 > robot.yMax - 50 || robot.getPosition().getY()-20 < 50);
	}

	// public void avancer(float longueur) {
	// int tours = (int) Double.POSITIVE_INFINITY;
	// for (int i = 1; i <= tours; i++) {
	// // for (PluginRobot robot : listRobots) {
	// int x = (int) robot.getPosition().getX();
	// int y = (int) robot.getPosition().getY();
	// if (this.auBord(robot)) {
	// this.tourner(180);
	// }
	// try {
	// TimeUnit.MILLISECONDS.sleep(100);
	// } catch (InterruptedException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// this.setCap((float) (Math.random() * 360));
	// float capEnRadian = this.cap * (float) (Math.PI / 180); // conversion
	// // degre2radian
	// Point point =new Point(((int) (robot.getPosition().getX() + longueur *
	// (float) Math.cos(capEnRadian))),
	// (int) (robot.getPosition().getY() + longueur * (float)
	// Math.sin(capEnRadian)));
	//
	// robot.setPosition(point);
	//
	//
	// System.out.println("mouvement");
	//
	// fenetre.repaint();
	// }
	// //
	// }
	// }

	// public static void main(String[] args) {
	// PluginDeplacementAleatoire random = new PluginDeplacementAleatoire();
	// }

	// public void deplacementaleatoire(IRobot robot) {
	// // TODO Auto-generated method stub
	// this.avancer(10);
	//// Point p = robot.getPosition();
	//// // TODO : calculer nouvelle position
	//// robot.setPosition(p);
	//
	// }

	public Point deplacement(IRobot r, int vitesse) {
		r.setCap((float) (Math.random() * 360));
		float capEnRadian = r.getCap() * (float) (Math.PI / 180);
		Point p = r.getPosition();
		if (this.auBord(r)) {
			r.tourner(180);
			float capEnRadian2 = r.getCap() * (float) (Math.PI / 180);
			p.x = (int) (p.x + vitesse * (float) Math.cos(capEnRadian2));
			p.y = (int) (p.y + vitesse * (float) Math.sin(capEnRadian2));
		}
		p.x = (int) (p.x + vitesse * (float) Math.cos(capEnRadian));
		p.y = (int) (p.y + vitesse * (float) Math.sin(capEnRadian));
		// System.out.println(p);
		return p;
	}

}

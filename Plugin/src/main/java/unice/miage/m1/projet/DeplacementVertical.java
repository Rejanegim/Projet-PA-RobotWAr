package unice.miage.m1.projet;

import java.awt.Point;
import java.awt.Robot;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class DeplacementVertical implements IPluginDeplacement {

	// le cap doit être soit 90 soit -90 pour un déplacement vertical
//	private FenetreF fenetre;

	public DeplacementVertical() {

////		fenetre = new FenetreF();
//		listRobots = new ArrayList();
//		// Création des robots :
//		for (int i = 0; i < nbRobots; i++) {
//			PluginRobot r1 = new PluginRobot();
//			listRobots.add(r1);
//		}
////		fenetre.setListeRobots(listRobots);
//		gestionDesTours();

	}

//	private void gestionDesTours() {
//		System.out.println("TOURS");
//		// 10 tours de jeu :
//		int tours = (int) Double.POSITIVE_INFINITY;
//		for (int i = 1; i <= tours; i++) {
//		
//			for (PluginRobot robot : listRobots) {
//				int x = robot.getX();
//				int y = robot.getY();
//				if (this.auBord(robot)){
//					y = robot.yMax-y ; 
//				}
//				try {
//					TimeUnit.SECONDS.sleep(1);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				robot.setY(y + 10);
//				System.out.println("mouvement");
////				fenetre.repaint();
//			}
//
//		}
//
//	}

	public boolean auBord(IRobot robot) {
		return (robot.getPosition().getX() > robot.xMax - 5 || robot.getPosition().getX() < 5
				|| robot.getPosition().getY() > robot.yMax - 5 || robot.getPosition().getY() < 5);
	}
	
//	public static void main(String[] args) {
//		DeplacementVertical mo = new DeplacementVertical(2);
//
//	}


	
	public Point deplacement(IRobot r, int vitesse) {
		if (this.auBord(r)) {
			r.tourner(180);
		}
		float capEnRadian = r.getCap() * (float) (Math.PI / 180);
		Point p = r.getPosition();
		p.y +=vitesse *(float) Math.sin(capEnRadian); 
		return p;
	}

}


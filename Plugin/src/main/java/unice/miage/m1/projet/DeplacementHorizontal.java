package unice.miage.m1.projet;

import java.awt.Point;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;


import unice.miage.m1.projet.PluginRobot;

public class DeplacementHorizontal implements IPluginDeplacement {

 // le cap doit être soit 0 soit 180 pour un déplacement horizontal

	public DeplacementHorizontal() {

////		fenetre = new FenetreF();
//
//		listRobots = new ArrayList();
//
//		// Création des robots :
//		for (int i = 0; i < nbRobots; i++) {
//			PluginRobot r1 = new PluginRobot();
//
//			listRobots.add(r1);
		}

//		fenetre.setListeRobots(listRobots);
//		gestionDesTours();

//	}

//	private void gestionDesTours() {
//		System.out.println("TOURS");
//		// 10 tours de jeu :
//		int tours = (int) Double.POSITIVE_INFINITY;
//		for (int i = 1; i <= tours; i++) {
//			for (PluginRobot robot : listRobots) {
//				int x = robot.getX();
//				int y = robot.getY();
//				
//				if (this.auBord(robot)){
//					x = robot.xMax-x ; 
//				}
//
//				try {
//					TimeUnit.SECONDS.sleep(1);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//
//				robot.setX(x + 10);
//			
//				System.out.println("mouvement");
//
////				fenetre.repaint();
//			}
//
//		}
//
//	}
//	
	public boolean auBord(IRobot robot) {
		return (robot.getPosition().getX() > robot.xMax -30 || robot.getPosition().getX() < 30
				|| robot.getPosition().getY() > robot.yMax - 30 || robot.getPosition().getY() < 30);
	}


	public Point deplacement(IRobot r, int vitesse) {
		if (this.auBord(r)) {
			r.tourner(180);
		}		
		float capEnRadian = r.getCap() * (float) (Math.PI / 180); 
		Point p = r.getPosition();
		p.x +=vitesse*(float) Math.cos(capEnRadian);
		return p;
	}
}

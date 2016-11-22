package unice.miage.m1.projet;

import java.awt.Point;
import java.awt.Robot;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class DeplacementVertical implements IPluginDeplacement {

	private ArrayList<PluginRobot> listRobots;

//	private FenetreF fenetre;

	public DeplacementVertical(int nbRobots) {

//		fenetre = new FenetreF();
		listRobots = new ArrayList();
		// Création des robots :
		for (int i = 0; i < nbRobots; i++) {
			PluginRobot r1 = new PluginRobot();
			listRobots.add(r1);
		}
//		fenetre.setListeRobots(listRobots);
		gestionDesTours();

	}

	private void gestionDesTours() {
		System.out.println("TOURS");
		// 10 tours de jeu :
		int tours = (int) Double.POSITIVE_INFINITY;
		for (int i = 1; i <= tours; i++) {
		
			for (PluginRobot robot : listRobots) {
				int x = robot.getX();
				int y = robot.getY();
				if (this.auBord(robot)){
					y = robot.yMax-y ; 
				}
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				robot.setY(y + 10);
				System.out.println("mouvement");
//				fenetre.repaint();
			}

		}

	}

	  public boolean auBord(PluginRobot robot){
	        return (robot.getX()>robot.xMax-5 || 
	                robot.getX()<5      ||
	                robot.getY()>robot.yMax-5 ||
	                robot.getY()<10);
	    }
	
	public static void main(String[] args) {
		DeplacementVertical mo = new DeplacementVertical(2);

	}

	
	public Point deplacement(IRobot robot) {
		// TODO Auto-generated method stub
		return null;
	}
//
//	public Point deplacement() {
//		// TODO Auto-generated method stub
//		return null;
//	}

}


package unice.miage.m1.projet;

import java.awt.Point;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class PluginDeplacementAleatoire implements IPluginDeplacement {

	private float cap;
	private ArrayList<PluginRobot> listRobots;
	private FenetreF fenetre;
	
	
	
	public PluginDeplacementAleatoire(int nbRobots) {

		fenetre = new FenetreF();

		listRobots = new ArrayList();

		// Création des robots :
		for (int i = 0; i < nbRobots; i++) {
			PluginRobot r1 = new PluginRobot();

			listRobots.add(r1);
		}

		fenetre.setListeRobots(listRobots);
		avancer(10);

	}


	public boolean auBord(PluginRobot robot) {
		return (robot.getX() > robot.xMax - 5 || robot.getX() < 5 || robot.getY() > robot.yMax - 5
				|| robot.getY() < 5);
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
	
	 public void avancer(float longueur){
		 int tours = (int) Double.POSITIVE_INFINITY;
			for (int i = 1; i <= tours; i++) {
				for (PluginRobot robot : listRobots) {
					int x = robot.getX();
					int y = robot.getY();
					 if (this.auBord(robot)) {
						this.tourner(180);
						}
					 try {
							TimeUnit.MILLISECONDS.sleep(100);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					 	this.setCap((float) (Math.random()*360));
				        float capEnRadian=this.cap*(float)(Math.PI/180); // conversion degre2radian
				        robot.setX((int) (robot.getX()+longueur*(float)Math.cos(capEnRadian)));
				        robot.setY( (int) (robot.getY()+longueur*(float)Math.sin(capEnRadian)));
			
					System.out.println("mouvement");

					fenetre.repaint();
				}
	       
	    }
	 }

			public static void main(String[] args) {
				PluginDeplacementAleatoire random = new PluginDeplacementAleatoire(4);
			}
	



	public Point deplacement(Robot robot) {
		// TODO Auto-generated method stub
		return null;
	}
	 
}

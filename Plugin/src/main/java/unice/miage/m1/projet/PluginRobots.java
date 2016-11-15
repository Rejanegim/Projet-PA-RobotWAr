package unice.miage.m1.projet;

import java.awt.Graphics;
import java.util.ArrayList;



public class PluginRobots  implements IPluginGraphique {
	
	private ArrayList<PluginRobot> listRobots;
	FenetreF fenetre; 
	int nbrobot  ;
	
	public PluginRobots(int nbRobots) {

		fenetre = new FenetreF();
		listRobots = new ArrayList();
		for (int i = 0; i < nbRobots; i++) {
			PluginRobot r1 = new PluginRobot();

			listRobots.add(r1);
			}
			fenetre.setListeRobots(listRobots);
		}

	
	public FenetreF getFenetre() {
		return fenetre;
	}

	public void setFenetre(FenetreF fenetre) {
		this.fenetre = fenetre;
	}
	
	



	public int getNbrobot() {
		return nbrobot;
	}



	public void setNbrobot(int nbrobot) {
		this.nbrobot = nbrobot;
	}




	public void paint(Graphics g) {
			for (int i = 0; i < listRobots.size(); i++) {
				listRobots.get(i).paint(g);
			}
	}
	
	public static void main(String[] args) {
		 PluginRobots robots = new PluginRobots(3) ;
	}


}

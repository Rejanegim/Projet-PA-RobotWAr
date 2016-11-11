package m1.miage.projet.pa;

import java.awt.Graphics;
import java.util.ArrayList;



public class PluginRobots  implements IPluginGraphique {
	
	private ArrayList<PluginRobot> listRobots;
	Fenetre fenetre; 
	int nbrobot  ;
	
	public PluginRobots(int nbRobots) {

		fenetre = new Fenetre();
		listRobots = new ArrayList();
		for (int i = 0; i < nbRobots; i++) {
			PluginRobot r1 = new PluginRobot();

			listRobots.add(r1);
			}
			fenetre.setListeRobots(listRobots);
		}

	
	public Fenetre getFenetre() {
		return fenetre;
	}

	public void setFenetre(Fenetre fenetre) {
		this.fenetre = fenetre;
	}
	
	



	public int getNbrobot() {
		return nbrobot;
	}



	public void setNbrobot(int nbrobot) {
		this.nbrobot = nbrobot;
	}



	@Override
	public void paint(Graphics g) {
			for (int i = 0; i < listRobots.size(); i++) {
				listRobots.get(i).paint(g);
			}
	}
	
	public static void main(String[] args) {
		 PluginRobots robots = new PluginRobots(3) ;
	}


}

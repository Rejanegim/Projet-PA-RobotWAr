package unice.miage.m1.projet;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;



public class AffichageRobot  implements IPluginGraphique {
	
//	private ArrayList<PluginRobot> listRobots;
//	IFenetre fenetre; 
//	int nbrobot  ;
	
	public AffichageRobot() {
//
////		fenetre = new FenetreF();
//		listRobots = new ArrayList();
//		for (int i = 0; i < nbRobots; i++) {
//			PluginRobot r1 = new PluginRobot();
//
//			listRobots.add(r1);
//			}
////			fenetre.setListeRobots(listRobots);
		}

	
//	public IFenetre getFenetre() {
//		return fenetre;
//	}
//
//	public void setFenetre(IFenetre fenetre) {
//		this.fenetre = fenetre;
//	}
	
//	public int getNbrobot() {
//		return nbrobot;
//	}


//	public void setNbrobot(int nbrobot) {  // peut être pour moteur
//		this.nbrobot = nbrobot;
//	}



	public void paint(Graphics g, IRobot r) {
		Color c = r.getCouleur();
		Point p = r.getPosition();
		g.setColor(c);
		g.drawRect(p.x, p.y, 10, 10);
		g.fillRect(p.x, p.y, 10, 10);
//			for (int i = 0; i < listRobots.size(); i++) {
//				listRobots.get(i).paint(g);
//			}
	}
	


}

package m1.miage.projet.pa;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JFrame;

public class FenetreF extends JFrame implements IPluginGraphique {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<PluginRobot> listRobots;

	public	FenetreF() {
		this.setTitle("RobotWar");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(700, 550);
		this.setVisible(true);
		this.setResizable(false);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2); 
		Toolkit.getDefaultToolkit().setDynamicLayout(false);
	}
	
	public void setListeRobots(ArrayList<PluginRobot> listRobots) {
		this.listRobots = listRobots;
	}

	@Override
	public void paint(Graphics g) {
		Color bg =new Color(255,255,255) ;
		g.setColor(bg);
		g.drawRect(0 , 0 , 510 , 510) ;
		g.fillRect(0, 0, 510, 510);
		for (PluginRobot robot : listRobots) {

			robot.paint(g);
		}
	}
}
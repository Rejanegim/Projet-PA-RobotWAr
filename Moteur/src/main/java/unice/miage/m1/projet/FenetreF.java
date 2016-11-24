package unice.miage.m1.projet;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JFrame;

public class FenetreF extends JFrame implements IFenetre {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<IRobot> listRobots = new ArrayList<IRobot>();

	public	FenetreF() {
		this.setTitle("RobotWar");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(900, 590);
		this.setVisible(true);
		this.setResizable(false);
		this.setBackground(Color.black);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2); 
		Toolkit.getDefaultToolkit().setDynamicLayout(false);
	}
	
	public void setListeRobots(ArrayList<IRobot> listRobots) {
		this.listRobots = listRobots;
	}

	@Override
	public void paint(Graphics g) {
		Color bg = Color.WHITE ;
		g.setColor(bg);
		g.drawRect(0 , 0 , 540 , 540) ;
		g.fillRect(0, 0, 540, 540);
		for (IRobot robot : listRobots) {
			robot.paint(g);
		}

	}
}
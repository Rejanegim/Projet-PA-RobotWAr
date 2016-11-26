package unice.miage.m1.projet;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

public class FenetreF extends JFrame implements IFenetre {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<IRobot> listRobots = new ArrayList<IRobot>();
	private JMenuBar menuBar ;

	public FenetreF() {
		this.setTitle("RobotWar");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1000, 700);
	//	this.setResizable(false);
		this.setBackground(Color.black);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
		Toolkit.getDefaultToolkit().setDynamicLayout(false);
	}

	public void setListeRobots(ArrayList<IRobot> listRobots) {
		this.listRobots = listRobots;
	}

	
	public ArrayList<IRobot> getListRobots() {
		return listRobots;
	}


	@Override
	public void paint(Graphics g) {
		Color bg = Color.WHITE;
		g.setColor(bg);
		g.drawRect(0, 20, 800, 650);
		g.fillRect(0, 20, 800, 650);
		for (IRobot robot : listRobots) {
			robot.paint(g);
		}

	}
}
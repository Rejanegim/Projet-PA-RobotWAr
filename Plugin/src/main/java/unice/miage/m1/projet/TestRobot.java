package unice.miage.m1.projet;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class TestRobot extends JFrame implements IPluginGraphique {

	public TestRobot() {
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
	
	public void paint(Graphics g){
		Color bg =new Color(255,255,255) ;
		g.setColor(bg);
		g.drawRect(0 , 0 , 510 , 510) ;
		g.fillRect(0, 0, 510, 510);
		PluginRobot Robot1 = new PluginRobot();
		Robot1.paint(g);
		PluginRobot Robot2 = new PluginRobot();
		Robot2.paint(g);
		PluginRobot Robot3 = new PluginRobot();
		Robot3.paint(g);
	}

	public static void main(String[] args) {
		TestRobot ts = new TestRobot();
		
	}
}

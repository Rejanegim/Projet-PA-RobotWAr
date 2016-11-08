package m1.miage.projet.pa;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TestRobot extends JFrame {

	public TestRobot() {
		this.setTitle("RobotWar");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500, 500);
		this.setVisible(true);
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		PluginRobot pr1 = new PluginRobot() ;
		PluginRobot pr2 = new PluginRobot() ;
		mainPanel.add(pr1);
		mainPanel.add(pr1);
		this.setContentPane(pr1);
		this.setContentPane(pr2);
	}
	
	public static void main(String[] args) {
		TestRobot ts = new TestRobot();
		
	}
}

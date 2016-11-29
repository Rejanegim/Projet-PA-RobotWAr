package unice.miage.m1.projet;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;

public class FenetreF extends JFrame implements IFenetre {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<IRobot> listRobots = new ArrayList<IRobot>();
	private JButton bouton = new JButton("Ajouter un Robot");

	public FenetreF() {
		this.setTitle("RobotWar");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1200, 700);
	//	this.setResizable(false);
		this.setBackground(Color.black);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
		Toolkit.getDefaultToolkit().setDynamicLayout(false);
		this.getContentPane().setLayout(new FlowLayout());
		this.getContentPane().add(bouton);
		bouton.addActionListener(new ActionListener() {

			public List<Class> getList() throws ClassNotFoundException {
				File fichier = new File("");
				String chemin = fichier.getAbsolutePath().replaceAll("Moteur",
						"Plugin" + File.separator + "target" + File.separator + "classes");
				File f = new File(chemin);
				Repository rep = new Repository(f);
				List l = rep.load();
				return l;
			}

			public void actionPerformed(ActionEvent arg0) {
				try {
					ChoixRobot cr = new ChoixRobot(null, "Créez votre Robot", true, this.getList());
					Robot robot = cr.afficherRobot() ;
					Class<?>[] interf =this.getList().get(0).getInterfaces() ;
					String nominter = interf[0].getName() ; 
					 ArrayList<IRobot> list = cr.getListRobots();
					 for (int i = 0; i < list.size(); i++) {
						 listRobots.add(list.get(i)) ;
					}
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		});
		this.setVisible(true);
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
	//	g.drawRect(0, 20, 800, 650);
		g.fillRect(10, 40, 800, 650);
		for (IRobot robot : listRobots) {
			robot.paint(g);
		}
	}
	
	
//	public static void main(String[] args) {
//		FenetreF f = new FenetreF();
//	}
}
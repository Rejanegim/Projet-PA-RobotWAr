package unice.miage.m1.projet;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FenetreF extends JFrame implements IFenetre {

	
	private static final long serialVersionUID = 1L;
	private ArrayList<IRobot> listRobots = new ArrayList<IRobot>();
	private JButton bouton = new JButton("Ajouter un Robot");
	private JButton bouton2 = new JButton("Modifier un Robot");
	private JButton bouton3 = new JButton("Ajouter un plugin");
	public JPanel panel = new JPanel() {
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			for (IRobot robot : listRobots) {
				robot.paint(g);
			}
		}
	};
	
	/**
	 * Contructeur de FenetreF.
	 * Met en place tous les éléments de
	 * la Fenetre du jeu.
	 */
	public FenetreF() {
		this.setTitle("RobotWar");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800, 700);
		this.setResizable(false);
		this.setBackground(Color.black);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
		Toolkit.getDefaultToolkit().setDynamicLayout(false);
		this.getContentPane().setLayout(new FlowLayout());
		panel.setPreferredSize(new Dimension(650, 600));
		panel.setSize(650, 600);
		panel.setBackground(Color.white);
		this.getContentPane().add(panel, BorderLayout.CENTER);
		JPanel control = new JPanel();
		control.setPreferredSize(new Dimension(300,500));
		control.add(bouton);
	    control.add(bouton2);
	    control.add(bouton3);
	    this.getContentPane().add(control, BorderLayout.NORTH);
//		this.getContentPane().add(bouton);
//		this.getContentPane().add(bouton2);
//		this.getContentPane().add(bouton3);
		this.pack();
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
			// Definit l'action du bouton
			public void actionPerformed(ActionEvent arg0) {
				try {
					ChoixRobot cr = new ChoixRobot(null, "Créez votre Robot", true, this.getList());
					Robot robot = cr.afficherRobot();
					Class<?>[] interf = this.getList().get(0).getInterfaces();
					String nominter = interf[0].getName();
					ArrayList<IRobot> list = cr.getListRobots();
					synchronized (listRobots) {
						for (int i = 0; i < list.size(); i++) {
							listRobots.add(list.get(i));
						}
					}
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		});
		bouton2.addActionListener(new ActionListener() {
			public List<Class> getList() throws ClassNotFoundException {
				File fichier = new File("");
				String chemin = fichier.getAbsolutePath().replaceAll("Moteur",
						"Plugin" + File.separator + "target" + File.separator + "classes");
				File f = new File(chemin);
				Repository rep = new Repository(f);
				List l = rep.load();
				return l;
			}
			// Definit l'action du bouton
			public void actionPerformed(ActionEvent arg0) {
				try {
					ConfigurationRobot cr = new ConfigurationRobot(null, "Configurer votre Robot", true, this.getList(),FenetreF.this);
					Robot robot = cr.afficherRobot();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		});
		bouton3.addActionListener(new ActionListener() {
	
			// Definit l'action du bouton
			public void actionPerformed(ActionEvent arg0) {
			AjouterPlugin ap = new AjouterPlugin(null, "Ajouter un plugin",true);
			Robot robot = ap.afficher();
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

}
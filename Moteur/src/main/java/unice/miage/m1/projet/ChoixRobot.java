package unice.miage.m1.projet;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ChoixRobot extends JDialog {
	List<Class> plugins;
	private ArrayList<IRobot> listRobots = new ArrayList<IRobot>();
	private Robot robot = new Robot();
	private boolean sendData;
	private JLabel graphique, deplacement, attaque;
	private JComboBox mouve, attack, draw;
	private IPluginDeplacement pluginDeplacement;
	private IPluginGraphique pluginsgraphique ;
	private IPluginAttaque pluginattaque;

	/**
	 * Constructeur de la classe
	 */
	public ChoixRobot(JFrame parent, String title, boolean modal, List<Class> l) {
		super(parent, title, modal);
		this.plugins = l;
		this.setSize(550, 400);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		this.initComponent();
	}

	/**
	 * Affiche la boite de dialogue
	 */
	public Robot afficherRobot() {
		this.sendData = false;
		this.setVisible(true);
		return this.robot;
	}

	public ArrayList<IRobot> getListRobots() {
		return listRobots;
	}

	public void setListRobots(ArrayList<IRobot> listRobots) {
		this.listRobots = listRobots;
	}

	/**
	 * Dessine les éléments de la boite de dialogue
	 */
	private void initComponent() {

		// Le graphisme
		JPanel choixGraphisme = new JPanel();
		choixGraphisme.setBackground(Color.white);
		choixGraphisme.setPreferredSize(new Dimension(440, 100));
		choixGraphisme.setBorder(BorderFactory.createTitledBorder("Déplacement du robot"));
		draw = new JComboBox();
		for (int i = 0; i < plugins.size(); i++) {
			Class<?>[] interd = plugins.get(i).getInterfaces();
			for (int j = 0; j < interd.length; j++) {
				if (interd[j].getName() == "unice.miage.m1.projet.IPluginGraphique") {
					draw.addItem(plugins.get(i).getName().replace("unice.miage.m1.projet.", ""));
				}
			}
		}
		graphique = new JLabel("Deplacement : ");
		choixGraphisme.add(graphique);
		choixGraphisme.add(draw);
		
		
		// Le déplacement
		JPanel choixDeplacement = new JPanel();
		choixDeplacement.setBackground(Color.white);
		choixDeplacement.setPreferredSize(new Dimension(440, 100));
		choixDeplacement.setBorder(BorderFactory.createTitledBorder("Déplacement du robot"));
		mouve = new JComboBox();
		for (int i = 0; i < plugins.size(); i++) {
			Class<?>[] interd = plugins.get(i).getInterfaces();
			for (int j = 0; j < interd.length; j++) {
				if (interd[j].getName() == "unice.miage.m1.projet.IPluginDeplacement") {
					mouve.addItem(plugins.get(i).getName().replace("unice.miage.m1.projet.", ""));
				}
			}
		}
		deplacement = new JLabel("Deplacement : ");
		choixDeplacement.add(deplacement);
		choixDeplacement.add(mouve);

		// L'attaque
		JPanel choixAttaque = new JPanel();
		choixAttaque.setBackground(Color.white);
		choixAttaque.setPreferredSize(new Dimension(440, 100));
		choixAttaque.setBorder(BorderFactory.createTitledBorder("Attaque du robot"));
		attack = new JComboBox();
		for (int i = 0; i < plugins.size(); i++) {
			Class<?>[] intera = plugins.get(i).getInterfaces();
			for (int j = 0; j < intera.length; j++) {
				if (intera[j].getName() == "unice.miage.m1.projet.IPluginAttaque") {
					attack.addItem(plugins.get(i).getName().replace("unice.miage.m1.projet.", ""));
				}
			}
		}
		attaque = new JLabel("Attaque : ");
		choixAttaque.add(attaque);
		choixAttaque.add(attack);

		JPanel content = new JPanel();
		content.setBackground(Color.white);

		content.add(choixGraphisme);
		content.add(choixDeplacement);
		content.add(choixAttaque);

		JPanel control = new JPanel();
		JButton boutonRobot = new JButton("Créer le Robot");

		boutonRobot.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				for (int j = 0; j < plugins.size(); j++) {
					if (plugins.get(j).getName().equals("unice.miage.m1.projet." + draw.getSelectedItem())) {
						Class<?> classe = plugins.get(j);
						Constructor[] c = classe.getConstructors();
						Constructor cons = c[0]; // on va dans un 1er temps
													// supposé
													// qu'il n'y qu'un seul
													// constructeur
						// get contstuctor
						Object o;
						try {
							o = cons.newInstance();
							// invoke
							pluginsgraphique  = (IPluginGraphique) o;
						} catch (InstantiationException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IllegalAccessException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IllegalArgumentException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (InvocationTargetException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

					}
					if (plugins.get(j).getName().equals("unice.miage.m1.projet." + mouve.getSelectedItem())) {
						Class<?> classe = plugins.get(j);
						Constructor[] c = classe.getConstructors();
						Constructor cons = c[0]; // on va dans un 1er temps
													// supposé
													// qu'il n'y qu'un seul
													// constructeur
						// get contstuctor
						Object o;
						try {
							o = cons.newInstance();
							// invoke
							pluginDeplacement = (IPluginDeplacement) o;
						} catch (InstantiationException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IllegalAccessException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IllegalArgumentException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (InvocationTargetException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

					}
					if (plugins.get(j).getName().equals("unice.miage.m1.projet." + attack.getSelectedItem())) {
						Class<?> classe = plugins.get(j);
						Constructor[] c = classe.getConstructors();
						Constructor cons = c[0]; // on va dans un 1er temps
													// supposé
													// qu'il n'y qu'un seul
													// constructeur
						// get contstuctor
						Object o;
						try {
							o = cons.newInstance();
							// invoke
							pluginattaque = (IPluginAttaque) o;
						} catch (InstantiationException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IllegalAccessException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IllegalArgumentException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (InvocationTargetException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

					}
				}

				IRobot rb = new Robot(pluginDeplacement, pluginsgraphique, pluginattaque);
				synchronized (listRobots) {
					listRobots.add(rb);
				}
				System.out.println("un robot est crée !");
				setVisible(false);
				
			}


		});

		JButton cancelBouton = new JButton("Annuler");
		cancelBouton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});

		control.add(boutonRobot);
		control.add(cancelBouton);

		this.getContentPane().add(content, BorderLayout.CENTER);
		this.getContentPane().add(control, BorderLayout.SOUTH);
	}
}
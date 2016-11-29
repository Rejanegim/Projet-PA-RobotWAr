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
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class ChoixRobot extends JDialog {
	List<Class> plugins ;
	private ArrayList<IRobot> listRobots = new ArrayList<IRobot>();
	private Robot robot = new Robot();
	private boolean sendData;
	private JLabel graphique, deplacement, attaque ; 
	private ArrayList<Class> pg ; 
	private JCheckBox[] graphisme ;
	private JComboBox mouve, attack;
	private IPluginDeplacement pluginDeplacement;
	private ArrayList<IPluginGraphique> pluginsgraphique = new ArrayList<IPluginGraphique> (); 
	private IPluginAttaque pluginattaque ;
	//private JTextField nom ; 

	public ChoixRobot(JFrame parent, String title, boolean modal, List<Class> l) {
		super(parent, title, modal);
		this.plugins = l ;
		this.setSize(550, 400);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		this.initComponent();
	}

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

	private void initComponent() {
		

	    	JPanel panGraf = new JPanel();
		    panGraf.setBackground(Color.white);
		    panGraf.setBorder(BorderFactory.createTitledBorder("Affichage"));
		    panGraf.setPreferredSize(new Dimension(440, 100));
		    List<String> where = new ArrayList<String>();
			for (int i = 0; i < plugins.size(); i++) {
				Class<?>[] inter = plugins.get(i).getInterfaces() ; 
				for (int j = 0; j < inter.length; j++) {
					if(inter[j].getName() =="unice.miage.m1.projet.IPluginGraphique"){
						where.add(plugins.get(i).getName().replace("unice.miage.m1.projet.", ""));
					}
				}
			}
			String[] boxes = new String[ where.size() ];
			where.toArray( boxes );
//			JCheckBox [] cb = new JCheckBox [boxes.length] ;
			graphisme = new JCheckBox [boxes.length] ;
		    for(int i = 0; i < graphisme.length; i++){
		       graphisme[i] = new JCheckBox(boxes[i]);
		    }
		    graphisme[0].setSelected(true);
		    for(int i = 0; i < boxes.length; i++){
		    	panGraf.add(graphisme[i]);
		    }
		

		// Le déplacement
		JPanel choixDeplacement = new JPanel();
		choixDeplacement.setBackground(Color.white);
		choixDeplacement.setPreferredSize(new Dimension(440,100));
		choixDeplacement.setBorder(BorderFactory.createTitledBorder("Déplacement du robot"));
		mouve = new JComboBox();
		for (int i = 0; i < plugins.size(); i++) {
			Class<?>[] interd = plugins.get(i).getInterfaces() ; 
			for (int j = 0; j < interd.length; j++) {
				if(interd[j].getName() =="unice.miage.m1.projet.IPluginDeplacement"){
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
			Class<?>[] intera = plugins.get(i).getInterfaces() ; 
			for (int j = 0; j < intera.length; j++) {
				if(intera[j].getName() =="unice.miage.m1.projet.IPluginAttaque"){
					attack.addItem(plugins.get(i).getName().replace("unice.miage.m1.projet.", ""));
				}
			}
		}
		attaque = new JLabel("Attaque : ");
		choixAttaque.add(attaque);
		choixAttaque.add(attack);


		
		JPanel content = new JPanel();
		content.setBackground(Color.white);
	
	
		content.add(panGraf);
		content.add(choixDeplacement);
		content.add(choixAttaque);
	
		JPanel control = new JPanel();
		JButton boutonRobot = new JButton("Créer le Robot");

		boutonRobot.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				for (int j = 0; j < plugins.size(); j++) {
				if (plugins.get(j).getName().equals("unice.miage.m1.projet."+mouve.getSelectedItem())) {
					Class<?> classe  = plugins.get(j);
					Constructor[] c = classe.getConstructors();
					Constructor cons = c[0]; // on va dans un 1er temps supposé
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
				if (plugins.get(j).getName().equals("unice.miage.m1.projet."+attack.getSelectedItem())) {
					Class<?> classe  = plugins.get(j);
					Constructor[] c = classe.getConstructors();
					Constructor cons = c[0]; // on va dans un 1er temps supposé
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

				IRobot rb = new Robot(pluginDeplacement,getGraphiques(),pluginattaque); 
				listRobots.add(rb);
				System.out.println("un robot est crée !");
//				// TODO Auto-generated method stub
				
//				
			}
		      public  ArrayList<IPluginGraphique> getGraphiques(){
		    	  ArrayList<String> graphlist = new ArrayList<String>() ;
		    	 for (int i = 0; i < graphisme.length; i++) {
					if (graphisme[i].isSelected()){
						graphlist.add(graphisme[i].getText());
					}
				}
		    	 for (int i = 0; i < graphlist.size(); i++) {
		    		 for (int k = 0; k < plugins.size(); k++) {
		    			 if (plugins.get(k).getName().equals("unice.miage.m1.projet."+graphlist.get(i))) {
		 					Class<?> classe  = plugins.get(k);
		 					Constructor[] c = classe.getConstructors();
		 					Constructor cons = c[0]; // on va dans un 1er temps supposé
		 												// qu'il n'y qu'un seul
		 												// constructeur
		 					// get contstuctor
		 					Object o;
		 					try {
		 						o = cons.newInstance();
		 						// invoke
		 						pluginsgraphique.add((IPluginGraphique) o); 
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
				}
		               return pluginsgraphique;
		      }
		});

		JButton cancelBouton = new JButton("Voir le robot crée");
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
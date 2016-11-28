package unice.miage.m1.projet;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
	private Robot robot = new Robot();
	private boolean sendData;
	private JLabel graphique, deplacement, attaque ; 
	private ArrayList<Class> pg ; 
	private ArrayList<JCheckBox> graphisme ;
	private JComboBox mouve, attack;
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

	private void initComponent() {
		

	    	JPanel panGraf = new JPanel();
		    panGraf.setBackground(Color.white);
		    panGraf.setBorder(BorderFactory.createTitledBorder("Affichage"));
		    panGraf.setPreferredSize(new Dimension(440, 150));
		    List<String> where = new ArrayList<String>();
		   // = {"15 - 25 ans","26 - 35 ans","36 - 50 ans", "+ de 50 ans"} ;
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
		    //		    JCheckBox[] boxes = new JCheckBox[choixGraph.length];
			JCheckBox [] cb = new JCheckBox [boxes.length] ;
		    for(int i = 0; i < cb.length; i++){
		       cb[i] = new JCheckBox(boxes[i]);
		    }
		    cb[0].setSelected(true);
		    for(int i = 0; i < boxes.length; i++){
		    	panGraf.add(cb[i]);
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
//				robot = new Robot((IPluginDeplacement)mouve.getSelectedItem(),getGraphiques(),(IPluginAttaque)attack.getSelectedItem()); 
//				// TODO Auto-generated method stub
//				
//			}
//		      public  ArrayList<IPluginGraphique> getGraphiques(){
//		    	  ArrayList<IPluginGraphique> pluginsgraphiques = new ArrayList<IPluginGraphique>() ;
//		    	 for (int i = 0; i < graphisme.size(); i++) {
//					if (graphisme.get(i).isSelected()){
//						pluginsgraphiques.add((IPluginGraphique) graphisme.get(i));
//					}
//				}
//		               return pluginsgraphiques;
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
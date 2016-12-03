package unice.miage.m1.projet;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AjouterPlugin extends JDialog {

	private Robot zInfo = new Robot();
	private boolean sendData;
	private JLabel cheminLabel;
	private JTextField chemin ;

	public AjouterPlugin(JFrame parent, String title, boolean modal){
	    super(parent, title, modal);
	    this.setSize(700, 100);
	    this.setLocationRelativeTo(null);
	    this.setResizable(false);
	    this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
	    this.initComponent();

	  }

	public Robot afficher() {
		this.sendData = false;
		this.setVisible(true);
		return this.zInfo;
	}
	
	private void initComponent(){

	
	    //Récuperer le chemin

	    JPanel panChemin = new JPanel();
	    panChemin.setBackground(Color.white);
	    panChemin.setPreferredSize(new Dimension(520, 60));
	    chemin = new JTextField();
	    chemin.setPreferredSize(new Dimension(500,25));
	    panChemin.setBorder(BorderFactory.createTitledBorder("Saisir le chemin absolue de votre plugin"));
	  //  cheminLabel = new JLabel("Saisir le chemin absolue de votre plugin:");
	   // panChemin.add(cheminLabel);
	    panChemin.add(chemin);
	    
	    JPanel content = new JPanel();
	    content.setBackground(Color.white);
	    content.add(panChemin);
	    
	    JPanel control = new JPanel();
	    JButton okBouton = new JButton("Ajouter");
	    
	    okBouton.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent arg0) {         
	    		String source = chemin.getText() ;
	    		File f = new File(source);
	    		File fichier = new File("");
				String chemincourant = fichier.getAbsolutePath().replaceAll("Moteur",
						"Plugin" + File.separator + "target" + File.separator + "classes");
	    		String nomPlugin = "unice" +File.separator +"miage" +File.separator +"m1" +File.separator +"projet" +File.separator +f.getName();
	    		String destination = chemincourant +File.separator +nomPlugin ; 
	    		FileInputStream fis = null;
	    		FileOutputStream fos = null;

	    		try {
	    			fis = new FileInputStream(source);
	    			fos = new FileOutputStream(destination);
	    			
	    			byte[] buffer = new byte[1024];
	    			int noOfBytes = 0;

	    			// lire les bytes du fichiers source pour les écrire dans le fichier destinataire
	    			while ((noOfBytes = fis.read(buffer)) != -1) {
	    				fos.write(buffer, 0, noOfBytes);
	    			}
	    		}
	    		catch (FileNotFoundException e) {
	    			System.out.println("Fichier non trouvé" + e);
	    		}
	    		catch (IOException ioe) {
	    			System.out.println("Problème rencontré" + ioe);
	    		}
	    		finally {
	    			// Fermer tous les fichiers une fois le copier/coller terminé
	    			try {
	    				if (fis != null) {
	    					fis.close();
	    				}
	    				if (fos != null) {
	    					fos.close();
	    				}
	    			}
	    			catch (IOException ioe) {
	    				System.out.println("Error while closing stream: " + ioe);
	    			}
	    		}
	    		 setVisible(false);
	        }      
	    });


	    JButton cancelBouton = new JButton("Annuler");

	    cancelBouton.addActionListener(new ActionListener(){
	      public void actionPerformed(ActionEvent arg0) {
	        setVisible(false);
	      }      

	    });
	    
	    control.add(okBouton);
	    control.add(cancelBouton);

	    this.getContentPane().add(content, BorderLayout.CENTER);
	    this.getContentPane().add(control, BorderLayout.SOUTH);
	}
}

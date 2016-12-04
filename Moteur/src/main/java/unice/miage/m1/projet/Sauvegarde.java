package unice.miage.m1.projet;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileSystemView;

//import gui.ChoosePluginFrame;
import unice.miage.m1.projet.*;


/**
 * Classe permettant de gerer la persistance, 
 * soit la sauvegarde et la restauration
 */
public class Sauvegarde implements Serializable{
	private static final String FILE_EXTENSION = ".rw";

	private Moteur jeu;

	/**
	 * Constructeur 
	 * 
	 * @param gui
	 */
	public Sauvegarde(Moteur jeu) {
		this.jeu = jeu;
	}

	
	/**
	 * Methode permettant de 
	 * sauvegarder l'etat de jeu
	 */	
	
	public void save() {
		JFileChooser chooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		chooser.setDialogTitle("Emplacement de la sauvegarde");
		chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		chooser.setAcceptAllFileFilterUsed(false);
		chooser.setFileFilter(new FileFilter() {
			@Override
			public String getDescription() {
				return FILE_EXTENSION;
			}
			
			@Override
			public boolean accept(File f) {
				return f.getName().endsWith(FILE_EXTENSION);
		}
			});
		
		FenetreF fenetre= jeu.getFenetre() ;
//		
		if (chooser.showSaveDialog(fenetre) == JFileChooser.APPROVE_OPTION) {
//
			ObjectOutputStream oos = null;

			try {
				String path = chooser.getSelectedFile().getAbsolutePath();
				if (!path.endsWith(FILE_EXTENSION))
				{
					path+=FILE_EXTENSION;
				}
				final FileOutputStream fichier = new FileOutputStream(new File(path));
				oos = new ObjectOutputStream(fichier);
				ArrayList<IRobot> listeRobots = jeu.getListRobots();
				oos.writeObject(listeRobots) ; 
				for (int i = 0; i <listeRobots.size(); i++) {
					oos.writeObject(listeRobots.get(i));
//					oos.writeObject(listeRobots.get(i).getPluginsgraphique());
//					oos.writeObject(listeRobots.get(i).getPluginattaque());
//					oos.writeObject(listeRobots.get(i).getPluginDeplacement());
//					oos.writeObject(listeRobots.get(i).getCouleur());
//					oos.writeObject(listeRobots.get(i).getPosition());
//					oos.writeObject(listeRobots.get(i).getCap()); //Pas nécessaire? 
				}
				oos.flush();
			} catch (final java.io.IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if (oos != null) {
						oos.flush();
						oos.close();
					}
				} catch (final IOException ex) {
					ex.printStackTrace();
				}
			}

		}

	}
	/**
	 * Methode permettant la restauration
	 * d'un etat de jeu sauvegardé
	 */
	public void load() {
		// Construction de l'interface
		JFileChooser chooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		chooser.setDialogTitle("Chargement de la sauvegarde");
		chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		chooser.setAcceptAllFileFilterUsed(false);
		chooser.setFileFilter(new FileFilter() {
			@Override
			public String getDescription() {
				return FILE_EXTENSION;
			}

			@Override
			public boolean accept(File f) {
				return f.getName().endsWith(FILE_EXTENSION);
			}
		});
		FenetreF fenetre= jeu.getFenetre() ;
		if (chooser.showOpenDialog(fenetre) == JFileChooser.APPROVE_OPTION) {
			ObjectInputStream ois = null;
			try {
				final FileInputStream fichier = new FileInputStream(chooser.getSelectedFile());
				ois = new ObjectInputStream(fichier);
				final ArrayList<IRobot> listeRobots = (ArrayList<IRobot>) ois.readObject();
				IRobot robot = (IRobot) ois.readObject() ; 
				this.jeu = new Moteur() ;
				jeu.setListRobots( listeRobots);
//				for (int i = 0; i < listeRobots.size(); i++) {
//					listeRobots.get(i).paint(fenetre.getGraphics());
//					listeRobots.get(i).deplacement();
//					listeRobots.get(i).attaque();
//				}

			} catch (final java.io.IOException e) {
				e.printStackTrace();
			} catch (final ClassNotFoundException e) {
				e.printStackTrace();
			} finally {
				try {
					if (ois != null) {
						ois.close();
					}
				} catch (final IOException ex) {
					ex.printStackTrace();
				}
			}
		}
	}




}
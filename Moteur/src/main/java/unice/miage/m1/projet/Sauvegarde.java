package unice.miage.m1.projet;

import java.awt.Color;

import java.awt.Point;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileSystemView;

import unice.miage.m1.projet.*;

/**
 * Classe permettant de gerer la persistance, soit la sauvegarde et la
 * restauration
 */
public class Sauvegarde implements Serializable {
	private static final String FILE_EXTENSION = ".rw";

	private Moteur jeu;
	ArrayList<IRobot> localist = new ArrayList<IRobot>();
	List<Class> plugins;
	IPluginGraphique draw;
	IPluginDeplacement move;
	IPluginAttaque kick;

	/**
	 * Constructeur
	 * 
	 * @param gui
	 */
	public Sauvegarde(Moteur jeu) {
		this.jeu = jeu;
		try {
			plugins = jeu.getFenetre().getList();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}

	/**
	 * Methode permettant de sauvegarder l'etat de jeu
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

		FenetreF fenetre = jeu.getFenetre();
		//
		if (chooser.showSaveDialog(fenetre) == JFileChooser.APPROVE_OPTION) {
			//
			ObjectOutputStream oos = null;

			try {
				String path = chooser.getSelectedFile().getAbsolutePath();
				if (!path.endsWith(FILE_EXTENSION)) {
					path += FILE_EXTENSION;
				}
				final FileOutputStream fichier = new FileOutputStream(new File(path));
				oos = new ObjectOutputStream(fichier);
				ArrayList<IRobot> listeRobots = jeu.getListRobots();
				oos.writeObject(listeRobots.size());
				// oos.writeObject(listeRobots) ;
				for (int i = 0; i < listeRobots.size(); i++) {
					// oos.writeObject(listeRobots.get(i));
					oos.writeObject(listeRobots.get(i).getPluginsgraphique().getClass().getName());
					oos.writeObject(listeRobots.get(i).getPluginattaque().getClass().getName());
					oos.writeObject(listeRobots.get(i).getPluginDeplacement().getClass().getName());
					oos.writeObject(listeRobots.get(i).getCouleur());
					oos.writeObject(listeRobots.get(i).getPosition());
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
	 * Methode permettant la restauration d'un etat de jeu sauvegardé
	 */
	public void load() {
		// Construction de l'interface
		JFileChooser chooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		chooser.setDialogTitle("Restauration de la sauvegarde");
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
		FenetreF fenetre = jeu.getFenetre();
		if (chooser.showOpenDialog(fenetre) == JFileChooser.APPROVE_OPTION) {
			ObjectInputStream ois = null;
			try {
				final FileInputStream fichier = new FileInputStream(chooser.getSelectedFile());
				ois = new ObjectInputStream(fichier);
				int length = (Integer) ois.readObject();
				for (int j = 0; j < length; j++) {
					String drawing = (String) ois.readObject();
					for (int k = 0; k < plugins.size(); k++) {
						if (plugins.get(k).getName().equals(drawing)) {
							Class<?> classe = plugins.get(k);
							Constructor[] c = classe.getConstructors();
							Constructor cons = c[0];
							Object o;
							try {
								o = cons.newInstance();
								// invoke
								draw = (IPluginGraphique) o;
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
					String attack = (String) ois.readObject();
					for (int k = 0; k < plugins.size(); k++) {
						if (plugins.get(k).getName().equals(attack)) {
							Class<?> classe = plugins.get(k);
							Constructor[] c = classe.getConstructors();
							Constructor cons = c[0];
							Object o;
							try {
								o = cons.newInstance();
								// invoke
								kick = (IPluginAttaque) o;
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
					String moving = (String) ois.readObject();
					for (int k = 0; k < plugins.size(); k++) {
						if (plugins.get(k).getName().equals(moving)) {
							Class<?> classe = plugins.get(k);
							Constructor[] c = classe.getConstructors();
							Constructor cons = c[0];
							Object o;
							try {
								o = cons.newInstance();
								// invoke
								move = (IPluginDeplacement) o;
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
					Color color = (Color) ois.readObject();
					Point position = (Point) ois.readObject();
						Robot robot = new Robot(move, draw, kick);
						robot.setPosition(position);
						robot.setCouleur(color);
						robot.paint(jeu.getFenetre().getGraphics());
						robot.deplacement();
						robot.attaque(jeu.getFenetre().getListRobots());
						localist.add(robot);
	
				}

				jeu.getFenetre().setListeRobots(localist);
				jeu.setListRobots(localist);

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
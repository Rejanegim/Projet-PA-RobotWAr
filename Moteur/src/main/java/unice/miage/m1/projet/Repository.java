package unice.miage.m1.projet;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class Repository implements  Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2807021015360468260L;

	private File base ;

	public ArrayList<String> tableau = new ArrayList<String>();
	
	/**
	 * Classe interne permettant de trouver 
	 * tous les fichiers se terminant par
	 * ".class" dans un repertoire donné.
	 * 
	 */
	class MyFV extends SimpleFileVisitor {

		public FileVisitResult visitFile(Object file, BasicFileAttributes attrs) throws IOException {
			String s = file.toString();
			if (s.endsWith(".class")) {
				tableau.add(s.replace(base.getAbsolutePath() +File.separator, "").replaceAll(File.separator, "."));
			}
//			 System.out.println(tableau.toString());
			return super.visitFile(file, attrs);
		}

	}
	/**
	 * Constructeur de Repository
	 * 
	 */
	public Repository(File base) {
		this.base = base;
		SimpleFileVisitor fichiersV = new MyFV();
		try {
			Files.walkFileTree(base.toPath(), fichiersV);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * Méthode permettant le
	 * chargement de tous les fichier 
	 * ".class" du répertoire.
	 */
	public List<Class<?>> load() throws ClassNotFoundException {
		ArrayList<Class<?>> liste = new ArrayList<Class<?>>(tableau.size());
		MyClassLoader mcl = new MyClassLoader();

		for (int i = 0; i < tableau.size(); i++) {
			String s = tableau.get(i).replaceAll(".class", "");
			s = s.replace(File.separator, ".");
			mcl.setPath(this.base);
			liste.add(mcl.loadClass(s));

		}

		return (List<Class<?>>) liste;
	}

//	public static void main(String[] args) throws ClassNotFoundException {
//			File fichier = new File("") ;
//			String chemin= fichier.getAbsolutePath();
//			chemin = chemin.replaceAll("Moteur", "Plugin"+File.separator+"target"+File.separator+"classes");
////		File f = new File(
////				"/home/deptinfo/Documents/workspacePA/Projet-PA-RobotWAr/Plugin/target/classes");
//		File f = new File(chemin);
//		Repository rep = new Repository(f);
//		rep.load();
//	}

}
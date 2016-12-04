package unice.miage.m1.projet;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.security.SecureClassLoader;
import java.util.ArrayList;

public class MyClassLoader extends SecureClassLoader implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7169761967649553847L;
	private ArrayList<File> path = new ArrayList<File>();

	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		byte[] b = null;
		try {
			b = loadClassData(name);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return super.defineClass(name, b, 0, b.length);
	}

	private byte[] loadClassData(String name) throws ClassNotFoundException, IOException {
		// TODO A COMPLETER
		String nameFile = name.replace(".", File.separator);
		nameFile = nameFile + ".class";
		byte[] byt = null;
		for (int i = 0; i < path.size(); i++) {
			if (path.get(i).isDirectory()) {
				File fi = new File(path.get(i), nameFile);// obtenir le chemin//										// absolue
				byt = Files.readAllBytes(fi.toPath());
			}
		}

		return byt;
	}

	public ArrayList<File> getPath() {
		return path;
	}

	public void setPath(File path) {
		this.path.add(path);
	}
//
//	public static void main(String[] args) throws ClassNotFoundException {
//		MyClassLoader mcl = new MyClassLoader();
//		mcl.path.add(new File("/home/deptinfo/workspace/Chenille/bin/"));
//		System.out.println(mcl.loadClass("Ellipse"));
//	}
}

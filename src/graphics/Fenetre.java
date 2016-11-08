package graphics;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

public class Fenetre extends JFrame {

	public Fenetre() {
		super("RobotWar");
		setSize(500, 500);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE); // permet de couper le
													// programme quand on ferme
													// la fenetre.
		setVisible(true);
	}

	@Override
	public void paint(Graphics g) {
		g.setColor(Color.BLUE);
		g.drawRect(0, 0, 50, 50); // Pour avoir juste les contours du rect
		g.fillRect(0, 0, 50, 50); // pour remplir le rectangle
	}

	public static void main(String[] args) {
		Fenetre maFenetre = new Fenetre();
	}

}

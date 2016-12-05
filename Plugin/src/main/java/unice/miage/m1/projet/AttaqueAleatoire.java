package unice.miage.m1.projet;

import java.awt.Point;
import java.io.Serializable;
import java.util.ArrayList;

public class AttaqueAleatoire implements IPluginAttaque, Serializable {

	private final int dommage = 50;

	private static final long serialVersionUID = 6098587523753839068L;

	public void attaque(IRobot robot, ArrayList<IRobot> listRobots) {
		Point posRobot = robot.getPosition();

		for (IRobot autreRobot : listRobots) {
			// Tu passes quand tu tombes sur le robot qui attaque
			if (robot.equals(autreRobot)) {
				continue;
			}

			// Position du robot de la liste
			Point posAutreRobot = autreRobot.getPosition();

			// Distance entre les deux robots
			double distance = Math.sqrt((posRobot.x - posAutreRobot.x) * (posRobot.x - posAutreRobot.x)
					+ (posRobot.y - posAutreRobot.y) * (posRobot.y - posAutreRobot.y));

			// Si les robots sont proche
			if (distance < 100) {
				

				// On récupère la vie de l'autre robot
				int vieAutreRobot = autreRobot.getVie();

				// On lui enlève de la vie
				autreRobot.setVie(vieAutreRobot - dommage);

				// On sort de la boucle
				break;
			}
		}
	}

}

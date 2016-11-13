package m1.miage.projet.pa;

import java.awt.Point;

public class PluginDeplacementAleatoire implements IPluginDeplacement {

	@Override
	public Point deplacement(Robot robot) {

		int x = robot.getPosition().x;
		int y = robot.getPosition().y;
		int pm = robot.getPtMouvement();

		int newX = (int) (Math.random() * ((x + pm) - (x - pm)));
		int newY = (int) (Math.random() * ((y + pm) - (y - pm)));
		
		
		return new Point(newX, newY);
	}

}

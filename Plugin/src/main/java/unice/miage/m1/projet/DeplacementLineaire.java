package unice.miage.m1.projet;

import java.awt.Point;
import java.io.Serializable;

public class DeplacementLineaire implements IPluginDeplacement, Serializable {

	int angle = (int) (Math.random() * 360);

	public boolean auBord(IRobot robot) {
		return (robot.getPosition().getX() + 20 > robot.xMax - 50 || robot.getPosition().getX() - 20 < 50
				|| robot.getPosition().getY() - 30 > robot.yMax - 50 || robot.getPosition().getY() + 30 < 50);
	}

	public Point deplacement(IRobot r, int v) {
		// TODO Auto-generated method stub
		r.setCap(angle);
		Point p = r.getPosition();
		if (this.auBord(r)) {
			r.tourner(180);
			this.angle = angle + 180;
		}
		float capEnRadian = r.getCap() * (float) (Math.PI / 180);
		p.x = (int) (p.x + v * (float) Math.cos(capEnRadian));
		p.y = (int) (p.y + v * (float) Math.sin(capEnRadian));
		return p;
	}

}

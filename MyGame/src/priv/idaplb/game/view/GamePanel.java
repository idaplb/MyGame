package priv.idaplb.game.view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import priv.idaplb.game.entities.Ground;
import priv.idaplb.game.entities.Shape;
import priv.idaplb.game.util.Global;

public class GamePanel extends JPanel{

	private Shape shape;
	private Ground ground;
	
	public GamePanel() {
		this.setSize(Global.LEN * Global.CELL_SIZE, Global.LEN * Global.CELL_SIZE);
	}

	public void display(Shape shape, Ground ground) {
		System.out.println("GamePanel's display");
		this.shape = shape;
		this.ground = ground;
		this.repaint();
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub

		g.setColor(Color.WHITE);
		g.fill3DRect(0, 0, Global.LEN * Global.CELL_SIZE, Global.LEN * Global.CELL_SIZE, true);
		if (null != shape && null != ground) {
			shape.drawMe(g);
			ground.drawMe(g);
		}
	}


}

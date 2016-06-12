package priv.idaplb.game.test;

import javax.swing.JFrame;

import priv.idaplb.game.controller.Controller;
import priv.idaplb.game.entities.Ground;
import priv.idaplb.game.entities.ShapeFactory;
import priv.idaplb.game.view.GamePanel;

public class Game {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ShapeFactory shapeFactory = new ShapeFactory();
		Ground ground = new Ground();
		GamePanel gamePanel = new GamePanel();
		Controller controller = new Controller(shapeFactory, ground, gamePanel);
		
		JFrame jFrame = new JFrame("MyGame");
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setSize(gamePanel.getWidth() + 16, gamePanel.getHeight() + 38);
		jFrame.add(gamePanel);
		gamePanel.addKeyListener(controller);
		jFrame.addKeyListener(controller);
		jFrame.setVisible(true);
		
		controller.newGame();

	}

}

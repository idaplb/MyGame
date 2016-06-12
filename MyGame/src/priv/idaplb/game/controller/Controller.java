package priv.idaplb.game.controller;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import priv.idaplb.game.entities.Ground;
import priv.idaplb.game.entities.Shape;
import priv.idaplb.game.entities.ShapeFactory;
import priv.idaplb.game.listener.ShapeListener;
import priv.idaplb.game.view.GamePanel;

public class Controller extends KeyAdapter implements ShapeListener{
	
	private Shape shape;
	private ShapeFactory shapeFactory;
	private Ground ground;
	private GamePanel gamePanel;
	
	public Controller(ShapeFactory shapeFactory, Ground ground, GamePanel gamePanel) {
		this.shapeFactory = shapeFactory;
		this.ground = ground;
		this.gamePanel = gamePanel;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
			if (ground.isMoveAble(shape, Shape.ROTATE)) {
				shape.rotate();
			}
			break;
		case KeyEvent.VK_LEFT:
			if (ground.isMoveAble(shape, Shape.LEFT)) {
				shape.moveLeft();
			}
			break;
		case KeyEvent.VK_DOWN:
			if (ground.isMoveAble(shape, Shape.DOWN)) {
				shape.moveDown();
			}
			break;
		case KeyEvent.VK_RIGHT:
			if (ground.isMoveAble(shape, Shape.RIGHT)) {
				shape.moveRight();
			}
			break;
		}
		gamePanel.display(shape, ground);
	}

	@Override
	public void shapeMoveDown(Shape shape) {
		// TODO Auto-generated method stub
		gamePanel.display(shape, ground);
	}
	
	@Override
	public synchronized boolean isMovaDownAble(Shape shape) {
		// TODO Auto-generated method stub
		
		if (ground.isMoveAble(shape, Shape.DOWN)) {
			return true;
		}
		ground.accpet(this.shape);
		this.shape = shapeFactory.getShape(this);
		return false;
	}

	public void newGame() {
		shape = shapeFactory.getShape(this);
	}

}

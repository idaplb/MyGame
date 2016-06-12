package priv.idaplb.game.entities;

import java.awt.Color;
import java.awt.Graphics;

import priv.idaplb.game.listener.ShapeListener;
import priv.idaplb.game.util.Global;

public class Shape {
	
	public static final int ROTATE = 0;
	public static final int LEFT = 1;
	public static final int RIGHT = 2;
	public static final int DOWN = 3;
	
	private int[][] body;
	private int status;
	private int left = 0, top = 0;
	
	ShapeListener shapeListener;
	
	public Shape() {
		new Thread(new ShapeDriver()).start();
	}

	public void moveLeft() {
		System.out.println("Shape's moveLeft");
		--left;
	}

	public void moveRight() {
		System.out.println("Shape's moveRight");
		++left;
	}

	public void moveDown() {
		System.out.println("Shape's moveDown");
		++top;
	}

	public void rotate() {
		System.out.println("Shape's rotate");
		status = (status + 1) % Global.STATUS;
	}

	public void drawMe(Graphics g) {
		System.out.println("Shape's drowMe");
		g.setColor(Color.BLUE);
		for (int i = 0; i < 4; ++i) {
			for (int j = 0; j < 4; ++j) {
				if (getFlag(i, j)) {
					g.fill3DRect((left + j) * Global.CELL_SIZE, (top + i) * Global.CELL_SIZE, Global.CELL_SIZE, Global.CELL_SIZE, true);
				}
			}
		}
	}
	
	private boolean getFlag(int x, int y) {
		return body[status][x * 4 + y] == 1;
	}
	
	public boolean isFlag(int x, int y, boolean flag) {
		int tempStatus = status;
		if (flag) {
			tempStatus = (tempStatus + 1) % Global.STATUS;
		}
		return body[tempStatus][x * 4 + y] == 1;
	}

	private class ShapeDriver implements Runnable {

		public void run() {
			while (shapeListener.isMovaDownAble(Shape.this)) {
				moveDown();
				shapeListener.shapeMoveDown(Shape.this);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public void addShapeListener(ShapeListener shapeListener) {
		if (null != shapeListener) {
			this.shapeListener = shapeListener;
		}
	}
	
	public void setBody(int[][] body) {
		this.body = body;
	}
	
	public void setStatus(int status) {
		this.status = status;
	}
	
	public int getTop() {
		return this.top;
	}
	
	public int getLeft() {
		return this.left;
	}

}

package priv.idaplb.game.entities;

import java.awt.Color;
import java.awt.Graphics;

import priv.idaplb.game.util.Global;

public class Ground {
	
	private int[][] bounds = new int[Global.LEN][Global.LEN];
	
	public void accpet(Shape shape) {
		
		for (int i = 0; i < 4; ++i) {
			for (int j = 0; j < 4; ++j) {
				if (shape.isFlag(i, j, false)) {
					bounds[shape.getLeft() + j][shape.getTop() + i] = 1;
				}
			}
		}
		
		for (int i = Global.LEN - 1; i >= 0; --i) {
			boolean flag = true;
			for (int j = 0; j < Global.LEN; ++j) {
				if (bounds[j][i] == 0) {
					flag = false;
				}
			}
			if (flag) {
				deleteLine(i);
			}
		}
	}
	
	private void deleteLine(int x) {
		for (int i = x; i > 0; --i) {
			for (int j = 0; j < bounds[i].length; ++j) {
				bounds[j][i] = bounds[j][i - 1];
			}
		}
		for (int i = 0; i < bounds[0].length; ++i) {
			bounds[i][0] = 0;
		}
	}
	
	public void drawMe(Graphics g) {
		g.setColor(Color.gray);
		System.out.println("Ground's drawMe");
		for (int i = 0; i < bounds.length; ++i) {
			for (int j = 0; j < bounds[i].length; ++j) {
				if (bounds[i][j] == 1) {
					g.fill3DRect(i * Global.CELL_SIZE, j * Global.CELL_SIZE, Global.CELL_SIZE, Global.CELL_SIZE, true);
				}
			}
		}
	}
	
	public boolean isMoveAble(Shape shape, int action) {
		int left = shape.getLeft();
		int top = shape.getTop();
		
		switch (action) {
		case Shape.LEFT:
			--left;
			break;
		case Shape.RIGHT:
			++left;
			break;
		case Shape.DOWN:
			++top;
			break;
		}
		for (int i = 0; i < 4; ++i) {
			for (int j = 0; j < 4; ++j) {
				if (shape.isFlag(i, j, action == Shape.ROTATE)) {
					if (left + j >= Global.LEN || left + j < 0 || top + i >= Global.LEN || top + i < 0 || bounds[left + j][top + i] == 1) {
						return false;
					}
				}
			}
		}
		return true;
	}

}

package priv.idaplb.game.entities;

import java.util.Random;

import priv.idaplb.game.listener.ShapeListener;

public class ShapeFactory {
	
	private int[][][] shapes = new int[][][] {
		{
			{
				1, 0, 0, 0,
				1, 1, 1, 0,
				0, 0, 0, 0,
				0, 0, 0, 0
			},
			{
				1, 1, 0, 0,
				1, 0, 0, 0,
				1, 0, 0, 0,
				0, 0, 0, 0
			},
			{
				1, 1, 1, 0,
				0, 0, 1, 0,
				0, 0, 0, 0,
				0, 0, 0, 0
			},
			{
				0, 1, 0, 0,
				0, 1, 0, 0,
				1, 1, 0, 0,
				0, 0, 0, 0
			}
		}
	};
	
	public Shape getShape(ShapeListener shapeListener) {
		System.out.println("ShapeFactory's getShape");
		Shape shape = new Shape();
		shape.addShapeListener(shapeListener);
		int type = new Random().nextInt(shapes.length);
		shape.setBody(shapes[type]);
		shape.setStatus(0);
		return shape;
	}

}

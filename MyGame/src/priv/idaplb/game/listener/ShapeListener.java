package priv.idaplb.game.listener;

import priv.idaplb.game.entities.Shape;

public interface ShapeListener {
	
	void shapeMoveDown(Shape shape);
	
	boolean isMovaDownAble(Shape shape);

}
